package de.thws.fiw.gymmanagement.application.service;

import de.thws.fiw.gymmanagement.domain.Booking;
import de.thws.fiw.gymmanagement.domain.Member;
import de.thws.fiw.gymmanagement.domain.Course;
import java.time.LocalDate;
import java.util.List;

public interface BookingServiceAdapter {
    Booking createBooking(long member_Id, long course_Id, LocalDate bookingDate);
    Booking getBooking(long id);
    List<Booking> getBookingByMember(long memberId, int pageSize, int index);
    List<Booking> getBookingByCourse(long courseId, int pageSize, int index);
    List<Booking> getBookingByDate(String date, int pageSize, int index);
    void deleteBooking(long id);
}
