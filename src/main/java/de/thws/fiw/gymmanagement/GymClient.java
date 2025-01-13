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
            CreateMemberRequest createMemberRequest = CreateMemberRequest.newBuilder()
                    .setName("John Doe")
                    .setMembershipType("Premium")
                    .build();
            CreateMemberResponse createMemberResponse = stub.createMember(createMemberRequest);
            System.out.println("Erstelltes Mitglied mit ID: " + createMemberResponse.getMemberId());

            // Mitglied abrufen
            GetMemberRequest getMemberRequest = GetMemberRequest.newBuilder()
                    .setMemberId(createMemberResponse.getMemberId())
                    .build();
            GetMemberResponse getMemberResponse = stub.getMember(getMemberRequest);
            System.out.println("Mitglied Details: Name = " + getMemberResponse.getName() + ", Mitgliedschaft = " + getMemberResponse.getMembershipType());

            // Mitglied aktualisieren
            UpdateMemberRequest updateMemberRequest = UpdateMemberRequest.newBuilder()
                    .setMemberId(createMemberResponse.getMemberId())
                    .setName("John Updated")
                    .setMembershipType("Standard")
                    .build();
            UpdateMemberResponse updateMemberResponse = stub.updateMember(updateMemberRequest);
            System.out.println("Update erfolgreich: " + updateMemberResponse.getSuccess());

            // Alle Mitglieder abrufen
            Empty emptyRequest = Empty.newBuilder().build();
            GetAllMembersResponse allMembersResponse = stub.getAllMembers(emptyRequest);
            System.out.println("Alle Mitglieder:");
            for (GetMemberResponse member : allMembersResponse.getMembersList()) {
                System.out.println("- ID: " + member.getMemberId() + ", Name: " + member.getName());
            }

            // Mitglied löschen
            DeleteMemberRequest deleteMemberRequest = DeleteMemberRequest.newBuilder()
                    .setMemberId(createMemberResponse.getMemberId())
                    .build();
            DeleteMemberResponse deleteMemberResponse = stub.deleteMember(deleteMemberRequest);
            System.out.println("Löschen erfolgreich: " + deleteMemberResponse.getSuccess());

            // Trainer CRUD
            System.out.println("--- Trainer ---");

            // Trainer erstellen
            CreateTrainerRequest createTrainerRequest = CreateTrainerRequest.newBuilder()
                    .setName("John Smith")
                    .setExpertise("Strength Training")
                    .build();
            CreateTrainerResponse createTrainerResponse = stub.createTrainer(createTrainerRequest);
            System.out.println("Erstellter Trainer mit ID: " + createTrainerResponse.getTrainerId());

            // Trainer aktualisieren
            UpdateTrainerRequest updateTrainerRequest = UpdateTrainerRequest.newBuilder()
                    .setTrainerId(createTrainerResponse.getTrainerId())
                    .setName("Jane Doe")
                    .setExpertise("Cardio Training")
                    .build();
            UpdateTrainerResponse updateTrainerResponse = stub.updateTrainer(updateTrainerRequest);
            System.out.println("Update erfolgreich: " + updateTrainerResponse.getSuccess());

            // Alle Trainer abrufen
            GetAllTrainersResponse allTrainersResponse = stub.getAllTrainers(emptyRequest);
            System.out.println("Alle Trainer:");
            for (GetTrainerResponse trainer : allTrainersResponse.getTrainersList()) {
                System.out.println("- ID: " + trainer.getTrainerId() + ", Name: " + trainer.getName());
            }

            // Kurse CRUD
            System.out.println("--- Kurse ---");

            // Kurs erstellen
            CreateCourseRequest createCourseRequest = CreateCourseRequest.newBuilder()
                    .setName("Yoga Class")
                    .setCapacity(15)
                    .setTrainerId(createTrainerResponse.getTrainerId()) // Verwende eine gültige Trainer-ID
                    .build();
            CreateCourseResponse createCourseResponse = stub.createCourse(createCourseRequest);
            System.out.println("Erstellter Kurs mit ID: " + createCourseResponse.getCourseId());

            // Kurs abrufen
            GetCourseRequest getCourseRequest = GetCourseRequest.newBuilder()
                    .setCourseId(createCourseResponse.getCourseId())
                    .build();
            GetCourseResponse getCourseResponse = stub.getCourse(getCourseRequest);
            System.out.println("Kurs Details: Name = " + getCourseResponse.getName() + ", Kapazität = " + getCourseResponse.getCapacity());

            // Alle Kurse abrufen
            GetAllCoursesResponse allCoursesResponse = stub.getAllCourses(emptyRequest);
            System.out.println("Alle Kurse:");
            for (GetCourseResponse course : allCoursesResponse.getCoursesList()) {
                System.out.println("- ID: " + course.getCourseId() + ", Name: " + course.getName());
            }

            // Kurse eines Trainers abrufen
            GetCoursesByTrainerRequest getCoursesByTrainerRequest = GetCoursesByTrainerRequest.newBuilder()
                    .setTrainerId(createTrainerResponse.getTrainerId())
                    .build();
            GetCoursesByTrainerResponse getCoursesByTrainerResponse = stub.getCoursesByTrainer(getCoursesByTrainerRequest);
            System.out.println("Kurse von Trainer mit ID " + createTrainerResponse.getTrainerId() + ":");
            for (GetCourseResponse course : getCoursesByTrainerResponse.getCoursesList()) {
                System.out.println("- ID: " + course.getCourseId() + ", Name: " + course.getName());
            }

            // Kurs löschen
            DeleteCourseRequest deleteCourseRequest = DeleteCourseRequest.newBuilder()
                    .setCourseId(createCourseResponse.getCourseId())
                    .build();
            DeleteCourseResponse deleteCourseResponse = stub.deleteCourse(deleteCourseRequest);
            System.out.println("Löschen erfolgreich: " + deleteCourseResponse.getSuccess());

        } catch (StatusRuntimeException e) {
            System.err.println("Fehler bei der Kommunikation mit dem Server: " + e.getStatus().getDescription());
        } finally {
            // Verbindung schließen
            channel.shutdown();
        }
    }
}
