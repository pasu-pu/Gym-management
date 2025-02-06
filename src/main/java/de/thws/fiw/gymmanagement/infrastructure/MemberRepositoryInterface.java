package de.thws.fiw.gymmanagement.infrastructure;

import de.thws.fiw.gymmanagement.domain.Booking;
import de.thws.fiw.gymmanagement.domain.Member;

import java.util.List;
import java.util.Optional;

public interface MemberRepositoryInterface {
    Member save(Member member);
    Optional<Member> findById(Long id);
    List<Member> findAll();
    void deleteById(Long id);
    Member update(Long id, String name, String membershipType);
}
