package de.thws.fiw.gymmanagement.infrastructure;

import de.thws.fiw.gymmanagement.domain.Booking;

import java.util.List;
import java.util.Optional;

public interface BookingRepositoryInterface {
    Booking save(Booking booking, Long memberId, Long courseId);
    Optional<Booking> findById(Long id);
    List<Booking> findByMemberId(Long memberId);
    List<Booking> findByCourseId(Long courseId);
    void deleteById(Long id);
}
