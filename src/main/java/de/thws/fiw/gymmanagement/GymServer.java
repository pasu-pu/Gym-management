package de.thws.fiw.gymmanagement;

import de.thws.fiw.gymmanagement.application.GymServiceImpl;
import de.thws.fiw.gymmanagement.application.service.*;
import de.thws.fiw.gymmanagement.infrastructure.*;
import io.grpc.Server;
import io.grpc.ServerBuilder;

import java.io.IOException;

public class GymServer {
    public static void main(String[] args) throws IOException, InterruptedException {
        // gRPC-Service initialisieren mit separater Methode
        GymServiceImpl service = createGymService();

        // gRPC-Server starten
        Server server = ServerBuilder.forPort(8080)
                .addService(service)
                .build()
                .start();

        System.out.println("Server running on port 8080");

        server.awaitTermination();
    }

    /**
     * Erstellt die Service-Instanz mit allen benötigten Abhängigkeiten.
     */
    private static GymServiceImpl createGymService() {
        // Repositories initialisieren
        MemberRepositoryInterface memberRepository = new MemberRepository();
        TrainerRepositoryInterface trainerRepository = new TrainerRepository();
        CourseRepositoryInterface courseRepository = new CourseRepository();
        BookingRepositoryInterface bookingRepository = new BookingRepository();

        // Services initialisieren
        MemberService memberService = new MemberService(memberRepository);
        TrainerService trainerService = new TrainerService(trainerRepository);
        CourseService courseService = new CourseService(courseRepository, trainerRepository);
        BookingService bookingService = new BookingService(bookingRepository, memberRepository, courseRepository);

        // GymServiceImpl mit Dependency Injection erstellen
        return new GymServiceImpl(memberService, trainerService, courseService, bookingService);
    }
}
