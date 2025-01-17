package de.thws.fiw.gymmanagement.infrastructure;

import de.thws.fiw.gymmanagement.domain.Booking;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface BookingRepositoryInterface extends JpaRepository<Booking, Long> {
    Booking save(Booking booking);
    Optional<Booking> findById(Long id);
    List<Booking> findByMemberId(Long memberId);
    List<Booking> findByCourseId(Long courseId);
    void deleteById(Long id);
}
