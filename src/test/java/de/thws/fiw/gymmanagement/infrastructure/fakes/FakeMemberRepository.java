package de.thws.fiw.gymmanagement.infrastructure.fakes  ;

import de.thws.fiw.gymmanagement.domain.Member;
import de.thws.fiw.gymmanagement.infrastructure.MemberRepositoryInterface;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;

public class FakeMemberRepository implements MemberRepositoryInterface {
    private final List<Member> members = new ArrayList<>();
    private final AtomicLong idGenerator = new AtomicLong(1);

    @Override
    public Member save(Member member) {
        if (member.getId() == null || member.getId() == 0) {
            member.setId(idGenerator.getAndIncrement());
        }
        members.add(member);
        return member;
    }

    @Override
    public Optional<Member> findById(Long id) {
        return members.stream().filter(m -> m.getId().equals(id)).findFirst();
    }

    @Override
    public List<Member> findAll() {
        return new ArrayList<>(members);
    }

    @Override
    public Member update(long id, String name, String membershipType) {
        Optional<Member> opt = findById(id);
        if (opt.isPresent()) {
            Member member = opt.get();
            member.setName(name);
            member.setMembershipType(membershipType);
            return member;
        }
        return null;
    }

    @Override
    public void deleteById(Long id) {
        members.removeIf(m -> m.getId().equals(id));
    }

    @Override
    public List<Member> findByName(String name) {
        List<Member> result = new ArrayList<>();
        for (Member m : members) {
            if (m.getName().equalsIgnoreCase(name)) {
                result.add(m);
            }
        }
        return result;
    }

    @Override
    public List<Member> findByMembership(String membership) {
        List<Member> result = new ArrayList<>();
        for (Member m : members) {
            if (m.getMembershipType().equalsIgnoreCase(membership)) {
                result.add(m);
            }
        }
        return result;
    }
}
