package de.thws.fiw.gymmanagement.service.test;

import static org.junit.jupiter.api.Assertions.*;

import de.thws.fiw.gymmanagement.application.service.MemberService;
import de.thws.fiw.gymmanagement.domain.Member;
import de.thws.fiw.gymmanagement.infrastructure.FakeMemberRepository;
import de.thws.fiw.gymmanagement.infrastructure.MemberRepositoryInterface;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class MemberServiceTest {

    private MemberRepositoryInterface memberRepository;
    private MemberService memberService;

    @BeforeEach
    public void setUp() {
        memberRepository = new FakeMemberRepository();
        memberService = new MemberService(memberRepository);
    }

    @Test
    public void testCreateMember() {
        Member member = memberService.createMember("Alice", "Premium");
        assertNotNull(member);
        assertNotNull(member.getId());
        assertEquals("Alice", member.getName());
        assertEquals("Premium", member.getMembershipType());
    }

    @Test
    public void testUpdateMember() {
        Member member = memberService.createMember("Alice", "Premium");
        Member updated = memberService.updateMember(member.getId(), "Alice Updated", "Standard");
        assertNotNull(updated);
        assertEquals("Alice Updated", updated.getName());
        assertEquals("Standard", updated.getMembershipType());
    }

    @Test
    public void testGetMember() {
        Member member = memberService.createMember("Bob", "Standard");
        Member fetched = memberService.getMember(member.getId());
        assertNotNull(fetched);
        assertEquals("Bob", fetched.getName());
    }

    @Test
    public void testGetAllMembers() {
        memberService.createMember("Alice", "Premium");
        memberService.createMember("Bob", "Standard");
        memberService.createMember("Carol", "Premium");
        List<Member> page = memberService.getAllMembers(2, 0);
        assertEquals(2, page.size());
        page = memberService.getAllMembers(2, 1);
        assertEquals(1, page.size());
    }

    @Test
    public void testGetMemberByName() {
        memberService.createMember("Alice", "Premium");
        memberService.createMember("Alice", "Standard");
        List<Member> result = memberService.getMemberByName(10, 0, "Alice");
        assertEquals(2, result.size());
    }

    @Test
    public void testGetMemberByMembership() {
        memberService.createMember("Alice", "Premium");
        memberService.createMember("Bob", "Standard");
        memberService.createMember("Carol", "Premium");
        List<Member> result = memberService.getMemberByMembership(10, 0, "Premium");
        assertEquals(2, result.size());
    }

    @Test
    public void testDeleteMember() {
        Member member = memberService.createMember("Alice", "Premium");
        memberService.deleteMember(member.getId());
        Member fetched = memberService.getMember(member.getId());
        assertNull(fetched);
    }
}
