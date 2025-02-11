package de.thws.fiw.gymmanagement;

import de.thws.fiw.gymmanagement.application.BookingServiceGrpc;
import de.thws.fiw.gymmanagement.application.CourseServiceGrpc;
import de.thws.fiw.gymmanagement.application.MemberServiceGrpc;
import de.thws.fiw.gymmanagement.application.TrainerServiceGrpc;
import de.thws.fiw.gymmanagement.application.BookingServiceImpl;
import de.thws.fiw.gymmanagement.application.CourseServiceImpl;
import de.thws.fiw.gymmanagement.application.MemberServiceImpl;
import de.thws.fiw.gymmanagement.application.TrainerServiceImpl;
import de.thws.fiw.gymmanagement.application.service.*;
import de.thws.fiw.gymmanagement.infrastructure.BookingRepository;
import de.thws.fiw.gymmanagement.infrastructure.CourseRepository;
import de.thws.fiw.gymmanagement.infrastructure.MemberRepository;
import de.thws.fiw.gymmanagement.infrastructure.TrainerRepository;
import de.thws.fiw.gymmanagement.infrastructure.BookingRepositoryInterface;
import de.thws.fiw.gymmanagement.infrastructure.CourseRepositoryInterface;
import de.thws.fiw.gymmanagement.infrastructure.MemberRepositoryInterface;
import de.thws.fiw.gymmanagement.infrastructure.TrainerRepositoryInterface;
import io.grpc.Server;
import io.grpc.ServerBuilder;

import java.io.IOException;

public class GymServer {

    public static void main(String[] args) throws IOException, InterruptedException {
        Server server = createServer();
        System.out.println("Server running on port " + server.getPort());
        server.awaitTermination();
    }

    /**
     * Erstellt den gRPC-Server mit allen Services (Member, Trainer, Course, Booking).
     */
    private static Server createServer() throws IOException, InterruptedException {
        // Repositories initialisieren
        MemberRepositoryInterface memberRepository = new MemberRepository();
        TrainerRepositoryInterface trainerRepository = new TrainerRepository();
        CourseRepositoryInterface courseRepository = new CourseRepository();
        BookingRepositoryInterface bookingRepository = new BookingRepository();

        // Geschäftslogik (Services) initialisieren
        MemberServiceAdapter memberService = new MemberService(memberRepository);
        TrainerServiceAdapter trainerService = new TrainerService(trainerRepository);
        CourseServiceAdapter courseService = new CourseService(courseRepository, trainerRepository);
        BookingServiceAdapter bookingService = new BookingService(bookingRepository, memberRepository, courseRepository);

        // gRPC-Serviceimplementierungen (Adapter) erstellen
        MemberServiceImpl memberServiceImpl = new MemberServiceImpl(memberService);
        TrainerServiceImpl trainerServiceImpl = new TrainerServiceImpl(trainerService);
        CourseServiceImpl courseServiceImpl = new CourseServiceImpl(courseService);
        BookingServiceImpl bookingServiceImpl = new BookingServiceImpl(bookingService);

        // gRPC-Server erstellen und alle Services registrieren
        return ServerBuilder.forPort(8080)
                .addService(memberServiceImpl)
                .addService(trainerServiceImpl)
                .addService(courseServiceImpl)
                .addService(bookingServiceImpl)
                .build()
                .start();
    }
}
