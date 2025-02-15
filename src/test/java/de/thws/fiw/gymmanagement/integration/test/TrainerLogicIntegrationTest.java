package de.thws.fiw.gymmanagement.integration.test;

import de.thws.fiw.gymmanagement.application.*;
import de.thws.fiw.gymmanagement.domain.TrainerLogic;
import de.thws.fiw.gymmanagement.infrastructure.TrainerRepository;
import de.thws.fiw.gymmanagement.infrastructure.TrainerRepositoryInterface;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.Server;
import io.grpc.ServerBuilder;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TrainerLogicIntegrationTest {

    private static Server server;
    private static ManagedChannel channel;
    private static TrainerServiceGrpc.TrainerServiceBlockingStub trainerStub;
    private static TrainerRepositoryInterface trainerRepository;

    @BeforeAll
    public static void startServer() throws Exception {
        // Create the repository and service
        trainerRepository = new TrainerRepository();
        TrainerLogic trainerLogic = new TrainerLogic(trainerRepository);
        var serviceImpl = new TrainerServiceImpl(trainerLogic);

        // Start the server on port 8081 (or different port if needed)
        server = ServerBuilder.forPort(8080)
                .addService(serviceImpl)
                .build()
                .start();

        channel = ManagedChannelBuilder.forAddress("localhost", 8080)
                .usePlaintext()
                .build();
        trainerStub = TrainerServiceGrpc.newBlockingStub(channel);
    }

    @AfterAll
    public static void stopServer() throws Exception {
        // Löscht alle Trainer
        trainerRepository.deleteAll();
        channel.shutdownNow();
        server.shutdownNow();
    }

    @Test
    public void testCreateAndGetTrainer() {
        CreateTrainerRequest createRequest = CreateTrainerRequest.newBuilder()
                .setName("IntegrationTrainer")
                .setExpertise("Strength")
                .build();
        var createResponse = trainerStub.createTrainer(createRequest);
        assertTrue(createResponse.getTrainerId() > 0);

        var getRequest = GetTrainerRequest.newBuilder()
                .setTrainerId(createResponse.getTrainerId())
                .build();
        var getResponse = trainerStub.getTrainer(getRequest);
        assertEquals("IntegrationTrainer", getResponse.getName());
        assertEquals("Strength", getResponse.getExpertise());
    }
}
