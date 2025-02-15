package de.thws.fiw.gymmanagement.logic.test;

import static org.junit.jupiter.api.Assertions.*;

import de.thws.fiw.gymmanagement.domain.BookingLogic;
import de.thws.fiw.gymmanagement.domain.Booking;
import de.thws.fiw.gymmanagement.domain.Course;
import de.thws.fiw.gymmanagement.domain.Member;
import de.thws.fiw.gymmanagement.domain.Trainer;
import de.thws.fiw.gymmanagement.infrastructure.TrainerRepositoryInterface;
import de.thws.fiw.gymmanagement.infrastructure.fakes.FakeBookingRepository;
import de.thws.fiw.gymmanagement.infrastructure.fakes.FakeCourseRepository;
import de.thws.fiw.gymmanagement.infrastructure.fakes.FakeMemberRepository;
import de.thws.fiw.gymmanagement.infrastructure.BookingRepositoryInterface;
import de.thws.fiw.gymmanagement.infrastructure.CourseRepositoryInterface;
import de.thws.fiw.gymmanagement.infrastructure.MemberRepositoryInterface;
import java.time.LocalDate;
import java.util.List;

import de.thws.fiw.gymmanagement.infrastructure.fakes.FakeTrainerRepository;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class BookingLogicTest {

    private BookingRepositoryInterface bookingRepository;
    private MemberRepositoryInterface memberRepository;
    private CourseRepositoryInterface courseRepository;
    private TrainerRepositoryInterface trainerRepository;
    private BookingLogic bookingLogicTest;

    @BeforeEach
    void setUp() {
        bookingRepository = new FakeBookingRepository();
        memberRepository = new FakeMemberRepository();
        courseRepository = new FakeCourseRepository();
        trainerRepository = new FakeTrainerRepository();
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
        trainer = trainerRepository.save(trainer);

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
    void testCreateBookingFailsWhenAlreadyBooked() {
        Member member = new Member.Builder()
                .withName("John")
                .withMembershipType("Basic")
                .build();
        member = memberRepository.save(member);

        Trainer trainer = new Trainer.Builder()
                .withName("Jane")
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
        // Erstes Booking erfolgreich
        bookingLogicTest.createBooking(member.getId(), course.getId(), today);

        // Zweites Booking sollte fehlschlagen, da Mitglied bereits für diesen Kurs gebucht ist
        Member finalMember = member;
        Course finalCourse = course;
        Exception exception = assertThrows(RuntimeException.class, () -> {
            bookingLogicTest.createBooking(finalMember.getId(), finalCourse.getId(), today);
        });

        assertEquals("Member already has a booking for this course", exception.getMessage());
    }

    @Test
    void testCreateBookingFailsWhenCourseCapacityExceeded() {
        Trainer trainer = new Trainer.Builder()
                .withName("Jane")
                .withExpertise("Yoga")
                .build();
        trainer = trainerRepository.save(trainer);

        Course course = new Course.Builder()
                .withName("Yoga Class")
                .withCapacity(1)
                .withTrainer(trainer)
                .build();
        course = courseRepository.save(course);

        Member firstMember = new Member.Builder()
                .withName("John")
                .withMembershipType("Basic")
                .build();
        firstMember = memberRepository.save(firstMember);

        Member secondMember = new Member.Builder()
                .withName("Sarah")
                .withMembershipType("Premium")
                .build();
        secondMember = memberRepository.save(secondMember);

        LocalDate today = LocalDate.now();

        // First booking successful
        bookingLogicTest.createBooking(firstMember.getId(), course.getId(), today);

        // Second booking should fail due to capacity limit
        Member finalSecondMember = secondMember;
        Course finalCourse = course;
        Exception exception = assertThrows(RuntimeException.class, () -> {
            bookingLogicTest.createBooking(finalSecondMember.getId(), finalCourse.getId(), today);
        });

        assertEquals("Course capacity reached: Unable to book", exception.getMessage());
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
        trainer = trainerRepository.save(trainer);

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
        trainer = trainerRepository.save(trainer);

        Course course = new Course.Builder()
                .withName("Pilates Class")
                .withCapacity(15)
                .withTrainer(trainer)
                .build();
        course = courseRepository.save(course);

        LocalDate today = LocalDate.now();
        bookingLogicTest.createBooking(member.getId(), course.getId(), today);

        List<Booking> bookings = bookingLogicTest.getBookingByMember(member.getId(), 10, 0);
        assertEquals(1, bookings.size());
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
        trainer = trainerRepository.save(trainer);

        Course course = new Course.Builder()
                .withName("Pilates Class")
                .withCapacity(15)
                .withTrainer(trainer)
                .build();
        course = courseRepository.save(course);

        LocalDate today = LocalDate.now();
        bookingLogicTest.createBooking(member.getId(), course.getId(), today);

        List<Booking> bookings = bookingLogicTest.getBookingByCourse(course.getId(), 10, 0);
        assertEquals(1, bookings.size());
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
        trainer = trainerRepository.save(trainer);

        Course course = new Course.Builder()
                .withName("Pilates Class")
                .withCapacity(15)
                .withTrainer(trainer)
                .build();
        course = courseRepository.save(course);

        LocalDate today = LocalDate.now();
        bookingLogicTest.createBooking(member.getId(), course.getId(), today);

        List<Booking> bookings = bookingLogicTest.getBookingByDate(today.toString(), 10, 0);
        assertEquals(1, bookings.size());
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
        trainer = trainerRepository.save(trainer);

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