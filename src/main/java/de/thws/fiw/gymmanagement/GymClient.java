package de.thws.fiw.gymmanagement;

import de.thws.fiw.gymmanagement.application.*;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.StatusRuntimeException;

public class GymClient {
    public static void main(String[] args) {
        // Verbindung zum Server herstellen
        ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 8080)
                .usePlaintext()
                .build();

        // Stub erzeugen
        GymServiceGrpc.GymServiceBlockingStub stub = GymServiceGrpc.newBlockingStub(channel);

        try {
            // Mitglieder testen
            long memberId = handleMemberCRUD(stub);

            // Trainer & Kurs testen
            long trainerId = handleTrainerAndCourseCRUD(stub);

            // Buchung testen
            handleBookingCRUD(stub, memberId, trainerId);

        } catch (StatusRuntimeException e) {
            System.err.println("❌ Fehler bei der Kommunikation mit dem Server: " + e.getStatus().getDescription());
            e.printStackTrace();
        } finally {
            channel.shutdown();
        }
    }

    private static long handleMemberCRUD(GymServiceGrpc.GymServiceBlockingStub stub) {
        System.out.println("--- Mitglieder ---");

        // Mitglied erstellen
        CreateMemberResponse createMemberResponse = stub.createMember(
                CreateMemberRequest.newBuilder()
                        .setName("John Doe")
                        .setMembershipType("Premium")
                        .build());
        long memberId = createMemberResponse.getMemberId();
        System.out.println("✅ Erstelltes Mitglied mit ID: " + memberId);

        // Mitglied abrufen
        GetMemberResponse getMemberResponse = stub.getMember(
                GetMemberRequest.newBuilder().setMemberId(memberId).build());
        System.out.println("ℹ️ Mitglied Details: Name = " + getMemberResponse.getName() + ", Mitgliedschaft = " + getMemberResponse.getMembershipType());

        // Mitglied aktualisieren
        UpdateMemberResponse updateMemberResponse = stub.updateMember(
                UpdateMemberRequest.newBuilder()
                        .setMemberId(memberId)
                        .setName("John Updated")
                        .setMembershipType("Standard")
                        .build());
        System.out.println("🔄 Update erfolgreich: " + updateMemberResponse.getSuccess());

        // Alle Mitglieder abrufen
        System.out.println("📋 Alle Mitglieder:");
        GetAllMembersResponse allMembersResponse = stub.getAllMembers(Empty.newBuilder().build());
        for (GetMemberResponse member : allMembersResponse.getMembersList()) {
            System.out.println("- ID: " + member.getMemberId() + ", Name: " + member.getName());
        }

        return memberId;
    }

    private static long handleTrainerAndCourseCRUD(GymServiceGrpc.GymServiceBlockingStub stub) {
        System.out.println("--- Trainer ---");

        // Trainer erstellen
        CreateTrainerResponse createTrainerResponse = stub.createTrainer(
                CreateTrainerRequest.newBuilder()
                        .setName("John Smith")
                        .setExpertise("Strength Training")
                        .build());
        long trainerId = createTrainerResponse.getTrainerId();
        System.out.println("✅ Erstellter Trainer mit ID: " + trainerId);

        // Kurs erstellen
        CreateCourseResponse createCourseResponse = stub.createCourse(
                CreateCourseRequest.newBuilder()
                        .setName("Yoga Class")
                        .setCapacity(15)
                        .setTrainerId(trainerId)
                        .build());
        System.out.println("✅ Erstellter Kurs mit ID: " + createCourseResponse.getCourseId());

        return trainerId;
    }

    private static void handleBookingCRUD(GymServiceGrpc.GymServiceBlockingStub stub, long memberId, long trainerId) {
        System.out.println("--- Buchungen ---");

        try {
            // Buchung erstellen
            CreateBookingResponse createBookingResponse = stub.createBooking(
                    CreateBookingRequest.newBuilder()
                            .setMemberId(memberId)
                            .setCourseId(trainerId)
                            .build());
            System.out.println("✅ Buchung erstellt mit ID: " + createBookingResponse.getBookingId());

            // Buchungen eines Mitglieds abrufen
            GetBookingsByMemberResponse getBookingsByMemberResponse = stub.getBookingsByMember(
                    GetBookingsByMemberRequest.newBuilder()
                            .setMemberId(memberId)
                            .build());
            System.out.println("📋 Buchungen des Mitglieds:");
            for (BookingResponse booking : getBookingsByMemberResponse.getBookingsList()) {
                System.out.println("- 📌 Buchung ID: " + booking.getBookingId() + ", Kurs ID: " + booking.getCourseId());
            }

        } catch (StatusRuntimeException e) {
            System.err.println("⚠️ Fehler bei der Buchung: " + e.getStatus().getDescription());
        }
    }
}
