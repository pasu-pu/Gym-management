package de.thws.fiw.gymmanagement.application.service;

import de.thws.fiw.gymmanagement.domain.Member;
import de.thws.fiw.gymmanagement.infrastructure.MemberRepositoryInterface;

import java.util.List;
import java.util.Optional;

public class MemberService {
    private final MemberRepositoryInterface memberRepository;

    public MemberService(MemberRepositoryInterface memberRepository) {
        this.memberRepository = memberRepository;
    }

    public Member createMember(String name, String membershipType) {
        Member member = new Member();
        member.setName(name);
        member.setMembershipType(membershipType);
        return memberRepository.save(member);
    }

    public Optional<Member> getMember(Long memberId) {
        return memberRepository.findById(memberId);
    }

    public List<Member> getAllMembers() {
        return memberRepository.findAll();
    }

    public boolean updateMember(Long memberId, String name, String membershipType) {
        return memberRepository.update(memberId, name, membershipType) != null;
    }

    public boolean deleteMember(Long memberId) {
        return memberRepository.findById(memberId)
                .map(member -> {
                    memberRepository.deleteById(member.getId());
                    return true;
                })
                .orElse(false);
    }
}
