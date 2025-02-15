package de.thws.fiw.gymmanagement.integration.test;

import de.thws.fiw.gymmanagement.application.*;
import de.thws.fiw.gymmanagement.domain.TrainerLogic;
import de.thws.fiw.gymmanagement.infrastructure.*;
import de.thws.fiw.gymmanagement.domain.Trainer;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.StatusRuntimeException;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
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
        trainerRepository = new TrainerRepository();

        TrainerLogic trainerLogic = new TrainerLogic(trainerRepository);
        TrainerServiceImpl serviceImpl = new TrainerServiceImpl(trainerLogic);

        server = ServerBuilder.forPort(8083)
                .addService(serviceImpl)
                .build()
                .start();

        channel = ManagedChannelBuilder.forAddress("localhost", 8083)
                .usePlaintext()
                .build();
        trainerStub = TrainerServiceGrpc.newBlockingStub(channel);
    }

    @AfterAll
    public static void stopServer() {
        channel.shutdownNow();
        server.shutdownNow();
    }

    @AfterEach
    public void cleanDatabase() {
        trainerRepository.deleteAll();
    }

    @Test
    public void testCreateTrainer() {
        CreateTrainerRequest createRequest = CreateTrainerRequest.newBuilder()
                .setName("Alice Smith")
                .setExpertise("Yoga")
                .build();
        var createResponse = trainerStub.createTrainer(createRequest);

        assertNotNull(createResponse.getTrainerId());
        assertEquals("Alice Smith", createResponse.getName());
        assertEquals("Yoga", createResponse.getExpertise());
    }

    @Test
    public void testUpdateTrainer() {
        Trainer trainer = new Trainer.Builder()
                .withName("Bob Brown")
                .withExpertise("Pilates")
                .build();
        trainer = trainerRepository.save(trainer);

        UpdateTrainerRequest updateRequest = UpdateTrainerRequest.newBuilder()
                .setTrainerId(trainer.getId())
                .setName("Robert Brown")
                .setExpertise("Advanced Pilates")
                .build();
        var updateResponse = trainerStub.updateTrainer(updateRequest);

        assertEquals("Robert Brown", updateResponse.getName());
        assertEquals("Advanced Pilates", updateResponse.getExpertise());
    }

    @Test
    public void testGetTrainer() {
        Trainer trainer = new Trainer.Builder()
                .withName("Cathy Lee")
                .withExpertise("Zumba")
                .build();
        trainer = trainerRepository.save(trainer);

        GetTrainerRequest getRequest = GetTrainerRequest.newBuilder()
                .setTrainerId(trainer.getId())
                .build();
        var getResponse = trainerStub.getTrainer(getRequest);

        assertEquals(trainer.getId(), getResponse.getTrainerId());
        assertEquals("Cathy Lee", getResponse.getName());
    }

    @Test
    public void testGetAllTrainers() {
        Trainer trainer1 = new Trainer.Builder()
                .withName("Dave Thomas")
                .withExpertise("Boxing")
                .build();
        Trainer trainer2 = new Trainer.Builder()
                .withName("Eric Johnson")
                .withExpertise("Karate")
                .build();

        trainerRepository.save(trainer1);
        trainerRepository.save(trainer2);

        GetAllTrainersRequest request = GetAllTrainersRequest.newBuilder()
                .setPagesize(10)
                .setIndex(0)
                .build();
        GetAllTrainersResponse response = trainerStub.getAllTrainers(request);

        assertTrue(response.getTrainersCount() >= 2);
    }

    @Test
    public void testGetTrainerByName() {
        Trainer trainer = new Trainer.Builder()
                .withName("Fiona Green")
                .withExpertise("Cycling")
                .build();
        trainer = trainerRepository.save(trainer);

        GetTrainerByNameRequest request = GetTrainerByNameRequest.newBuilder()
                .setName("Fiona Green")
                .setPagesize(10)
                .setIndex(0)
                .build();
        GetAllTrainersResponse response = trainerStub.getTrainerByName(request);

        assertEquals(1, response.getTrainersCount());
        assertEquals("Fiona Green", response.getTrainers(0).getName());
    }

    @Test
    public void testGetTrainerByExpertise() {
        Trainer trainer = new Trainer.Builder()
                .withName("Gina White")
                .withExpertise("Strength Training")
                .build();
        trainer = trainerRepository.save(trainer);

        GetTrainerByExpertiseRequest request = GetTrainerByExpertiseRequest.newBuilder()
                .setExpertise("Strength Training")
                .setPagesize(10)
                .setIndex(0)
                .build();
        GetAllTrainersResponse response = trainerStub.getTrainerByExpertise(request);

        assertEquals(1, response.getTrainersCount());
        assertEquals("Strength Training", response.getTrainers(0).getExpertise());
    }

    @Test
    public void testDeleteTrainer() {
        Trainer trainer = new Trainer.Builder()
                .withName("Henry Young")
                .withExpertise("Crossfit")
                .build();
        trainer = trainerRepository.save(trainer);

        DeleteTrainerRequest deleteRequest = DeleteTrainerRequest.newBuilder()
                .setTrainerId(trainer.getId())
                .build();
        trainerStub.deleteTrainer(deleteRequest);

        GetTrainerRequest getRequest = GetTrainerRequest.newBuilder()
                .setTrainerId(trainer.getId())
                .build();
        StatusRuntimeException exception = assertThrows(StatusRuntimeException.class, () -> {
            trainerStub.getTrainer(getRequest);
        });
        assertEquals("Trainer not found", exception.getStatus().getDescription());
    }
}