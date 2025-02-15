package de.thws.fiw.gymmanagement.repository.test;

import static org.junit.jupiter.api.Assertions.*;

import de.thws.fiw.gymmanagement.domain.Member;
import de.thws.fiw.gymmanagement.infrastructure.MemberRepository;
import de.thws.fiw.gymmanagement.infrastructure.MemberRepositoryInterface;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Optional;

public class MemberRepositoryTest {

    private static MemberRepositoryInterface memberRepository;

    @BeforeAll
    public static void setUp() {
        // Assuming HibernateUtil is configured to use an in-memory DB (e.g., H2)
        memberRepository = new MemberRepository();
    }

    @AfterAll
    public static void remove() {
        // Löscht alle Mitglieder
        memberRepository.deleteAll();
    }
    @Test
    public void testSaveAndFindById() {
        // Create a member using the builder
        Member member = new Member.Builder()
                .withName("TestUser")
                .withMembershipType("Gold")
                .build();

        Member savedMember = memberRepository.save(member);
        assertNotNull(savedMember);
        assertNotNull(savedMember.getId());

        Optional<Member> found = memberRepository.findById(savedMember.getId());
        assertTrue(found.isPresent());
        assertEquals("TestUser", found.get().getName());
    }

    @Test
    public void testUpdateMember() {
        Member member = new Member.Builder()
                .withName("UserToUpdate")
                .withMembershipType("Silver")
                .build();
        Member savedMember = memberRepository.save(member);

        Member updated = memberRepository.update(savedMember.getId(), "UpdatedUser", "Platinum");
        assertNotNull(updated);
        assertEquals("UpdatedUser", updated.getName());
        assertEquals("Platinum", updated.getMembershipType());
    }

    @Test
    public void testFindAllAndPagination() {
        // Clean up: In a real test you might want to clear the repository first.
        // For demonstration, we assume a fresh in-memory DB.

        // Save multiple members using the builder
        memberRepository.save(new Member.Builder().withName("Alice").withMembershipType("Gold").build());
        memberRepository.save(new Member.Builder().withName("Bob").withMembershipType("Silver").build());
        memberRepository.save(new Member.Builder().withName("Carol").withMembershipType("Gold").build());

        List<Member> allMembers = memberRepository.findAll();
        assertTrue(allMembers.size() >= 3);

        int pageSize = 2;
        int index = 0;
        List<Member> page = allMembers.subList(index * pageSize, Math.min((index + 1) * pageSize, allMembers.size()));
        assertEquals(2, page.size());
    }

    @Test
    public void testFindByName() {
        Member member = new Member.Builder()
                .withName("UniqueName")
                .withMembershipType("Standard")
                .build();
        memberRepository.save(member);

        List<Member> found = memberRepository.findByName("UniqueName");
        assertFalse(found.isEmpty());
        for (Member m : found) {
            assertEquals("UniqueName", m.getName());
        }
    }

    @Test
    public void testDeleteMember() {
        Member member = new Member.Builder()
                .withName("UserToDelete")
                .withMembershipType("Bronze")
                .build();
        Member savedMember = memberRepository.save(member);

        memberRepository.deleteById(savedMember.getId());
        Optional<Member> found = memberRepository.findById(savedMember.getId());
        assertFalse(found.isPresent());
    }
}
