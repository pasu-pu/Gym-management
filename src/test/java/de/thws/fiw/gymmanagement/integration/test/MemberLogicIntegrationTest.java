package de.thws.fiw.gymmanagement.integration.test;

import de.thws.fiw.gymmanagement.application.*;
import de.thws.fiw.gymmanagement.domain.MemberLogic;
import de.thws.fiw.gymmanagement.infrastructure.MemberRepository;
import de.thws.fiw.gymmanagement.infrastructure.MemberRepositoryInterface;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.Server;
import io.grpc.ServerBuilder;
import org.junit.jupiter.api.AfterAll;
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
        // Create the actual repository and service
        memberRepository = new MemberRepository();
        MemberLogic memberLogic = new MemberLogic(memberRepository);
        // Create the gRPC service implementation
        MemberServiceImpl serviceImpl = new MemberServiceImpl(memberLogic);

        // Start the server on a test port (e.g., 8081)
        server = ServerBuilder.forPort(8080)
                .addService(serviceImpl)
                .build()
                .start();

        channel = ManagedChannelBuilder.forAddress("localhost", 8080)
                .usePlaintext()
                .build();
        memberStub = MemberServiceGrpc.newBlockingStub(channel);
    }

    @AfterAll
    public static void stopServer() throws Exception {
        // Löscht alle Mitglieder
        memberRepository.deleteAll();
        channel.shutdownNow();
        server.shutdownNow();
    }

    @Test
    public void testCreateAndGetMember() {
        CreateMemberRequest createRequest = CreateMemberRequest.newBuilder()
                .setName("IntegrationUser")
                .setMembership("Gold")
                .build();
        var createResponse = memberStub.createMember(createRequest);
        assertTrue(createResponse.getMemberId() > 0);

        var getRequest = GetMemberRequest.newBuilder()
                .setMemberId(createResponse.getMemberId())
                .build();
        var getResponse = memberStub.getMember(getRequest);
        assertEquals("IntegrationUser", getResponse.getName());
        assertEquals("Gold", getResponse.getMembership());
    }
}
