package de.thws.fiw.gymmanagement.application.service;

import de.thws.fiw.gymmanagement.domain.Booking;
import de.thws.fiw.gymmanagement.domain.Member;
import de.thws.fiw.gymmanagement.domain.Course;
import de.thws.fiw.gymmanagement.infrastructure.BookingRepositoryInterface;
import de.thws.fiw.gymmanagement.infrastructure.CourseRepository;
import de.thws.fiw.gymmanagement.infrastructure.CourseRepositoryInterface;
import de.thws.fiw.gymmanagement.infrastructure.MemberRepositoryInterface;

import java.time.LocalDate;
import java.util.List;

public class BookingService implements BookingServiceAdapter {

    BookingRepositoryInterface bookingRepository;
    MemberRepositoryInterface memberRepository;
    CourseRepositoryInterface courseRepository;

    public BookingService(BookingRepositoryInterface bookingRepository, MemberRepositoryInterface memberRepository, CourseRepositoryInterface courseRepository){
        this.bookingRepository=bookingRepository;
        this.memberRepository=memberRepository;
        this.courseRepository=courseRepository;
    }
    @Override
    public Booking createBooking(long member_Id, long course_Id, LocalDate bookingDate) {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    @Override
    public Booking getBooking(long id) {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    @Override
    public List<Booking> getBookingByMember(long memberId, int pageSize, int index) {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    @Override
    public List<Booking> getBookingByCourse(long courseId, int pageSize, int index) {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    @Override
    public List<Booking> getBookingByDate(String date, int pageSize, int index) {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    @Override
    public void deleteBooking(long id) {
        throw new UnsupportedOperationException("Not implemented yet");
    }
}
