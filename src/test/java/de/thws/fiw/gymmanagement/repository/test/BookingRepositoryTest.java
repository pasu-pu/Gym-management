package de.thws.fiw.gymmanagement.repository.test;

import de.thws.fiw.gymmanagement.domain.Booking;
import de.thws.fiw.gymmanagement.domain.Course;
import de.thws.fiw.gymmanagement.domain.Member;
import de.thws.fiw.gymmanagement.domain.Trainer;
import de.thws.fiw.gymmanagement.infrastructure.BookingRepositoryInterface;
import de.thws.fiw.gymmanagement.infrastructure.CourseRepositoryInterface;
import de.thws.fiw.gymmanagement.infrastructure.MemberRepositoryInterface;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public class BookingRepositoryTest {

    private BookingRepositoryInterface bookingRepository;
    private MemberRepositoryInterface memberRepository;
    private CourseRepositoryInterface courseRepository;

    @BeforeEach
    public void setUp() {
        bookingRepository = new de.thws.fiw.gymmanagement.infrastructure.FakeBookingRepository();
        memberRepository = new de.thws.fiw.gymmanagement.infrastructure.FakeMemberRepository();
        courseRepository = new de.thws.fiw.gymmanagement.infrastructure.FakeCourseRepository();
    }

    @Test
    public void testSaveAndFindById() {
        // Create a member
        Member member = new Member();
        member.setName("TestMember");
        member.setMembershipType("Gold");
        member = memberRepository.save(member);

        // Create a trainer and course
        Trainer trainer = new Trainer();
        trainer.setName("TestTrainer");
        trainer.setExpertise("Expertise");
        trainer.setId(1L); // For fake repository, set manually if needed
        Course course = new Course();
        course.setName("TestCourse");
        course.setCapacity(30);
        course.setTrainer(trainer);
        course = courseRepository.save(course);

        // Create booking
        Booking booking = new Booking();
        booking.setMember(member);
        booking.setCourse(course);
        booking.setBookingDate(LocalDate.now());
        Booking savedBooking = bookingRepository.save(booking, member.getId(), course.getId());
        assertNotNull(savedBooking);
        assertNotNull(savedBooking.getId());

        Optional<Booking> found = bookingRepository.findById(savedBooking.getId());
        assertTrue(found.isPresent());
    }

    @Test
    public void testFindByMemberId() {
        Member member = new Member();
        member.setName("TestMember");
        member.setMembershipType("Gold");
        member = memberRepository.save(member);

        Trainer trainer = new Trainer();
        trainer.setName("TestTrainer");
        trainer.setExpertise("Expertise");
        trainer.setId(1L);

        Course course = new Course();
        course.setName("TestCourse");
        course.setCapacity(30);
        course.setTrainer(trainer);
        course = courseRepository.save(course);

        Booking booking1 = new Booking();
        booking1.setMember(member);
        booking1.setCourse(course);
        booking1.setBookingDate(LocalDate.now());
        bookingRepository.save(booking1, member.getId(), course.getId());

        Booking booking2 = new Booking();
        booking2.setMember(member);
        booking2.setCourse(course);
        booking2.setBookingDate(LocalDate.now());
        bookingRepository.save(booking2, member.getId(), course.getId());

        List<Booking> bookings = bookingRepository.findByMemberId(member.getId());
        assertEquals(2, bookings.size());
    }

    @Test
    public void testFindByCourseId() {
        Member member = new Member();
        member.setName("TestMember");
        member.setMembershipType("Gold");
        member = memberRepository.save(member);

        Trainer trainer = new Trainer();
        trainer.setName("TestTrainer");
        trainer.setExpertise("Expertise");
        trainer.setId(1L);

        Course course = new Course();
        course.setName("TestCourse");
        course.setCapacity(30);
        course.setTrainer(trainer);
        course = courseRepository.save(course);

        Booking booking1 = new Booking();
        booking1.setMember(member);
        booking1.setCourse(course);
        booking1.setBookingDate(LocalDate.now());
        bookingRepository.save(booking1, member.getId(), course.getId());

        Booking booking2 = new Booking();
        booking2.setMember(member);
        booking2.setCourse(course);
        booking2.setBookingDate(LocalDate.now());
        bookingRepository.save(booking2, member.getId(), course.getId());

        List<Booking> bookings = bookingRepository.findByCourseId(course.getId());
        assertEquals(2, bookings.size());
    }

    @Test
    public void testFindByDate() {
        Member member = new Member();
        member.setName("TestMember");
        member.setMembershipType("Gold");
        member = memberRepository.save(member);

        Trainer trainer = new Trainer();
        trainer.setName("TestTrainer");
        trainer.setExpertise("Expertise");
        trainer.setId(1L);

        Course course = new Course();
        course.setName("TestCourse");
        course.setCapacity(30);
        course.setTrainer(trainer);
        course = courseRepository.save(course);

        LocalDate today = LocalDate.now();

        Booking booking1 = new Booking();
        booking1.setMember(member);
        booking1.setCourse(course);
        booking1.setBookingDate(today);
        bookingRepository.save(booking1, member.getId(), course.getId());

        Booking booking2 = new Booking();
        booking2.setMember(member);
        booking2.setCourse(course);
        booking2.setBookingDate(today);
        bookingRepository.save(booking2, member.getId(), course.getId());

        List<Booking> bookings = bookingRepository.findByDate(today);
        assertEquals(2, bookings.size());
    }

    @Test
    public void testDeleteBooking() {
        Member member = new Member();
        member.setName("TestMember");
        member.setMembershipType("Gold");
        member = memberRepository.save(member);

        Trainer trainer = new Trainer();
        trainer.setName("TestTrainer");
        trainer.setExpertise("Expertise");
        trainer.setId(1L);

        Course course = new Course();
        course.setName("TestCourse");
        course.setCapacity(30);
        course.setTrainer(trainer);
        course = courseRepository.save(course);

        Booking booking = new Booking();
        booking.setMember(member);
        booking.setCourse(course);
        booking.setBookingDate(LocalDate.now());
        Booking savedBooking = bookingRepository.save(booking, member.getId(), course.getId());
        bookingRepository.deleteById(savedBooking.getId());
        Optional<Booking> found = bookingRepository.findById(savedBooking.getId());
        assertFalse(found.isPresent());
    }
}
