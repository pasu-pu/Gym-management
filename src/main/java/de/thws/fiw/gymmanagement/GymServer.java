package de.thws.fiw.gymmanagement;

import de.thws.fiw.gymmanagement.application.GymServiceImpl;
import de.thws.fiw.gymmanagement.infrastructure.MemberRepository;
import io.grpc.Server;
import io.grpc.ServerBuilder;

public class GymServer {
    public static void main(String[] args) throws Exception {
        MemberRepository repository = new MemberRepository();
        GymServiceImpl service = new GymServiceImpl();

        Server server = ServerBuilder.forPort(8080)
                .addService(service)
                .build();

        System.out.println("Server running on port 8080");
        server.start();
        server.awaitTermination();
    }
}
