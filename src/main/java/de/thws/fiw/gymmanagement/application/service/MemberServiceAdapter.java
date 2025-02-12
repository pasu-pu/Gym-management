package de.thws.fiw.gymmanagement.application.service;

import de.thws.fiw.gymmanagement.domain.Member;
import java.util.List;

public interface MemberServiceAdapter {
    Member createMember(String name, String membership);
    Member updateMember(long id, String name, String membership);
    Member getMember(long id);
    List<Member> getAllMembers(int pageSize, int index);
    List<Member> getMemberByName(int pageSize, int index, String name);
    List<Member> getMemberByMembership(int pageSize, int index, String membership);
    void deleteMember(long id);
}
