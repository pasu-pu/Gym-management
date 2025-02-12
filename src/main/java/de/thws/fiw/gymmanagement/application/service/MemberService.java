package de.thws.fiw.gymmanagement.application.service;

import de.thws.fiw.gymmanagement.domain.Member;
import de.thws.fiw.gymmanagement.infrastructure.MemberRepositoryInterface;

import java.util.List;

public class MemberService implements MemberServiceAdapter {

    MemberRepositoryInterface memberRepository;

    public MemberService(MemberRepositoryInterface memberRepository){
        this.memberRepository=memberRepository;
    }
    @Override
    public Member createMember(String name, String membership) {
        System.out.println("hurrahhhhhhhhg");
        Member temp = new Member();
        temp.setId((long)1);
        temp.setMembershipType("premium");
        temp.setName("hans");
        return temp;
    }

    @Override
    public Member updateMember(long id, String name, String membership) {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    @Override
    public Member getMember(long id) {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    @Override
    public List<Member> getAllMembers(int pageSize, int index) {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    @Override
    public List<Member> getMemberByName(int pageSize, int index, String name) {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    @Override
    public List<Member> getMemberByMembership(int pageSize, int index, String membership) {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    @Override
    public void deleteMember(long id) {
        throw new UnsupportedOperationException("Not implemented yet");
    }
}
