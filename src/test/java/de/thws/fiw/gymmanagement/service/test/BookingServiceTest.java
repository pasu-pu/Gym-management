package de.thws.fiw.gymmanagement.service.test;

import static org.junit.jupiter.api.Assertions.*;

import de.thws.fiw.gymmanagement.application.service.BookingService;
import de.thws.fiw.gymmanagement.domain.Booking;
import de.thws.fiw.gymmanagement.domain.Course;
import de.thws.fiw.gymmanagement.domain.Member;
import de.thws.fiw.gymmanagement.infrastructure.FakeBookingRepository;
import de.thws.fiw.gymmanagement.infrastructure.FakeCourseRepository;
import de.thws.fiw.gymmanagement.infrastructure.FakeMemberRepository;
import de.thws.fiw.gymmanagement.infrastructure.BookingRepositoryInterface;
import de.thws.fiw.gymmanagement.infrastructure.CourseRepositoryInterface;
import de.thws.fiw.gymmanagement.infrastructure.MemberRepositoryInterface;
import java.time.LocalDate;
import java.util.List;
import de.thws.fiw.gymmanagement.domain.Trainer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class BookingServiceTest {

    private BookingRepositoryInterface bookingRepository;
    private MemberRepositoryInterface memberRepository;
    private CourseRepositoryInterface courseRepository;
    private BookingService bookingService;

    @BeforeEach
    void setUp() {
        bookingRepository = new FakeBookingRepository();
        memberRepository = new FakeMemberRepository();
        courseRepository = new FakeCourseRepository();
        bookingService = new BookingService(bookingRepository, memberRepository, courseRepository);
    }

    @Test
    void testCreateBooking() {
        // Create member and course
        Member member = new Member();
        member.setName("Dave");
        member.setMembershipType("Basic");
        member = memberRepository.save(member);

        Trainer trainer = new Trainer();
        trainer.setName("Eve");
        trainer.setExpertise("Pilates");
        // For simplicity, create a course with a fake trainer
        Course course = new Course();
        course.setName("Pilates Class");
        course.setCapacity(15);
        course.setTrainer(trainer);
        course = courseRepository.save(course);

        LocalDate today = LocalDate.now();
        Booking booking = bookingService.createBooking(member.getId(), course.getId(), today);
        assertNotNull(booking);
        assertNotNull(booking.getId());
        assertEquals(member.getId(), booking.getMember().getId());
        assertEquals(course.getId(), booking.getCourse().getId());
        assertEquals(today, booking.getBookingDate());
    }

    @Test
    void testGetBooking() {
        Member member = new Member();
        member.setName("Dave");
        member.setMembershipType("Basic");
        member = memberRepository.save(member);

        Trainer trainer = new Trainer();
        trainer.setName("Eve");
        trainer.setExpertise("Pilates");

        Course course = new Course();
        course.setName("Pilates Class");
        course.setCapacity(15);
        course.setTrainer(trainer);
        course = courseRepository.save(course);

        LocalDate today = LocalDate.now();
        Booking booking = bookingService.createBooking(member.getId(), course.getId(), today);
        Booking fetched = bookingService.getBooking(booking.getId());
        assertNotNull(fetched);
        assertEquals(booking.getId(), fetched.getId());
    }

    @Test
    void testGetBookingByMember() {
        Member member = new Member();
        member.setName("Dave");
        member.setMembershipType("Basic");
        member = memberRepository.save(member);

        Trainer trainer = new Trainer();
        trainer.setName("Eve");
        trainer.setExpertise("Pilates");

        Course course = new Course();
        course.setName("Pilates Class");
        course.setCapacity(15);
        course.setTrainer(trainer);
        course = courseRepository.save(course);

        LocalDate today = LocalDate.now();
        bookingService.createBooking(member.getId(), course.getId(), today);
        bookingService.createBooking(member.getId(), course.getId(), today);

        List<Booking> bookings = bookingService.getBookingByMember(member.getId(), 10, 0);
        assertEquals(2, bookings.size());
    }

    @Test
    void testGetBookingByCourse() {
        Member member = new Member();
        member.setName("Dave");
        member.setMembershipType("Basic");
        member = memberRepository.save(member);

        Trainer trainer = new Trainer();
        trainer.setName("Eve");
        trainer.setExpertise("Pilates");

        Course course = new Course();
        course.setName("Pilates Class");
        course.setCapacity(15);
        course.setTrainer(trainer);
        course = courseRepository.save(course);

        LocalDate today = LocalDate.now();
        bookingService.createBooking(member.getId(), course.getId(), today);
        bookingService.createBooking(member.getId(), course.getId(), today);

        List<Booking> bookings = bookingService.getBookingByCourse(course.getId(), 10, 0);
        assertEquals(2, bookings.size());
    }

    @Test
    void testGetBookingByDate() {
        Member member = new Member();
        member.setName("Dave");
        member.setMembershipType("Basic");
        member = memberRepository.save(member);

        Trainer trainer = new Trainer();
        trainer.setName("Eve");
        trainer.setExpertise("Pilates");

        Course course = new Course();
        course.setName("Pilates Class");
        course.setCapacity(15);
        course.setTrainer(trainer);
        course = courseRepository.save(course);

        LocalDate today = LocalDate.now();
        bookingService.createBooking(member.getId(), course.getId(), today);
        bookingService.createBooking(member.getId(), course.getId(), today);

        List<Booking> bookings = bookingService.getBookingByDate(today.toString(), 10, 0);
        assertEquals(2, bookings.size());
    }

    @Test
    void testDeleteBooking() {
        Member member = new Member();
        member.setName("Dave");
        member.setMembershipType("Basic");
        member = memberRepository.save(member);

        Trainer trainer = new Trainer();
        trainer.setName("Eve");
        trainer.setExpertise("Pilates");

        Course course = new Course();
        course.setName("Pilates Class");
        course.setCapacity(15);
        course.setTrainer(trainer);
        course = courseRepository.save(course);

        LocalDate today = LocalDate.now();
        Booking booking = bookingService.createBooking(member.getId(), course.getId(), today);
        bookingService.deleteBooking(booking.getId());
        Booking fetched = bookingService.getBooking(booking.getId());
        assertNull(fetched);
    }
}
