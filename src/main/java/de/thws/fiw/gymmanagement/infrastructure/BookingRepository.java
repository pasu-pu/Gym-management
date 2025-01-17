package de.thws.fiw.gymmanagement.infrastructure;

import de.thws.fiw.gymmanagement.domain.Booking;

import java.time.LocalDate;
import java.util.*;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.Collectors;

public class BookingRepository implements BookingRepositoryInterface {
    private final Map<Long, Booking> bookings = new HashMap<>();
    private final AtomicLong idCounter = new AtomicLong(1);

    @Override
    public Booking save(Booking booking) {
        if (booking.getId() == null) {
            booking.setId(idCounter.getAndIncrement());
        }
        booking.setBookingDate(LocalDate.now());
        bookings.put(booking.getId(), booking);
        return booking;
    }

    @Override
    public Optional<Booking> findById(Long id) {
        return Optional.ofNullable(bookings.get(id));
    }

    @Override
    public List<Booking> findByMemberId(Long memberId) {
        return bookings.values().stream()
                .filter(booking -> booking.getMemberId().equals(memberId))
                .collect(Collectors.toList());
    }

    @Override
    public List<Booking> findByCourseId(Long courseId) {
        return bookings.values().stream()
                .filter(booking -> booking.getCourseId().equals(courseId))
                .collect(Collectors.toList());
    }

    @Override
    public void deleteById(Long id) {
        bookings.remove(id);
    }
}
