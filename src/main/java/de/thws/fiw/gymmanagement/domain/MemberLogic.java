package de.thws.fiw.gymmanagement.domain;

import de.thws.fiw.gymmanagement.infrastructure.MemberRepositoryInterface;
import java.util.ArrayList;
import java.util.List;

public class MemberLogic implements MemberLogicAdapter {

    private final MemberRepositoryInterface memberRepository;

    public MemberLogic(MemberRepositoryInterface memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Override
    public Member createMember(String name, String membership) {
        System.out.println("[MemberLogic] createMember called with name: " + name + ", membership: " + membership);
        try {
            System.out.println("[MemberLogic] Creating new Member object using Builder");
            Member member = new Member.Builder()
                    .withName(name)
                    .withMembershipType(membership)
                    .build();
            Member savedMember = memberRepository.save(member);
            System.out.println("[MemberLogic] createMember succeeded: member saved with id " + savedMember.getId());
            return savedMember;
        } catch (Exception e) {
            System.err.println("[MemberLogic] Error in createMember: " + e.getMessage());
            throw e;
        }
    }

    @Override
    public Member updateMember(long id, String name, String membership) {
        System.out.println("[MemberLogic] updateMember called for memberId: " + id + " with new name: " + name + ", membership: " + membership);
        try {
            Member updatedMember = memberRepository.update(id, name, membership);
            System.out.println("[MemberLogic] updateMember succeeded for memberId: " + updatedMember.getId());
            return updatedMember;
        } catch (Exception e) {
            System.err.println("[MemberLogic] Error in updateMember: " + e.getMessage());
            throw e;
        }
    }

    @Override
    public Member getMember(long id) {
        System.out.println("[MemberLogic] getMember called for memberId: " + id);
        try {
            Member member = memberRepository.findById(id).orElse(null);
            if (member == null) {
                System.err.println("[MemberLogic] getMember: No member found for id " + id);
            } else {
                System.out.println("[MemberLogic] getMember succeeded for memberId: " + member.getId());
            }
            return member;
        } catch (Exception e) {
            System.err.println("[MemberLogic] Error in getMember: " + e.getMessage());
            throw e;
        }
    }

    @Override
    public List<Member> getAllMembers(int pageSize, int index) {
        System.out.println("[MemberLogic] getAllMembers called with pagesize: " + pageSize + ", index: " + index);
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
            System.out.println("[MemberLogic] getAllMembers succeeded: returned " + result.size() + " members");
            return result;
        } catch (Exception e) {
            System.err.println("[MemberLogic] Error in getAllMembers: " + e.getMessage());
            throw e;
        }
    }

    @Override
    public List<Member> getMemberByName(int pageSize, int index, String name) {
        System.out.println("[MemberLogic] getMemberByName called with name: " + name + ", pagesize: " + pageSize + ", index: " + index);
        try {
            List<Member> filtered = memberRepository.findByName(name);
            int start = index * pageSize;
            int end = Math.min(start + pageSize, filtered.size());
            List<Member> result;
            if (start >= filtered.size()) {
                result = new ArrayList<>();
            } else {
                result = filtered.subList(start, end);
            }
            System.out.println("[MemberLogic] getMemberByName succeeded: returned " + result.size() + " members");
            return result;
        } catch (Exception e) {
            System.err.println("[MemberLogic] Error in getMemberByName: " + e.getMessage());
            throw e;
        }
    }

    @Override
    public List<Member> getMemberByMembership(int pageSize, int index, String membership) {
        System.out.println("[MemberLogic] getMemberByMembership called with membership: " + membership + ", pagesize: " + pageSize + ", index: " + index);
        try {
            List<Member> filtered = memberRepository.findByMembership(membership);
            int start = index * pageSize;
            int end = Math.min(start + pageSize, filtered.size());
            List<Member> result;
            if (start >= filtered.size()) {
                result = new ArrayList<>();
            } else {
                result = filtered.subList(start, end);
            }
            System.out.println("[MemberLogic] getMemberByMembership succeeded: returned " + result.size() + " members");
            return result;
        } catch (Exception e) {
            System.err.println("[MemberLogic] Error in getMemberByMembership: " + e.getMessage());
            throw e;
        }
    }

    @Override
    public void deleteMember(long id) {
        System.out.println("[MemberLogic] deleteMember called for memberId: " + id);
        try {
            memberRepository.deleteById(id);
            System.out.println("[MemberLogic] deleteMember succeeded for memberId: " + id);
        } catch (Exception e) {
            System.err.println("[MemberLogic] Error in deleteMember: " + e.getMessage());
            throw e;
        }
    }
}
