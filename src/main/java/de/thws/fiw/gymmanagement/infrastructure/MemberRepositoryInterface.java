package de.thws.fiw.gymmanagement.infrastructure;

import de.thws.fiw.gymmanagement.domain.Member;
import java.util.List;
import java.util.Optional;

public interface MemberRepositoryInterface {
    Member save(Member member);
    Optional<Member> findById(Long id);
    List<Member> findAll();
    Member update(Long id, String name, String membershipType);
    void deleteById(Long id);

    // Spezifische Filterabfragen
    List<Member> findByName(String name);
    List<Member> findByMembership(String membership);
}
