package de.thws.fiw.gymmanagement;

import de.thws.fiw.gymmanagement.application.*;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.StatusRuntimeException;

public class GymClient {
    public static void main(String[] args) {
        // Verbindung zum Server herstellen
        ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 8080)
                .usePlaintext() // SSL deaktivieren für lokale Tests
                .build();

        // Stub erzeugen
        GymServiceGrpc.GymServiceBlockingStub stub = GymServiceGrpc.newBlockingStub(channel);

        try {
            // Mitglieder CRUD
            System.out.println("--- Mitglieder ---");

            // Mitglied erstellen
            CreateMemberResponse createMemberResponse = stub.createMember(
                    CreateMemberRequest.newBuilder()
                            .setName("John Doe")
                            .setMembershipType("Premium")
                            .build());
            System.out.println("Erstelltes Mitglied mit ID: " + createMemberResponse.getMemberId());

            // Mitglied abrufen
            GetMemberResponse getMemberResponse = stub.getMember(
                    GetMemberRequest.newBuilder()
                            .setMemberId(createMemberResponse.getMemberId())
                            .build());
            System.out.println("Mitglied Details: Name = " + getMemberResponse.getName() + ", Mitgliedschaft = " + getMemberResponse.getMembershipType());

            // Mitglied aktualisieren
            UpdateMemberResponse updateMemberResponse = stub.updateMember(
                    UpdateMemberRequest.newBuilder()
                            .setMemberId(createMemberResponse.getMemberId())
                            .setName("John Updated")
                            .setMembershipType("Standard")
                            .build());
            System.out.println("Update erfolgreich: " + updateMemberResponse.getSuccess());

            // Alle Mitglieder abrufen
            System.out.println("Alle Mitglieder:");
            GetAllMembersResponse allMembersResponse = stub.getAllMembers(Empty.newBuilder().build());
            for (GetMemberResponse member : allMembersResponse.getMembersList()) {
                System.out.println("- ID: " + member.getMemberId() + ", Name: " + member.getName());
            }

            // Trainer CRUD
            System.out.println("--- Trainer ---");

            // Trainer erstellen
            CreateTrainerResponse createTrainerResponse = stub.createTrainer(
                    CreateTrainerRequest.newBuilder()
                            .setName("John Smith")
                            .setExpertise("Strength Training")
                            .build());
            System.out.println("Erstellter Trainer mit ID: " + createTrainerResponse.getTrainerId());

            // Kurs erstellen
            CreateCourseResponse createCourseResponse = stub.createCourse(
                    CreateCourseRequest.newBuilder()
                            .setName("Yoga Class")
                            .setCapacity(15)
                            .setTrainerId(createTrainerResponse.getTrainerId())
                            .build());
            System.out.println("Erstellter Kurs mit ID: " + createCourseResponse.getCourseId());

            // Buchung erstellen
            System.out.println("--- Buchungen ---");
            CreateBookingResponse createBookingResponse = stub.createBooking(
                    CreateBookingRequest.newBuilder()
                            .setMemberId(createMemberResponse.getMemberId()) // Mitglied existiert
                            .setCourseId(createCourseResponse.getCourseId())
                            .build());
            System.out.println("Buchung erstellt mit ID: " + createBookingResponse.getBookingId());

            // Buchungen eines Mitglieds abrufen
            GetBookingsByMemberResponse getBookingsByMemberResponse = stub.getBookingsByMember(
                    GetBookingsByMemberRequest.newBuilder()
                            .setMemberId(createMemberResponse.getMemberId())
                            .build());
            System.out.println("Buchungen des Mitglieds:");
            for (BookingResponse booking : getBookingsByMemberResponse.getBookingsList()) {
                System.out.println("- Buchung ID: " + booking.getBookingId() + ", Kurs ID: " + booking.getCourseId());
            }

        } catch (StatusRuntimeException e) {
            System.err.println("Fehler bei der Kommunikation mit dem Server: " + e.getStatus().getDescription());
        } finally {
            // Verbindung sicher schließen
            channel.shutdown();
        }
    }
}
