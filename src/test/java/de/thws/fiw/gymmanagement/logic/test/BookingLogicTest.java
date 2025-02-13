package de.thws.fiw.gymmanagement.logic.test;

import static org.junit.jupiter.api.Assertions.*;

import de.thws.fiw.gymmanagement.domain.BookingLogic;
import de.thws.fiw.gymmanagement.domain.Booking;
import de.thws.fiw.gymmanagement.domain.Course;
import de.thws.fiw.gymmanagement.domain.Member;
import de.thws.fiw.gymmanagement.domain.Trainer;
import de.thws.fiw.gymmanagement.infrastructure.fakes.FakeBookingRepository;
import de.thws.fiw.gymmanagement.infrastructure.fakes.FakeCourseRepository;
import de.thws.fiw.gymmanagement.infrastructure.fakes.FakeMemberRepository;
import de.thws.fiw.gymmanagement.infrastructure.BookingRepositoryInterface;
import de.thws.fiw.gymmanagement.infrastructure.CourseRepositoryInterface;
import de.thws.fiw.gymmanagement.infrastructure.MemberRepositoryInterface;
import java.time.LocalDate;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class BookingLogicTest {

    private BookingRepositoryInterface bookingRepository;
    private MemberRepositoryInterface memberRepository;
    private CourseRepositoryInterface courseRepository;
    private BookingLogic bookingLogicTest;

    @BeforeEach
    void setUp() {
        bookingRepository = new FakeBookingRepository();
        memberRepository = new FakeMemberRepository();
        courseRepository = new FakeCourseRepository();
        bookingLogicTest = new BookingLogic(bookingRepository, memberRepository, courseRepository);
    }

    @Test
    void testCreateBooking() {
        // Create member using builder
        Member member = new Member.Builder()
                .withName("Dave")
                .withMembershipType("Basic")
                .build();
        member = memberRepository.save(member);

        // Create trainer using builder
        Trainer trainer = new Trainer.Builder()
                .withName("Eve")
                .withExpertise("Pilates")
                .build();

        // Create course using builder
        Course course = new Course.Builder()
                .withName("Pilates Class")
                .withCapacity(15)
                .withTrainer(trainer)
                .build();
        course = courseRepository.save(course);

        LocalDate today = LocalDate.now();
        Booking booking = bookingLogicTest.createBooking(member.getId(), course.getId(), today);
        assertNotNull(booking);
        assertNotNull(booking.getId());
        assertEquals(member.getId(), booking.getMember().getId());
        assertEquals(course.getId(), booking.getCourse().getId());
        assertEquals(today, booking.getBookingDate());
    }

    @Test
    void testGetBooking() {
        Member member = new Member.Builder()
                .withName("Dave")
                .withMembershipType("Basic")
                .build();
        member = memberRepository.save(member);

        Trainer trainer = new Trainer.Builder()
                .withName("Eve")
                .withExpertise("Pilates")
                .build();

        Course course = new Course.Builder()
                .withName("Pilates Class")
                .withCapacity(15)
                .withTrainer(trainer)
                .build();
        course = courseRepository.save(course);

        LocalDate today = LocalDate.now();
        Booking booking = bookingLogicTest.createBooking(member.getId(), course.getId(), today);
        Booking fetched = bookingLogicTest.getBooking(booking.getId());
        assertNotNull(fetched);
        assertEquals(booking.getId(), fetched.getId());
    }

    @Test
    void testGetBookingByMember() {
        Member member = new Member.Builder()
                .withName("Dave")
                .withMembershipType("Basic")
                .build();
        member = memberRepository.save(member);

        Trainer trainer = new Trainer.Builder()
                .withName("Eve")
                .withExpertise("Pilates")
                .build();

        Course course = new Course.Builder()
                .withName("Pilates Class")
                .withCapacity(15)
                .withTrainer(trainer)
                .build();
        course = courseRepository.save(course);

        LocalDate today = LocalDate.now();
        bookingLogicTest.createBooking(member.getId(), course.getId(), today);
        bookingLogicTest.createBooking(member.getId(), course.getId(), today);

        List<Booking> bookings = bookingLogicTest.getBookingByMember(member.getId(), 10, 0);
        assertEquals(2, bookings.size());
    }

    @Test
    void testGetBookingByCourse() {
        Member member = new Member.Builder()
                .withName("Dave")
                .withMembershipType("Basic")
                .build();
        member = memberRepository.save(member);

        Trainer trainer = new Trainer.Builder()
                .withName("Eve")
                .withExpertise("Pilates")
                .build();

        Course course = new Course.Builder()
                .withName("Pilates Class")
                .withCapacity(15)
                .withTrainer(trainer)
                .build();
        course = courseRepository.save(course);

        LocalDate today = LocalDate.now();
        bookingLogicTest.createBooking(member.getId(), course.getId(), today);
        bookingLogicTest.createBooking(member.getId(), course.getId(), today);

        List<Booking> bookings = bookingLogicTest.getBookingByCourse(course.getId(), 10, 0);
        assertEquals(2, bookings.size());
    }

    @Test
    void testGetBookingByDate() {
        Member member = new Member.Builder()
                .withName("Dave")
                .withMembershipType("Basic")
                .build();
        member = memberRepository.save(member);

        Trainer trainer = new Trainer.Builder()
                .withName("Eve")
                .withExpertise("Pilates")
                .build();

        Course course = new Course.Builder()
                .withName("Pilates Class")
                .withCapacity(15)
                .withTrainer(trainer)
                .build();
        course = courseRepository.save(course);

        LocalDate today = LocalDate.now();
        bookingLogicTest.createBooking(member.getId(), course.getId(), today);
        bookingLogicTest.createBooking(member.getId(), course.getId(), today);

        List<Booking> bookings = bookingLogicTest.getBookingByDate(today.toString(), 10, 0);
        assertEquals(2, bookings.size());
    }

    @Test
    void testDeleteBooking() {
        Member member = new Member.Builder()
                .withName("Dave")
                .withMembershipType("Basic")
                .build();
        member = memberRepository.save(member);

        Trainer trainer = new Trainer.Builder()
                .withName("Eve")
                .withExpertise("Pilates")
                .build();

        Course course = new Course.Builder()
                .withName("Pilates Class")
                .withCapacity(15)
                .withTrainer(trainer)
                .build();
        course = courseRepository.save(course);

        LocalDate today = LocalDate.now();
        Booking booking = bookingLogicTest.createBooking(member.getId(), course.getId(), today);
        bookingLogicTest.deleteBooking(booking.getId());
        Booking fetched = bookingLogicTest.getBooking(booking.getId());
        assertNull(fetched);
    }
}
