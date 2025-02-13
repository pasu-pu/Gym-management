package de.thws.fiw.gymmanagement.domain;

import de.thws.fiw.gymmanagement.domain.Booking;

import java.time.LocalDate;
import java.util.List;

public interface BookingLogicAdapter {
    Booking createBooking(long member_Id, long course_Id, LocalDate bookingDate);
    Booking getBooking(long id);
    List<Booking> getBookingByMember(long memberId, int pageSize, int index);
    List<Booking> getBookingByCourse(long courseId, int pageSize, int index);
    List<Booking> getBookingByDate(String date, int pageSize, int index);
    void deleteBooking(long id);
}
