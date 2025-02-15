package de.thws.fiw.gymmanagement.infrastructure.fakes;

import de.thws.fiw.gymmanagement.domain.Booking;
import de.thws.fiw.gymmanagement.infrastructure.BookingRepositoryInterface;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;

public class FakeBookingRepository implements BookingRepositoryInterface {
    private final List<Booking> bookings = new ArrayList<>();
    private final AtomicLong idGenerator = new AtomicLong(1);

    @Override
    public Booking save(Booking booking, Long memberId, Long courseId) {
        if (booking.getId() == null || booking.getId() == 0) {
            long newId = idGenerator.getAndIncrement();
            Booking newBooking = new Booking.Builder()
                    .withId(newId)
                    .withMember(booking.getMember())
                    .withCourse(booking.getCourse())
                    .withBookingDate(booking.getBookingDate())
                    .build();
            bookings.add(newBooking);
            return newBooking;
        } else {
            bookings.add(booking);
            return booking;
        }
    }

    @Override
    public Optional<Booking> findById(Long id) {
        return bookings.stream()
                .filter(b -> b.getId().equals(id))
                .findFirst();
    }

    @Override
    public List<Booking> findByMemberId(Long memberId) {
        List<Booking> result = new ArrayList<>();
        for (Booking b : bookings) {
            if (b.getMember() != null && b.getMember().getId().equals(memberId)) {
                result.add(b);
            }
        }
        return result;
    }

    @Override
    public List<Booking> findByCourseId(Long courseId) {
        List<Booking> result = new ArrayList<>();
        for (Booking b : bookings) {
            if (b.getCourse() != null && b.getCourse().getId().equals(courseId)) {
                result.add(b);
            }
        }
        return result;
    }

    @Override
    public List<Booking> findByDate(LocalDate date) {
        List<Booking> result = new ArrayList<>();
        for (Booking b : bookings) {
            if (b.getBookingDate() != null && b.getBookingDate().equals(date)) {
                result.add(b);
            }
        }
        return result;
    }

    @Override
    public void deleteById(Long id) {
        bookings.removeIf(b -> b.getId().equals(id));
    }

    @Override
    public void deleteAll() {

    }
}
