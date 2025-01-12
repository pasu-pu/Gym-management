package de.thws.fiw.gymmanagement.infrastructure;

import de.thws.fiw.gymmanagement.domain.Member;

import java.util.*;
import java.util.concurrent.atomic.AtomicLong;

public class MemberRepository implements MemberRepositoryInterface {
    private final Map<Long, Member> members = new HashMap<>();
    private final AtomicLong idCounter = new AtomicLong(1);

    @Override
    public Member save(Member member) {
        if (member.getId() == null) {
            member.setId(idCounter.getAndIncrement());
        }
        members.put(member.getId(), member);
        return member;
    }

    @Override
    public Optional<Member> findById(Long id) {
        return Optional.ofNullable(members.get(id));
    }

    @Override
    public List<Member> findAll() {
        return new ArrayList<>(members.values());
    }

    @Override
    public void deleteById(Long id) {
        members.remove(id);
    }

    @Override
    public Member update(Long id, String name, String membershipType) {
        Member member = members.get(id);
        if (member != null) {
            member.setName(name);
            member.setMembershipType(membershipType);
        }
        return member;
    }
}
