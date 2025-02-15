package de.thws.fiw.gymmanagement.integration.test;

import de.thws.fiw.gymmanagement.application.*;
import de.thws.fiw.gymmanagement.domain.BookingLogic;
import de.thws.fiw.gymmanagement.infrastructure.*;
import de.thws.fiw.gymmanagement.domain.Member;
import de.thws.fiw.gymmanagement.domain.Course;
import de.thws.fiw.gymmanagement.domain.Trainer;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.StatusRuntimeException;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

public class BookingLogicIntegrationTest {

    private static Server server;
    private static ManagedChannel channel;
    private static BookingServiceGrpc.BookingServiceBlockingStub bookingStub;

    private static MemberRepositoryInterface memberRepository;
    private static CourseRepositoryInterface courseRepository;
    private static BookingRepositoryInterface bookingRepository;
    private static TrainerRepositoryInterface trainerRepository;

    @BeforeAll
    public static void startServer() throws Exception {
        memberRepository = new MemberRepository();
        courseRepository = new CourseRepository();
        bookingRepository = new BookingRepository();
        trainerRepository = new TrainerRepository();

        BookingLogic bookingLogic = new BookingLogic(bookingRepository, memberRepository, courseRepository);
        BookingServiceImpl serviceImpl = new BookingServiceImpl(bookingLogic);

        server = ServerBuilder.forPort(8080)
                .addService(serviceImpl)
                .build()
                .start();

        channel = ManagedChannelBuilder.forAddress("localhost", 8080)
                .usePlaintext()
                .build();
        bookingStub = BookingServiceGrpc.newBlockingStub(channel);
    }

    @AfterAll
    public static void stopServer() {
        channel.shutdownNow();
        server.shutdownNow();
    }

    @AfterEach
    public void cleanDatabase() {
        // Löscht alle Objekte aus der Datenbank nach jedem Test
        bookingRepository.deleteAll();
        memberRepository.deleteAll();
        courseRepository.deleteAll();
        trainerRepository.deleteAll();
    }

    @Test
    public void testCreateAndGetBooking() {
        Member member = new Member.Builder()
                .withName("IntegrationMember")
                .withMembershipType("Silver")
                .build();
        member = memberRepository.save(member);

        Trainer trainer = new Trainer.Builder()
                .withName("IntegrationTrainer")
                .withExpertise("Pilates")
                .build();
        trainer = trainerRepository.save(trainer);

        Course course = new Course.Builder()
                .withName("IntegrationCourse")
                .withCapacity(20)
                .withTrainer(trainer)
                .build();
        course = courseRepository.save(course);

        LocalDate today = LocalDate.now();

        CreateBookingRequest createRequest = CreateBookingRequest.newBuilder()
                .setMemberId(member.getId())
                .setCourseId(course.getId())
                .setBookingDate(today.toString())
                .build();
        var createResponse = bookingStub.createBooking(createRequest);
        assertTrue(createResponse.getBookingId() > 0);

        var getRequest = GetBookingRequest.newBuilder()
                .setBookingId(createResponse.getBookingId())
                .build();
        var getResponse = bookingStub.getBooking(getRequest);
        assertEquals(member.getId(), getResponse.getMemberId());
        assertEquals(course.getId(), getResponse.getCourseId());
        assertEquals(today.toString(), getResponse.getBookingDate());
    }

    @Test
    public void testCreateBookingFailsWhenAlreadyBooked() {
        Member member = new Member.Builder()
                .withName("TestMember")
                .withMembershipType("Basic")
                .build();
        member = memberRepository.save(member);

        Trainer trainer = new Trainer.Builder()
                .withName("TestTrainer")
                .withExpertise("Yoga")
                .build();
        trainer = trainerRepository.save(trainer);

        Course course = new Course.Builder()
                .withName("Yoga Class")
                .withCapacity(10)
                .withTrainer(trainer)
                .build();
        course = courseRepository.save(course);

        LocalDate today = LocalDate.now();

        CreateBookingRequest createRequest = CreateBookingRequest.newBuilder()
                .setMemberId(member.getId())
                .setCourseId(course.getId())
                .setBookingDate(today.toString())
                .build();

        bookingStub.createBooking(createRequest);

        StatusRuntimeException exception = assertThrows(StatusRuntimeException.class, () -> {
            bookingStub.createBooking(createRequest);
        });
        assertEquals("Member already has a booking for this course", exception.getStatus().getDescription());
    }

    @Test
    public void testCreateBookingFailsWhenCourseCapacityExceeded() {
        Member member1 = new Member.Builder().withName("Member1").withMembershipType("Gold").build();
        member1 = memberRepository.save(member1);

        Member member2 = new Member.Builder().withName("Member2").withMembershipType("Gold").build();
        member2 = memberRepository.save(member2);

        Trainer trainer = new Trainer.Builder()
                .withName("TestTrainer")
                .withExpertise("Yoga")
                .build();
        trainer = trainerRepository.save(trainer);

        Course course = new Course.Builder()
                .withName("Yoga Class")
                .withCapacity(1)
                .withTrainer(trainer)
                .build();
        course = courseRepository.save(course);

        LocalDate today = LocalDate.now();

        CreateBookingRequest createRequest1 = CreateBookingRequest.newBuilder()
                .setMemberId(member1.getId())
                .setCourseId(course.getId())
                .setBookingDate(today.toString())
                .build();
        bookingStub.createBooking(createRequest1);

        CreateBookingRequest createRequest2 = CreateBookingRequest.newBuilder()
                .setMemberId(member2.getId())
                .setCourseId(course.getId())
                .setBookingDate(today.toString())
                .build();

        StatusRuntimeException exception = assertThrows(StatusRuntimeException.class, () -> {
            bookingStub.createBooking(createRequest2);
        });
        assertEquals("Course capacity reached: Unable to book", exception.getStatus().getDescription());
    }


    @Test
    public void testGetBookingByMember() {
        Member member = new Member.Builder()
                .withName("MemberTest")
                .withMembershipType("Bronze")
                .build();
        member = memberRepository.save(member);

        Trainer trainer = new Trainer.Builder()
                .withName("TrainerTest")
                .withExpertise("Fitness")
                .build();
        trainer = trainerRepository.save(trainer);

        Course course = new Course.Builder()
                .withName("Fitness Course")
                .withCapacity(10)
                .withTrainer(trainer)
                .build();
        course = courseRepository.save(course);

        LocalDate today = LocalDate.now();

        CreateBookingRequest createRequest = CreateBookingRequest.newBuilder()
                .setMemberId(member.getId())
                .setCourseId(course.getId())
                .setBookingDate(today.toString())
                .build();
        bookingStub.createBooking(createRequest);

        GetBookingByMemberRequest request = GetBookingByMemberRequest.newBuilder()
                .setMemberId(member.getId())
                .setPagesize(10)
                .setIndex(0)
                .build();
        GetAllBookingsResponse response = bookingStub.getBookingByMember(request);

        assertEquals(1, response.getBookingsCount());
        assertEquals(member.getId(), response.getBookings(0).getMemberId());
    }

    @Test
    public void testGetBookingByCourse() {
        Member member = new Member.Builder()
                .withName("CourseMember")
                .withMembershipType("Silver")
                .build();
        member = memberRepository.save(member);

        Trainer trainer = new Trainer.Builder()
                .withName("CourseTrainer")
                .withExpertise("Swimming")
                .build();
        trainer = trainerRepository.save(trainer);

        Course course = new Course.Builder()
                .withName("Swimming Course")
                .withCapacity(8)
                .withTrainer(trainer)
                .build();
        course = courseRepository.save(course);

        LocalDate today = LocalDate.now();

        CreateBookingRequest createRequest = CreateBookingRequest.newBuilder()
                .setMemberId(member.getId())
                .setCourseId(course.getId())
                .setBookingDate(today.toString())
                .build();
        bookingStub.createBooking(createRequest);

        GetBookingByCourseRequest request = GetBookingByCourseRequest.newBuilder()
                .setCourseId(course.getId())
                .setPagesize(10)
                .setIndex(0)
                .build();
        GetAllBookingsResponse response = bookingStub.getBookingByCourse(request);

        assertEquals(1, response.getBookingsCount());
        assertEquals(course.getId(), response.getBookings(0).getCourseId());
    }

    @Test
    public void testGetBookingByDate() {
        Member member = new Member.Builder()
                .withName("DateMember")
                .withMembershipType("Gold")
                .build();
        member = memberRepository.save(member);

        Trainer trainer = new Trainer.Builder()
                .withName("DateTrainer")
                .withExpertise("Dancing")
                .build();
        trainer = trainerRepository.save(trainer);

        Course course = new Course.Builder()
                .withName("Dancing Course")
                .withCapacity(12)
                .withTrainer(trainer)
                .build();
        course = courseRepository.save(course);

        LocalDate today = LocalDate.now();

        CreateBookingRequest createRequest = CreateBookingRequest.newBuilder()
                .setMemberId(member.getId())
                .setCourseId(course.getId())
                .setBookingDate(today.toString())
                .build();
        bookingStub.createBooking(createRequest);

        GetBookingByDateRequest request = GetBookingByDateRequest.newBuilder()
                .setBookingDate(today.toString())
                .setPagesize(10)
                .setIndex(0)
                .build();
        GetAllBookingsResponse response = bookingStub.getBookingByDate(request);

        assertEquals(1, response.getBookingsCount());
        assertEquals(today.toString(), response.getBookings(0).getBookingDate());
    }

    @Test
    public void testDeleteBooking() {
        Member member = new Member.Builder()
                .withName("DeleteMember")
                .withMembershipType("Platinum")
                .build();
        member = memberRepository.save(member);

        Trainer trainer = new Trainer.Builder()
                .withName("DeleteTrainer")
                .withExpertise("Boxing")
                .build();
        trainer = trainerRepository.save(trainer);

        Course course = new Course.Builder()
                .withName("Boxing Course")
                .withCapacity(15)
                .withTrainer(trainer)
                .build();
        course = courseRepository.save(course);

        LocalDate today = LocalDate.now();

        CreateBookingRequest createRequest = CreateBookingRequest.newBuilder()
                .setMemberId(member.getId())
                .setCourseId(course.getId())
                .setBookingDate(today.toString())
                .build();
        var createResponse = bookingStub.createBooking(createRequest);

        DeleteBookingRequest deleteRequest = DeleteBookingRequest.newBuilder()
                .setBookingId(createResponse.getBookingId())
                .build();
        bookingStub.deleteBooking(deleteRequest);

        GetBookingRequest getRequest = GetBookingRequest.newBuilder()
                .setBookingId(createResponse.getBookingId())
                .build();
        StatusRuntimeException exception = assertThrows(StatusRuntimeException.class, () -> {
            bookingStub.getBooking(getRequest);
        });
        assertEquals("Booking not found", exception.getStatus().getDescription());
    }
}