package de.thws.fiw.gymmanagement.infrastructure;

import de.thws.fiw.gymmanagement.domain.Booking;

import java.util.List;
import java.util.Optional;

public interface BookingRepositoryInterface {
    Booking save(Booking booking);
    Optional<Booking> findById(Long id);
    List<Booking> findAll();
    void deleteById(Long id);
}
