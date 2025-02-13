package de.thws.fiw.gymmanagement.application.service;

import de.thws.fiw.gymmanagement.domain.Member;
import de.thws.fiw.gymmanagement.infrastructure.MemberRepositoryInterface;
import java.util.ArrayList;
import java.util.List;

public class MemberService implements MemberServiceAdapter {

    private final MemberRepositoryInterface memberRepository;

    public MemberService(MemberRepositoryInterface memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Override
    public Member createMember(String name, String membership) {
        System.out.println("[MemberService] createMember called with name: " + name + ", membership: " + membership);
        try {
            System.out.println("[MemberService] Creating new Member object");
            Member member = new Member();
            member.setName(name);
            member.setMembershipType(membership);
            Member savedMember = memberRepository.save(member);
            System.out.println("[MemberService] createMember succeeded: member saved with id " + savedMember.getId());
            return savedMember;
        } catch (Exception e) {
            System.err.println("[MemberService] Error in createMember: " + e.getMessage());
            throw e;
        }
    }

    @Override
    public Member updateMember(long id, String name, String membership) {
        System.out.println("[MemberService] updateMember called for memberId: " + id + " with new name: " + name + ", membership: " + membership);
        try {
            Member updatedMember = memberRepository.update(id, name, membership);
            System.out.println("[MemberService] updateMember succeeded for memberId: " + updatedMember.getId());
            return updatedMember;
        } catch (Exception e) {
            System.err.println("[MemberService] Error in updateMember: " + e.getMessage());
            throw e;
        }
    }

    @Override
    public Member getMember(long id) {
        System.out.println("[MemberService] getMember called for memberId: " + id);
        try {
            Member member = memberRepository.findById(id).orElse(null);
            if (member == null) {
                System.err.println("[MemberService] getMember: No member found for id " + id);
            } else {
                System.out.println("[MemberService] getMember succeeded for memberId: " + member.getId());
            }
            return member;
        } catch (Exception e) {
            System.err.println("[MemberService] Error in getMember: " + e.getMessage());
            throw e;
        }
    }

    @Override
    public List<Member> getAllMembers(int pageSize, int index) {
        System.out.println("[MemberService] getAllMembers called with pagesize: " + pageSize + ", index: " + index);
        try {
            List<Member> allMembers = memberRepository.findAll();
            int start = index * pageSize;
            int end = Math.min(start + pageSize, allMembers.size());
            List<Member> result;
            if (start >= allMembers.size()) {
                result = new ArrayList<>();
            } else {
                result = allMembers.subList(start, end);
            }
            System.out.println("[MemberService] getAllMembers succeeded: returned " + result.size() + " members");
            return result;
        } catch (Exception e) {
            System.err.println("[MemberService] Error in getAllMembers: " + e.getMessage());
            throw e;
        }
    }

    @Override
    public List<Member> getMemberByName(int pageSize, int index, String name) {
        System.out.println("[MemberService] getMemberByName called with name: " + name + ", pagesize: " + pageSize + ", index: " + index);
        try {
            // Annahme: findByName führt bereits das Filtering in der DB durch.
            List<Member> filtered = memberRepository.findByName(name);
            int start = index * pageSize;
            int end = Math.min(start + pageSize, filtered.size());
            List<Member> result;
            if (start >= filtered.size()) {
                result = new ArrayList<>();
            } else {
                result = filtered.subList(start, end);
            }
            System.out.println("[MemberService] getMemberByName succeeded: returned " + result.size() + " members");
            return result;
        } catch (Exception e) {
            System.err.println("[MemberService] Error in getMemberByName: " + e.getMessage());
            throw e;
        }
    }

    @Override
    public List<Member> getMemberByMembership(int pageSize, int index, String membership) {
        System.out.println("[MemberService] getMemberByMembership called with membership: " + membership + ", pagesize: " + pageSize + ", index: " + index);
        try {
            // Annahme: findByMembership filtert bereits in der DB.
            List<Member> filtered = memberRepository.findByMembership(membership);
            int start = index * pageSize;
            int end = Math.min(start + pageSize, filtered.size());
            List<Member> result;
            if (start >= filtered.size()) {
                result = new ArrayList<>();
            } else {
                result = filtered.subList(start, end);
            }
            System.out.println("[MemberService] getMemberByMembership succeeded: returned " + result.size() + " members");
            return result;
        } catch (Exception e) {
            System.err.println("[MemberService] Error in getMemberByMembership: " + e.getMessage());
            throw e;
        }
    }

    @Override
    public void deleteMember(long id) {
        System.out.println("[MemberService] deleteMember called for memberId: " + id);
        try {
            memberRepository.deleteById(id);
            System.out.println("[MemberService] deleteMember succeeded for memberId: " + id);
        } catch (Exception e) {
            System.err.println("[MemberService] Error in deleteMember: " + e.getMessage());
            throw e;
        }
    }
}
