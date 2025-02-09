package de.thws.fiw.gymmanagement.application.service;

import de.thws.fiw.gymmanagement.domain.Booking;
import de.thws.fiw.gymmanagement.domain.Course;
import de.thws.fiw.gymmanagement.domain.Member;
import de.thws.fiw.gymmanagement.infrastructure.BookingRepositoryInterface;
import de.thws.fiw.gymmanagement.infrastructure.CourseRepositoryInterface;
import de.thws.fiw.gymmanagement.infrastructure.MemberRepositoryInterface;

import java.time.LocalDate;
import java.util.List;

public class BookingService {
    private final BookingRepositoryInterface bookingRepository;
    private final MemberRepositoryInterface memberRepository;
    private final CourseRepositoryInterface courseRepository;

    public BookingService(BookingRepositoryInterface bookingRepository, MemberRepositoryInterface memberRepository, CourseRepositoryInterface courseRepository) {
        this.bookingRepository = bookingRepository;
        this.memberRepository = memberRepository;
        this.courseRepository = courseRepository;
    }

    public Booking createBooking(Long memberId, Long courseId) {
        Member member = memberRepository.findById(memberId)
                .orElseThrow(() -> new RuntimeException("Member not found"));

        Course course = courseRepository.findById(courseId)
                .orElseThrow(() -> new RuntimeException("Course not found"));

        Booking booking = new Booking();
        booking.setMember(member);
        booking.setCourse(course);
        booking.setBookingDate(LocalDate.now());

        return bookingRepository.save(booking, memberId, courseId);
    }

    public List<Booking> getBookingsByMember(Long memberId) {
        return bookingRepository.findByMemberId(memberId);
    }

    public List<Booking> getBookingsByCourse(Long courseId) {
        return bookingRepository.findByCourseId(courseId);
    }

    public boolean deleteBooking(Long bookingId) {
        return bookingRepository.findById(bookingId)
                .map(booking -> {
                    bookingRepository.deleteById(booking.getId());
                    return true;
                })
                .orElse(false);
    }
}
