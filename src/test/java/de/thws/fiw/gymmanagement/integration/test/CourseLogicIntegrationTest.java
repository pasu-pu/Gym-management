package de.thws.fiw.gymmanagement.integration.test;

import de.thws.fiw.gymmanagement.application.CourseServiceImpl;
import de.thws.fiw.gymmanagement.domain.CourseLogic;
import de.thws.fiw.gymmanagement.infrastructure.CourseRepository;
import de.thws.fiw.gymmanagement.infrastructure.TrainerRepository;
import de.thws.fiw.gymmanagement.domain.Trainer;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.Server;
import io.grpc.ServerBuilder;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CourseLogicIntegrationTest {

    private static Server server;
    private static ManagedChannel channel;
    private static CourseServiceGrpc.CourseServiceBlockingStub courseStub;
    private static TrainerRepository trainerRepository;

    @BeforeAll
    public static void startServer() throws Exception {
        // Create repositories and service
        var courseRepository = new CourseRepository();
        trainerRepository = new TrainerRepository();
        // Create a Trainer using the Builder pattern
        Trainer trainer = new Trainer.Builder()
                .withName("IntegrationTrainer")
                .withExpertise("Yoga")
                .build();
        trainer = trainerRepository.save(trainer);

        CourseLogic courseLogic = new CourseLogic(courseRepository, trainerRepository);
        var serviceImpl = new CourseServiceImpl(courseLogic);

        server = ServerBuilder.forPort(8081)
                .addService(serviceImpl)
                .build()
                .start();

        channel = ManagedChannelBuilder.forAddress("localhost", 8081)
                .usePlaintext()
                .build();
        courseStub = CourseServiceGrpc.newBlockingStub(channel);
    }

    @AfterAll
    public static void stopServer() throws Exception {
        channel.shutdownNow();
        server.shutdownNow();
    }

    @Test
    public void testCreateAndGetCourse() {
        // Use an existing trainer from trainerRepository
        Trainer trainer = trainerRepository.findAll().get(0);
        CreateCourseRequest createRequest = CreateCourseRequest.newBuilder()
                .setName("IntegrationCourse")
                .setCapacity(30)
                .setTrainerId(trainer.getId())
                .build();
        var createResponse = courseStub.createCourse(createRequest);
        assertTrue(createResponse.getCourseId() > 0);

        var getRequest = GetCourseRequest.newBuilder()
                .setCourseId(createResponse.getCourseId())
                .build();
        var getResponse = courseStub.getCourse(getRequest);
        assertEquals("IntegrationCourse", getResponse.getName());
        assertEquals(30, getResponse.getCapacity());
        assertEquals(trainer.getId(), getResponse.getTrainerId());
    }
}
