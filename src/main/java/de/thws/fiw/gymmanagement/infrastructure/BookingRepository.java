package de.thws.fiw.gymmanagement.infrastructure;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.Collectors;

import org.hibernate.SessionFactory;

import de.thws.fiw.gymmanagement.domain.Booking;

public class BookingRepository implements BookingRepositoryInterface {
    private final Map<Long, Booking> bookings = new HashMap<>();
    private final AtomicLong idCounter = new AtomicLong(1);
    private final SessionFactory database;

    public BookingRepository() {
        this.database = HibernateUtil.getSessionFactory();
    }

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
