package de.thws.fiw.gymmanagement.integration.test;

import de.thws.fiw.gymmanagement.application.*;
import de.thws.fiw.gymmanagement.domain.MemberLogic;
import de.thws.fiw.gymmanagement.infrastructure.*;
import de.thws.fiw.gymmanagement.domain.Member;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.StatusRuntimeException;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class MemberLogicIntegrationTest {

    private static Server server;
    private static ManagedChannel channel;
    private static MemberServiceGrpc.MemberServiceBlockingStub memberStub;

    private static MemberRepositoryInterface memberRepository;

    @BeforeAll
    public static void startServer() throws Exception {
        memberRepository = new MemberRepository();

        MemberLogic memberLogic = new MemberLogic(memberRepository);
        MemberServiceImpl serviceImpl = new MemberServiceImpl(memberLogic);

        server = ServerBuilder.forPort(8082)
                .addService(serviceImpl)
                .build()
                .start();

        channel = ManagedChannelBuilder.forAddress("localhost", 8082)
                .usePlaintext()
                .build();
        memberStub = MemberServiceGrpc.newBlockingStub(channel);
    }

    @AfterAll
    public static void stopServer() {
        channel.shutdownNow();
        server.shutdownNow();
    }

    @AfterEach
    public void cleanDatabase() {
        memberRepository.deleteAll();
    }

    @Test
    public void testCreateMember() {
        CreateMemberRequest createRequest = CreateMemberRequest.newBuilder()
                .setName("John Doe")
                .setMembership("Gold")
                .build();
        var createResponse = memberStub.createMember(createRequest);

        assertNotNull(createResponse.getMemberId());
        assertEquals("John Doe", createResponse.getName());
        assertEquals("Gold", createResponse.getMembership());
    }

    @Test
    public void testUpdateMember() {
        Member member = new Member.Builder()
                .withName("Jane Doe")
                .withMembershipType("Silver")
                .build();
        member = memberRepository.save(member);

        UpdateMemberRequest updateRequest = UpdateMemberRequest.newBuilder()
                .setMemberId(member.getId())
                .setName("Jane Smith")
                .setMembership("Platinum")
                .build();
        var updateResponse = memberStub.updateMember(updateRequest);

        assertEquals("Jane Smith", updateResponse.getName());
        assertEquals("Platinum", updateResponse.getMembership());
    }

    @Test
    public void testGetMember() {
        Member member = new Member.Builder()
                .withName("Fetch Member")
                .withMembershipType("Bronze")
                .build();
        member = memberRepository.save(member);

        GetMemberRequest getRequest = GetMemberRequest.newBuilder()
                .setMemberId(member.getId())
                .build();
        var getResponse = memberStub.getMember(getRequest);

        assertEquals(member.getId(), getResponse.getMemberId());
        assertEquals("Fetch Member", getResponse.getName());
    }

    @Test
    public void testGetAllMembers() {
        Member member1 = new Member.Builder()
                .withName("Member One")
                .withMembershipType("Bronze")
                .build();
        Member member2 = new Member.Builder()
                .withName("Member Two")
                .withMembershipType("Silver")
                .build();

        memberRepository.save(member1);
        memberRepository.save(member2);

        GetAllMembersRequest request = GetAllMembersRequest.newBuilder()
                .setPagesize(10)
                .setIndex(0)
                .build();
        GetAllMembersResponse response = memberStub.getAllMembers(request);

        assertTrue(response.getMembersCount() >= 2);
    }

    @Test
    public void testGetMemberByName() {
        Member member = new Member.Builder()
                .withName("Unique Member")
                .withMembershipType("Platinum")
                .build();
        member = memberRepository.save(member);

        GetMemberByNameRequest request = GetMemberByNameRequest.newBuilder()
                .setName("Unique Member")
                .setPagesize(10)
                .setIndex(0)
                .build();
        GetAllMembersResponse response = memberStub.getMemberByName(request);

        assertEquals(1, response.getMembersCount());
        assertEquals("Unique Member", response.getMembers(0).getName());
    }

    @Test
    public void testGetMemberByMembership() {
        Member member = new Member.Builder()
                .withName("Type Member")
                .withMembershipType("Gold")
                .build();
        member = memberRepository.save(member);

        GetMemberByMembershipRequest request = GetMemberByMembershipRequest.newBuilder()
                .setMembership("Gold")
                .setPagesize(10)
                .setIndex(0)
                .build();
        GetAllMembersResponse response = memberStub.getMemberByMembership(request);

        assertEquals(1, response.getMembersCount());
        assertEquals("Gold", response.getMembers(0).getMembership());
    }

    @Test
    public void testDeleteMember() {
        Member member = new Member.Builder()
                .withName("Delete Me")
                .withMembershipType("Silver")
                .build();
        member = memberRepository.save(member);

        DeleteMemberRequest deleteRequest = DeleteMemberRequest.newBuilder()
                .setMemberId(member.getId())
                .build();
        memberStub.deleteMember(deleteRequest);

        GetMemberRequest getRequest = GetMemberRequest.newBuilder()
                .setMemberId(member.getId())
                .build();
        StatusRuntimeException exception = assertThrows(StatusRuntimeException.class, () -> {
            memberStub.getMember(getRequest);
        });
        assertEquals("Member not found", exception.getStatus().getDescription());
    }
}