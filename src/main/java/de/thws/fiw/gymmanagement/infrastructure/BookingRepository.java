package de.thws.fiw.gymmanagement.infrastructure;

import de.thws.fiw.gymmanagement.domain.Booking;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery;

import java.time.LocalDate;
import java.util.*;
import java.util.concurrent.atomic.AtomicLong;
import java.util.function.Function;
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
    public boolean existsById(Long aLong) {
        return false;
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

    @Override
    public void delete(Booking entity) {

    }

    @Override
    public void deleteAllById(Iterable<? extends Long> longs) {

    }

    @Override
    public void deleteAll(Iterable<? extends Booking> entities) {

    }

    @Override
    public void deleteAll() {

    }

    @Override
    public List<Booking> findAll() {
        return null;
    }

    @Override
    public List<Booking> findAll(Sort sort) {
        return null;
    }

    @Override
    public Page<Booking> findAll(Pageable pageable) {
        return null;
    }

    @Override
    public List<Booking> findAllById(Iterable<Long> longs) {
        return null;
    }

    @Override
    public long count() {
        return 0;
    }

    @Override
    public <S extends Booking> List<S> saveAll(Iterable<S> entities) {
        return null;
    }

    @Override
    public void flush() {

    }

    @Override
    public <S extends Booking> S saveAndFlush(S entity) {
        return null;
    }

    @Override
    public <S extends Booking> List<S> saveAllAndFlush(Iterable<S> entities) {
        return null;
    }

    @Override
    public void deleteAllInBatch(Iterable<Booking> entities) {

    }

    @Override
    public void deleteAllByIdInBatch(Iterable<Long> longs) {

    }

    @Override
    public void deleteAllInBatch() {

    }

    @Override
    public Booking getOne(Long aLong) {
        return null;
    }

    @Override
    public Booking getById(Long aLong) {
        return null;
    }

    @Override
    public Booking getReferenceById(Long aLong) {
        return null;
    }

    @Override
    public <S extends Booking> Optional<S> findOne(Example<S> example) {
        return Optional.empty();
    }

    @Override
    public <S extends Booking> List<S> findAll(Example<S> example) {
        return null;
    }

    @Override
    public <S extends Booking> List<S> findAll(Example<S> example, Sort sort) {
        return null;
    }

    @Override
    public <S extends Booking> Page<S> findAll(Example<S> example, Pageable pageable) {
        return null;
    }

    @Override
    public <S extends Booking> long count(Example<S> example) {
        return 0;
    }

    @Override
    public <S extends Booking> boolean exists(Example<S> example) {
        return false;
    }

    @Override
    public <S extends Booking, R> R findBy(Example<S> example, Function<FluentQuery.FetchableFluentQuery<S>, R> queryFunction) {
        return null;
    }
}
