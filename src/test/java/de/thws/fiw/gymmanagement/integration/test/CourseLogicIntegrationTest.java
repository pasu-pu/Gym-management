package de.thws.fiw.gymmanagement.integration.test;

import de.thws.fiw.gymmanagement.application.*;
import de.thws.fiw.gymmanagement.domain.CourseLogic;
import de.thws.fiw.gymmanagement.infrastructure.*;
import de.thws.fiw.gymmanagement.domain.Course;
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

public class CourseLogicIntegrationTest {

    private static Server server;
    private static ManagedChannel channel;
    private static CourseServiceGrpc.CourseServiceBlockingStub courseStub;

    private static CourseRepositoryInterface courseRepository;
    private static TrainerRepositoryInterface trainerRepository;

    @BeforeAll
    public static void startServer() throws Exception {
        courseRepository = new CourseRepository();
        trainerRepository = new TrainerRepository();

        CourseLogic courseLogic = new CourseLogic(courseRepository, trainerRepository);
        CourseServiceImpl serviceImpl = new CourseServiceImpl(courseLogic);

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
    public static void stopServer() {
        channel.shutdownNow();
        server.shutdownNow();
    }

    @AfterEach
    public void cleanDatabase() {
        // Löscht alle Kurse und Trainer nach jedem Test
        courseRepository.deleteAll();
        trainerRepository.deleteAll();
    }

    @Test
    public void testCreateCourse() {
        Trainer trainer = new Trainer.Builder()
                .withName("CreateTrainer")
                .withExpertise("Fitness")
                .build();
        trainer = trainerRepository.save(trainer);

        CreateCourseRequest createRequest = CreateCourseRequest.newBuilder()
                .setName("Fitness Course")
                .setCapacity(20)
                .setTrainerId(trainer.getId())
                .build();
        var createResponse = courseStub.createCourse(createRequest);

        assertNotNull(createResponse.getCourseId());
        assertEquals("Fitness Course", createResponse.getName());
        assertEquals(20, createResponse.getCapacity());
    }

    @Test
    public void testUpdateCourse() {
        Trainer trainer = new Trainer.Builder()
                .withName("UpdateTrainer")
                .withExpertise("Yoga")
                .build();
        trainer = trainerRepository.save(trainer);

        Course course = new Course.Builder()
                .withName("Yoga Course")
                .withCapacity(25)
                .withTrainer(trainer)
                .build();
        course = courseRepository.save(course);

        UpdateCourseRequest updateRequest = UpdateCourseRequest.newBuilder()
                .setCourseId(course.getId())
                .setName("Updated Yoga Course")
                .setCapacity(30)
                .setTrainerId(trainer.getId())
                .build();
        var updateResponse = courseStub.updateCourse(updateRequest);

        assertEquals("Updated Yoga Course", updateResponse.getName());
        assertEquals(30, updateResponse.getCapacity());
        assertEquals(trainer.getId(), updateResponse.getTrainerId());
    }

    @Test
    public void testGetCourse() {
        Trainer trainer = new Trainer.Builder()
                .withName("GetTrainer")
                .withExpertise("Pilates")
                .build();
        trainer = trainerRepository.save(trainer);

        Course course = new Course.Builder()
                .withName("Pilates Course")
                .withCapacity(10)
                .withTrainer(trainer)
                .build();
        course = courseRepository.save(course);

        GetCourseRequest getRequest = GetCourseRequest.newBuilder()
                .setCourseId(course.getId())
                .build();
        var getResponse = courseStub.getCourse(getRequest);

        assertEquals(course.getId(), getResponse.getCourseId());
        assertEquals("Pilates Course", getResponse.getName());
    }

    @Test
    public void testGetAllCourses() {
        Trainer trainer = new Trainer.Builder()
                .withName("AllTrainer")
                .withExpertise("Running")
                .build();
        trainer = trainerRepository.save(trainer);

        Course course1 = new Course.Builder()
                .withName("Running Course 1")
                .withCapacity(5)
                .withTrainer(trainer)
                .build();
        Course course2 = new Course.Builder()
                .withName("Running Course 2")
                .withCapacity(8)
                .withTrainer(trainer)
                .build();

        courseRepository.save(course1);
        courseRepository.save(course2);

        GetAllCoursesRequest request = GetAllCoursesRequest.newBuilder()
                .setPagesize(10)
                .setIndex(0)
                .build();
        GetAllCoursesResponse response = courseStub.getAllCourses(request);

        assertTrue(response.getCoursesCount() >= 2);
    }

    @Test
    public void testGetCourseByName() {
        Trainer trainer = new Trainer.Builder()
                .withName("NameTrainer")
                .withExpertise("Cycling")
                .build();
        trainer = trainerRepository.save(trainer);

        Course course = new Course.Builder()
                .withName("Special Cycling Course")
                .withCapacity(15)
                .withTrainer(trainer)
                .build();
        course = courseRepository.save(course);

        GetCourseByNameRequest request = GetCourseByNameRequest.newBuilder()
                .setName("Special Cycling Course")
                .setPagesize(10)
                .setIndex(0)
                .build();
        GetAllCoursesResponse response = courseStub.getCourseByName(request);

        assertEquals(1, response.getCoursesCount());
        assertEquals(course.getId(), response.getCourses(0).getCourseId());
    }

    @Test
    public void testGetCourseByTrainer() {
        Trainer trainer = new Trainer.Builder()
                .withName("TrainerCourses")
                .withExpertise("Swimming")
                .build();
        trainer = trainerRepository.save(trainer);

        Course course = new Course.Builder()
                .withName("Swimming Course")
                .withCapacity(12)
                .withTrainer(trainer)
                .build();
        course = courseRepository.save(course);

        GetCourseByTrainerRequest request = GetCourseByTrainerRequest.newBuilder()
                .setTrainerId(trainer.getId())
                .setPagesize(10)
                .setIndex(0)
                .build();
        GetAllCoursesResponse response = courseStub.getCourseByTrainer(request);

        assertEquals(1, response.getCoursesCount());
        assertEquals(course.getId(), response.getCourses(0).getCourseId());
    }

    @Test
    public void testDeleteCourse() {
        Trainer trainer = new Trainer.Builder()
                .withName("DeleteCourseTrainer")
                .withExpertise("Climbing")
                .build();
        trainer = trainerRepository.save(trainer);

        Course course = new Course.Builder()
                .withName("Climbing Course")
                .withCapacity(20)
                .withTrainer(trainer)
                .build();
        course = courseRepository.save(course);

        DeleteCourseRequest deleteRequest = DeleteCourseRequest.newBuilder()
                .setCourseId(course.getId())
                .build();
        courseStub.deleteCourse(deleteRequest);

        GetCourseRequest getRequest = GetCourseRequest.newBuilder()
                .setCourseId(course.getId())
                .build();
        StatusRuntimeException exception = assertThrows(StatusRuntimeException.class, () -> {
            courseStub.getCourse(getRequest);
        });
        assertEquals("Course not found", exception.getStatus().getDescription());
    }
}