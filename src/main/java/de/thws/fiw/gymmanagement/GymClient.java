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
            long trainerId = handleTrainerCRUD(stub);
            long courseId = handleCourseCRUD(stub, trainerId);

            // Buchung testen
            handleBookingCRUD(stub, memberId, courseId);

        } catch (StatusRuntimeException e) {
            System.err.println("❌ Fehler bei der Kommunikation mit dem Server: " + e.getStatus().getDescription());
            e.printStackTrace();
        } finally {
            channel.shutdown();
        }
    }

    // --- Mitglieder CRUD ---
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

        // Alle Mitglieder abrufen
        System.out.println("📋 Alle Mitglieder:");
        GetAllMembersResponse allMembersResponse = stub.getAllMembers(Empty.newBuilder().build());
        for (GetMemberResponse member : allMembersResponse.getMembersList()) {
            System.out.println("- 📌 Mitglied ID: " + member.getMemberId() + ", Name: " + member.getName());
        }

        return memberId;
    }

    // --- Trainer CRUD ---
    private static long handleTrainerCRUD(GymServiceGrpc.GymServiceBlockingStub stub) {
        System.out.println("--- Trainer ---");

        // Trainer erstellen
        CreateTrainerResponse createTrainerResponse = stub.createTrainer(
                CreateTrainerRequest.newBuilder()
                        .setName("John Smith")
                        .setExpertise("Strength Training")
                        .build());
        long trainerId = createTrainerResponse.getTrainerId();
        System.out.println("✅ Erstellter Trainer mit ID: " + trainerId);

        // Alle Trainer abrufen
        System.out.println("📋 Alle Trainer:");
        GetAllTrainersResponse allTrainersResponse = stub.getAllTrainers(Empty.newBuilder().build());
        for (GetTrainerResponse trainer : allTrainersResponse.getTrainersList()) {
            System.out.println("- 📌 Trainer ID: " + trainer.getTrainerId() + ", Name: " + trainer.getName());
        }

        return trainerId;
    }

    // --- Kurse CRUD ---
    private static long handleCourseCRUD(GymServiceGrpc.GymServiceBlockingStub stub, long trainerId) {
        System.out.println("--- Kurse ---");

        // Kurs erstellen
        CreateCourseResponse createCourseResponse = stub.createCourse(
                CreateCourseRequest.newBuilder()
                        .setName("Yoga Class")
                        .setCapacity(15)
                        .setTrainerId(trainerId)
                        .build());
        long courseId = createCourseResponse.getCourseId();
        System.out.println("✅ Erstellter Kurs mit ID: " + courseId);

        // Kurs abrufen
        GetCourseResponse getCourseResponse = stub.getCourse(
                GetCourseRequest.newBuilder().setCourseId(courseId).build());
        System.out.println("ℹ️ Kurs Details: Name = " + getCourseResponse.getName() + ", Kapazität = " + getCourseResponse.getCapacity());

        // Alle Kurse abrufen
        System.out.println("📋 Alle Kurse:");
        GetAllCoursesResponse allCoursesResponse = stub.getAllCourses(Empty.newBuilder().build());
        for (GetCourseResponse course : allCoursesResponse.getCoursesList()) {
            System.out.println("- 📌 Kurs ID: " + course.getCourseId() + ", Name: " + course.getName());
        }

        // Kurs aktualisieren
        UpdateCourseResponse updateCourseResponse = stub.updateCourse(
                UpdateCourseRequest.newBuilder()
                        .setCourseId(courseId)
                        .setName("Advanced Yoga")
                        .setCapacity(20)
                        .setTrainerId(trainerId)
                        .build());
        System.out.println("🔄 Kurs-Update erfolgreich: " + updateCourseResponse.getSuccess());

        return courseId;
    }

    // --- Buchungen CRUD ---
    private static void handleBookingCRUD(GymServiceGrpc.GymServiceBlockingStub stub, long memberId, long courseId) {
        System.out.println("--- Buchungen ---");

        try {
            // Buchung erstellen
            CreateBookingResponse createBookingResponse = stub.createBooking(
                    CreateBookingRequest.newBuilder()
                            .setMemberId(memberId)
                            .setCourseId(courseId)
                            .build());
            long bookingId = createBookingResponse.getBookingId();
            System.out.println("✅ Buchung erstellt mit ID: " + bookingId);

            // Buchungen eines Mitglieds abrufen
            GetBookingsByMemberResponse getBookingsByMemberResponse = stub.getBookingsByMember(
                    GetBookingsByMemberRequest.newBuilder()
                            .setMemberId(memberId)
                            .build());
            System.out.println("📋 Buchungen des Mitglieds:");
            for (BookingResponse booking : getBookingsByMemberResponse.getBookingsList()) {
                System.out.println("- 📌 Buchung ID: " + booking.getBookingId() + ", Kurs ID: " + booking.getCourseId());
            }

            // Buchungen eines Kurses abrufen
            GetBookingsByCourseResponse getBookingsByCourseResponse = stub.getBookingsByCourse(
                    GetBookingsByCourseRequest.newBuilder()
                            .setCourseId(courseId)
                            .build());
            System.out.println("📋 Buchungen für Kurs ID " + courseId + ":");
            for (BookingResponse booking : getBookingsByCourseResponse.getBookingsList()) {
                System.out.println("- 📌 Buchung ID: " + booking.getBookingId() + ", Mitglied ID: " + booking.getMemberId());
            }

            // Buchung löschen
            DeleteBookingResponse deleteBookingResponse = stub.deleteBooking(
                    DeleteBookingRequest.newBuilder()
                            .setBookingId(bookingId)
                            .build());
            System.out.println("🗑️ Buchung gelöscht: " + deleteBookingResponse.getSuccess());

        } catch (StatusRuntimeException e) {
            System.err.println("⚠️ Fehler bei der Buchung: " + e.getStatus().getDescription());
        }
    }
}
