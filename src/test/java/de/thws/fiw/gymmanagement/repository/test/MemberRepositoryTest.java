package de.thws.fiw.gymmanagement.repository.test;

import static org.junit.jupiter.api.Assertions.*;

import de.thws.fiw.gymmanagement.domain.Member;
import de.thws.fiw.gymmanagement.infrastructure.MemberRepository;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Optional;

public class MemberRepositoryTest {

    private static MemberRepository memberRepository;

    @BeforeAll
    public static void setUp() {
        // Make sure HibernateUtil is configured to use an in-memory database like H2
        memberRepository = new MemberRepository();
    }

    @Test
    public void testSaveAndFindById() {
        Member member = new Member();
        member.setName("TestUser");
        member.setMembershipType("Gold");

        Member savedMember = memberRepository.save(member);
        assertNotNull(savedMember);
        assertNotNull(savedMember.getId());

        Optional<Member> found = memberRepository.findById(savedMember.getId());
        assertTrue(found.isPresent());
        assertEquals("TestUser", found.get().getName());
    }

    @Test
    public void testUpdateMember() {
        Member member = new Member();
        member.setName("UserToUpdate");
        member.setMembershipType("Silver");
        Member savedMember = memberRepository.save(member);

        Member updated = memberRepository.update(savedMember.getId(), "UpdatedUser", "Platinum");
        assertNotNull(updated);
        assertEquals("UpdatedUser", updated.getName());
        assertEquals("Platinum", updated.getMembershipType());
    }

    @Test
    public void testFindAllAndPagination() {
        // Clear existing data or use a fresh in-memory DB for each test ideally.
        memberRepository.deleteById(1L);
        // Save multiple members
        memberRepository.save(new Member(null, "Alice", "Gold"));
        memberRepository.save(new Member(null, "Bob", "Silver"));
        memberRepository.save(new Member(null, "Carol", "Gold"));

        List<Member> allMembers = memberRepository.findAll();
        assertTrue(allMembers.size() >= 3);

        // For pagination tests, you might simulate it in your service, but here you can check that allMembers returns the full list.
        // For example:
        int pageSize = 2;
        int index = 0;
        List<Member> page = allMembers.subList(index * pageSize, Math.min((index + 1) * pageSize, allMembers.size()));
        assertEquals(2, page.size());
    }

    @Test
    public void testFindByName() {
        Member member = new Member();
        member.setName("UniqueName");
        member.setMembershipType("Standard");
        memberRepository.save(member);

        List<Member> found = memberRepository.findByName("UniqueName");
        assertFalse(found.isEmpty());
        for (Member m : found) {
            assertEquals("UniqueName", m.getName());
        }
    }

    @Test
    public void testDeleteMember() {
        Member member = new Member();
        member.setName("UserToDelete");
        member.setMembershipType("Bronze");
        Member savedMember = memberRepository.save(member);

        memberRepository.deleteById(savedMember.getId());
        Optional<Member> found = memberRepository.findById(savedMember.getId());
        assertFalse(found.isPresent());
    }
}
