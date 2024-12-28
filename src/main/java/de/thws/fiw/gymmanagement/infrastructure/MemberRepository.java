package de.thws.fiw.gymmanagement.infrastructure;

import de.thws.fiw.gymmanagement.domain.Member;
import java.util.*;
import java.util.concurrent.atomic.AtomicLong;

public class MemberRepository {
    private final Map<Long, Member> members = new HashMap<>();
    private final AtomicLong idCounter = new AtomicLong(1);

    public Member save(Member member) {
        if (member.getId() == null) {
            member.setId(idCounter.getAndIncrement());
        }
        members.put(member.getId(), member);
        return member;
    }

    public Optional<Member> findById(Long id) {
        return Optional.ofNullable(members.get(id));
    }

    public List<Member> findAll() {
        return new ArrayList<>(members.values());
    }

    public void deleteById(Long id) {
        members.remove(id);
    }

}
