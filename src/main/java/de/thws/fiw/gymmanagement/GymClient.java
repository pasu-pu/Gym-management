package de.thws.fiw.gymmanagement;

import de.thws.fiw.gymmanagement.application.*;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

public class GymClient {
    public static void main(String[] args) {
        // Verbindung zum Server herstellen
        ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 8080)
                .usePlaintext() // SSL deaktivieren für lokale Tests
                .build();

        // Stub erzeugen
        GymServiceGrpc.GymServiceBlockingStub stub = GymServiceGrpc.newBlockingStub(channel);

        // Anfrage senden: CreateMember
        CreateMemberRequest createRequest = CreateMemberRequest.newBuilder()
                .setName("John Doe")
                .setMembershipType("Premium")
                .build();
        CreateMemberResponse createResponse = stub.createMember(createRequest);
        System.out.println("Erstellter Member mit ID: " + createResponse.getMemberId());

        // Anfrage senden: GetMember
        GetMemberRequest getRequest = GetMemberRequest.newBuilder()
                .setMemberId(createResponse.getMemberId())
                .build();
        GetMemberResponse getResponse = stub.getMember(getRequest);
        System.out.println("Member Details:");
        System.out.println("Name: " + getResponse.getName());
        System.out.println("Mitgliedschaft: " + getResponse.getMembershipType());

        // Anfrage: GetAllMembers
        Empty emptyRequest = Empty.newBuilder().build();
        GetAllMembersResponse allMembersResponse = stub.getAllMembers(emptyRequest);

        System.out.println("Alle Mitglieder:");
        for (GetMemberResponse member : allMembersResponse.getMembersList()) {
            System.out.println("- ID: " + member.getMemberId() + ", Name: " + member.getName());
        }

        // Verbindung schließen
        channel.shutdown();
    }
}
