package de.thws.fiw.gymmanagement.domain;

import de.thws.fiw.gymmanagement.infrastructure.BookingRepositoryInterface;
import de.thws.fiw.gymmanagement.infrastructure.CourseRepositoryInterface;
import de.thws.fiw.gymmanagement.infrastructure.MemberRepositoryInterface;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class BookingLogic implements BookingLogicAdapter {

    private final BookingRepositoryInterface bookingRepository;
    private final MemberRepositoryInterface memberRepository;
    private final CourseRepositoryInterface courseRepository;

    public BookingLogic(BookingRepositoryInterface bookingRepository,
                        MemberRepositoryInterface memberRepository,
                        CourseRepositoryInterface courseRepository) {
        this.bookingRepository = bookingRepository;
        this.memberRepository = memberRepository;
        this.courseRepository = courseRepository;
    }

    @Override
    public Booking createBooking(long member_Id, long course_Id, LocalDate bookingDate) {
        System.out.println("[BookingLogic] createBooking called with memberId: " + member_Id
                + ", courseId: " + course_Id + ", bookingDate: " + bookingDate);
        try {
            System.out.println("[BookingLogic] Fetching Member with id: " + member_Id);
            Member member = memberRepository.findById(member_Id)
                    .orElseThrow(() -> new RuntimeException("Member not found"));

            System.out.println("[BookingLogic] Fetching Course with id: " + course_Id);
            Course course = courseRepository.findById(course_Id)
                    .orElseThrow(() -> new RuntimeException("Course not found"));

            // Prüfe die Anzahl der aktuellen Buchungen für den Kurs
            List<Booking> existingBookings = bookingRepository.findByCourseId(course_Id);
            if (existingBookings.size() >= course.getCapacity()) {
                System.err.println("[BookingLogic] Booking failed: Course capacity reached");
                throw new RuntimeException("Course capacity reached: Unable to book");
            }

            // Überprüfen, ob der Member bereits eine Buchung für diesen Kurs hat
            boolean hasExistingBooking = existingBookings.stream()
                    .anyMatch(booking -> booking.getMember().getId().equals(member_Id));

            if (hasExistingBooking) {
                System.err.println("[BookingLogic] Booking failed: Member already booked for this course");
                throw new RuntimeException("Member already has a booking for this course");
            }

            System.out.println("[BookingLogic] Creating new Booking with fetched Member and Course");

            Booking booking = new Booking.Builder()
                    .withMember(member)
                    .withCourse(course)
                    .withBookingDate(bookingDate)
                    .build();
            Booking savedBooking = bookingRepository.save(booking, member_Id, course_Id);
            System.out.println("[BookingLogic] createBooking succeeded: created booking with id " + savedBooking.getId());
            return savedBooking;
        } catch (Exception e) {
            System.err.println("[BookingLogic] Error in createBooking: " + e.getMessage());
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public Booking getBooking(long id) {
        System.out.println("[BookingLogic] getBooking called for bookingId: " + id);
        try {
            Booking booking = bookingRepository.findById(id).orElse(null);
            if (booking == null) {
                System.err.println("[BookingLogic] getBooking: Booking with id " + id + " not found");
            } else {
                System.out.println("[BookingLogic] getBooking succeeded for bookingId: " + booking.getId());
            }
            return booking;
        } catch (Exception e) {
            System.err.println("[BookingLogic] Error in getBooking: " + e.getMessage());
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public List<Booking> getBookingByMember(long memberId, int pageSize, int index) {
        System.out.println("[BookingLogic] getBookingByMember called for memberId: " + memberId
                + ", pagesize: " + pageSize + ", index: " + index);
        try {
            List<Booking> allBookings = bookingRepository.findByMemberId(memberId);
            int start = index * pageSize;
            int end = Math.min(start + pageSize, allBookings.size());
            List<Booking> result;
            if (start >= allBookings.size()) {
                result = new ArrayList<>();
            } else {
                result = allBookings.subList(start, end);
            }
            System.out.println("[BookingLogic] getBookingByMember succeeded: returned " + result.size() + " bookings");
            return result;
        } catch (Exception e) {
            System.err.println("[BookingLogic] Error in getBookingByMember: " + e.getMessage());
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public List<Booking> getBookingByCourse(long courseId, int pageSize, int index) {
        System.out.println("[BookingLogic] getBookingByCourse called for courseId: " + courseId
                + ", pagesize: " + pageSize + ", index: " + index);
        try {
            List<Booking> allBookings = bookingRepository.findByCourseId(courseId);
            int start = index * pageSize;
            int end = Math.min(start + pageSize, allBookings.size());
            List<Booking> result;
            if (start >= allBookings.size()) {
                result = new ArrayList<>();
            } else {
                result = allBookings.subList(start, end);
            }
            System.out.println("[BookingLogic] getBookingByCourse succeeded: returned " + result.size() + " bookings");
            return result;
        } catch (Exception e) {
            System.err.println("[BookingLogic] Error in getBookingByCourse: " + e.getMessage());
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public List<Booking> getBookingByDate(String date, int pageSize, int index) {
        System.out.println("[BookingLogic] getBookingByDate called for bookingDate: " + date
                + ", pagesize: " + pageSize + ", index: " + index);
        try {
            LocalDate targetDate = LocalDate.parse(date);
            List<Booking> allBookings = bookingRepository.findByDate(targetDate);
            int start = index * pageSize;
            int end = Math.min(start + pageSize, allBookings.size());
            List<Booking> result;
            if (start >= allBookings.size()) {
                result = new ArrayList<>();
            } else {
                result = allBookings.subList(start, end);
            }
            System.out.println("[BookingLogic] getBookingByDate succeeded: returned " + result.size() + " bookings");
            return result;
        } catch (Exception e) {
            System.err.println("[BookingLogic] Error in getBookingByDate: " + e.getMessage());
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public void deleteBooking(long id) {
        System.out.println("[BookingLogic] deleteBooking called for bookingId: " + id);
        try {
            System.out.println("[BookingLogic] Invoking business logic for deleteBooking");
            bookingRepository.deleteById(id);
            System.out.println("[BookingLogic] deleteBooking succeeded for bookingId: " + id);
        } catch (Exception e) {
            System.err.println("[BookingLogic] Error in deleteBooking: " + e.getMessage());
            throw new RuntimeException(e.getMessage());
        }
    }
}
