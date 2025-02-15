package de.thws.fiw.gymmanagement.repository.test;

import de.thws.fiw.gymmanagement.domain.Booking;
import de.thws.fiw.gymmanagement.domain.Course;
import de.thws.fiw.gymmanagement.domain.Member;
import de.thws.fiw.gymmanagement.domain.Trainer;
import de.thws.fiw.gymmanagement.infrastructure.*;
import de.thws.fiw.gymmanagement.infrastructure.fakes.FakeBookingRepository;
import de.thws.fiw.gymmanagement.infrastructure.fakes.FakeCourseRepository;
import de.thws.fiw.gymmanagement.infrastructure.fakes.FakeMemberRepository;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public class BookingRepositoryTest {

    private static BookingRepositoryInterface bookingRepository;
    private static MemberRepositoryInterface memberRepository;
    private static CourseRepositoryInterface courseRepository;
    private static TrainerRepositoryInterface trainerRepository;


    @BeforeEach
    public void setUp() {
        bookingRepository = new BookingRepository();
        memberRepository = new MemberRepository();
        courseRepository = new CourseRepository();
        trainerRepository = new TrainerRepository();
    }

    @AfterAll
    public static void remove() {
        // Löscht alle Buchungen
        bookingRepository.deleteAll();

        // Löscht alle Mitglieder
        memberRepository.deleteAll();

        // Löscht alle Kurse
        courseRepository.deleteAll();

        // Löscht alle Trainer
        trainerRepository.deleteAll();
    }

    @Test
    public void testSaveAndFindById() {
        // Create a member using the builder
        Member member = new Member.Builder()
                .withName("TestMember")
                .withMembershipType("Gold")
                .build();
        member = memberRepository.save(member);

        // Create a trainer using the builder
        Trainer trainer = new Trainer.Builder()
                .withName("TestTrainer")
                .withExpertise("Expertise")
                .build();
        trainer = trainerRepository.save(trainer);

        // Create a course using the builder and persist it
        Course course = new Course.Builder()
                .withName("TestCourse")
                .withCapacity(30)
                .withTrainer(trainer)
                .build();
        course = courseRepository.save(course);

        // Create a booking using the builder
        Booking booking = new Booking.Builder()
                .withMember(member)
                .withCourse(course)
                .withBookingDate(LocalDate.now())
                .build();
        Booking savedBooking = bookingRepository.save(booking, member.getId(), course.getId());
        assertNotNull(savedBooking);
        assertNotNull(savedBooking.getId());

        Optional<Booking> found = bookingRepository.findById(savedBooking.getId());
        assertTrue(found.isPresent());
    }

    @Test
    public void testFindByMemberId() {
        Member member = new Member.Builder()
                .withName("TestMember")
                .withMembershipType("Gold")
                .build();
        member = memberRepository.save(member);

        Trainer trainer = new Trainer.Builder()
                .withName("TestTrainer")
                .withExpertise("Expertise")
                .build();
        trainer = trainerRepository.save(trainer);

        Course course = new Course.Builder()
                .withName("TestCourse")
                .withCapacity(30)
                .withTrainer(trainer)
                .build();
        course = courseRepository.save(course);

        Booking booking1 = new Booking.Builder()
                .withMember(member)
                .withCourse(course)
                .withBookingDate(LocalDate.now())
                .build();
        bookingRepository.save(booking1, member.getId(), course.getId());

        Booking booking2 = new Booking.Builder()
                .withMember(member)
                .withCourse(course)
                .withBookingDate(LocalDate.now())
                .build();
        bookingRepository.save(booking2, member.getId(), course.getId());

        List<Booking> bookings = bookingRepository.findByMemberId(member.getId());
        assertEquals(2, bookings.size());
    }

    @Test
    public void testFindByCourseId() {
        Member member = new Member.Builder()
                .withName("TestMember")
                .withMembershipType("Gold")
                .build();
        member = memberRepository.save(member);

        Trainer trainer = new Trainer.Builder()
                .withName("TestTrainer")
                .withExpertise("Expertise")
                .build();
        trainer = trainerRepository.save(trainer);

        Course course = new Course.Builder()
                .withName("TestCourse")
                .withCapacity(30)
                .withTrainer(trainer)
                .build();
        course = courseRepository.save(course);

        Booking booking1 = new Booking.Builder()
                .withMember(member)
                .withCourse(course)
                .withBookingDate(LocalDate.now())
                .build();
        bookingRepository.save(booking1, member.getId(), course.getId());

        Booking booking2 = new Booking.Builder()
                .withMember(member)
                .withCourse(course)
                .withBookingDate(LocalDate.now())
                .build();
        bookingRepository.save(booking2, member.getId(), course.getId());

        List<Booking> bookings = bookingRepository.findByCourseId(course.getId());
        assertEquals(2, bookings.size());
    }

    @Test
    public void testFindByDate() {
        Member member = new Member.Builder()
                .withName("TestMember")
                .withMembershipType("Gold")
                .build();
        member = memberRepository.save(member);

        Trainer trainer = new Trainer.Builder()
                .withName("TestTrainer")
                .withExpertise("Expertise")
                .build();
        trainer = trainerRepository.save(trainer);

        Course course = new Course.Builder()
                .withName("TestCourse")
                .withCapacity(30)
                .withTrainer(trainer)
                .build();
        course = courseRepository.save(course);

        LocalDate today = LocalDate.now();

        Booking booking1 = new Booking.Builder()
                .withMember(member)
                .withCourse(course)
                .withBookingDate(today)
                .build();
        bookingRepository.save(booking1, member.getId(), course.getId());

        Booking booking2 = new Booking.Builder()
                .withMember(member)
                .withCourse(course)
                .withBookingDate(today)
                .build();
        bookingRepository.save(booking2, member.getId(), course.getId());

        List<Booking> bookings = bookingRepository.findByDate(today);
        assertEquals(2, bookings.size());
    }

    @Test
    public void testDeleteBooking() {
        Member member = new Member.Builder()
                .withName("TestMember")
                .withMembershipType("Gold")
                .build();
        member = memberRepository.save(member);

        Trainer trainer = new Trainer.Builder()
                .withName("TestTrainer")
                .withExpertise("Expertise")
                .build();
        trainer = trainerRepository.save(trainer);

        Course course = new Course.Builder()
                .withName("TestCourse")
                .withCapacity(30)
                .withTrainer(trainer)
                .build();
        course = courseRepository.save(course);

        Booking booking = new Booking.Builder()
                .withMember(member)
                .withCourse(course)
                .withBookingDate(LocalDate.now())
                .build();
        Booking savedBooking = bookingRepository.save(booking, member.getId(), course.getId());
        bookingRepository.deleteById(savedBooking.getId());
        Optional<Booking> found = bookingRepository.findById(savedBooking.getId());
        assertFalse(found.isPresent());
    }
}
