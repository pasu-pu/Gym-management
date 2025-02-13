package de.thws.fiw.gymmanagement.integration.test;

import de.thws.fiw.gymmanagement.application.CreateBookingRequest;
import de.thws.fiw.gymmanagement.application.GetBookingRequest;
import de.thws.fiw.gymmanagement.application.BookingServiceGrpc;
import de.thws.fiw.gymmanagement.application.BookingServiceImpl;
import de.thws.fiw.gymmanagement.application.service.BookingService;
import de.thws.fiw.gymmanagement.infrastructure.BookingRepository;
import de.thws.fiw.gymmanagement.infrastructure.CourseRepository;
import de.thws.fiw.gymmanagement.infrastructure.MemberRepository;
import de.thws.fiw.gymmanagement.domain.Member;
import de.thws.fiw.gymmanagement.domain.Course;
import de.thws.fiw.gymmanagement.domain.Trainer;
import de.thws.fiw.gymmanagement.infrastructure.TrainerRepository;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.Server;
import io.grpc.ServerBuilder;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

public class BookingServiceIntegrationTest {

    private static Server server;
    private static ManagedChannel channel;
    private static BookingServiceGrpc.BookingServiceBlockingStub bookingStub;

    // We'll use the actual repository implementations (assumed to be configured for an in-memory DB)
    private static MemberRepository memberRepository;
    private static CourseRepository courseRepository;
    private static BookingRepository bookingRepository;
    private static TrainerRepository trainerRepository;

    @BeforeAll
    public static void startServer() throws Exception {
        // Create repositories
        memberRepository = new MemberRepository();
        courseRepository = new CourseRepository();
        bookingRepository = new BookingRepository();
        trainerRepository = new TrainerRepository();

        // Create necessary entities
        Member member = new Member();
        member.setName("IntegrationMember");
        member.setMembershipType("Silver");
        member = memberRepository.save(member);

        Trainer trainer = new Trainer();
        trainer.setName("IntegrationTrainer");
        trainer.setExpertise("Pilates");
        trainer = trainerRepository.save(trainer);

        Course course = new Course();
        course.setName("IntegrationCourse");
        course.setCapacity(20);
        course.setTrainer(trainer);
        course = courseRepository.save(course);

        // Create Booking service
        BookingService bookingService = new BookingService(bookingRepository, memberRepository, courseRepository);
        var serviceImpl = new BookingServiceImpl(bookingService);

        server = ServerBuilder.forPort(8081)
                .addService(serviceImpl)
                .build()
                .start();

        channel = ManagedChannelBuilder.forAddress("localhost", 8081)
                .usePlaintext()
                .build();
        bookingStub = BookingServiceGrpc.newBlockingStub(channel);
    }

    @AfterAll
    public static void stopServer() throws Exception {
        channel.shutdownNow();
        server.shutdownNow();
    }

    @Test
    public void testCreateAndGetBooking() {
        // Assume a member and course already exist from setUp
        Member member = memberRepository.findAll().get(0);
        Course course = courseRepository.findAll().get(0);
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
}
