package de.thws.fiw.gymmanagement.service.test;

import static org.junit.jupiter.api.Assertions.*;

import de.thws.fiw.gymmanagement.domain.MemberLogic;
import de.thws.fiw.gymmanagement.domain.Member;
import de.thws.fiw.gymmanagement.infrastructure.fakes.FakeMemberRepository;
import de.thws.fiw.gymmanagement.infrastructure.MemberRepositoryInterface;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class MemberLogicTest {

    private MemberRepositoryInterface memberRepository;
    private MemberLogic memberLogic;

    @BeforeEach
    public void setUp() {
        memberRepository = new FakeMemberRepository();
        memberLogic = new MemberLogic(memberRepository);
    }

    @Test
    public void testCreateMember() {
        // The MemberService internally uses the Builder pattern
        Member member = memberLogic.createMember("Alice", "Premium");
        assertNotNull(member);
        assertNotNull(member.getId());
        assertEquals("Alice", member.getName());
        assertEquals("Premium", member.getMembershipType());
    }

    @Test
    public void testUpdateMember() {
        Member member = memberLogic.createMember("Alice", "Premium");
        Member updated = memberLogic.updateMember(member.getId(), "Alice Updated", "Standard");
        assertNotNull(updated);
        assertEquals("Alice Updated", updated.getName());
        assertEquals("Standard", updated.getMembershipType());
    }

    @Test
    public void testGetMember() {
        Member member = memberLogic.createMember("Bob", "Standard");
        Member fetched = memberLogic.getMember(member.getId());
        assertNotNull(fetched);
        assertEquals("Bob", fetched.getName());
    }

    @Test
    public void testGetAllMembers() {
        memberLogic.createMember("Alice", "Premium");
        memberLogic.createMember("Bob", "Standard");
        memberLogic.createMember("Carol", "Premium");
        List<Member> page = memberLogic.getAllMembers(2, 0);
        assertEquals(2, page.size());
        page = memberLogic.getAllMembers(2, 1);
        assertEquals(1, page.size());
    }

    @Test
    public void testGetMemberByName() {
        memberLogic.createMember("Alice", "Premium");
        memberLogic.createMember("Alice", "Standard");
        List<Member> result = memberLogic.getMemberByName(10, 0, "Alice");
        assertEquals(2, result.size());
    }

    @Test
    public void testGetMemberByMembership() {
        memberLogic.createMember("Alice", "Premium");
        memberLogic.createMember("Bob", "Standard");
        memberLogic.createMember("Carol", "Premium");
        List<Member> result = memberLogic.getMemberByMembership(10, 0, "Premium");
        assertEquals(2, result.size());
    }

    @Test
    public void testDeleteMember() {
        Member member = memberLogic.createMember("Alice", "Premium");
        memberLogic.deleteMember(member.getId());
        Member fetched = memberLogic.getMember(member.getId());
        assertNull(fetched);
    }
}
