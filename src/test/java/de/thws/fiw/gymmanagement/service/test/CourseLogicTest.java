package de.thws.fiw.gymmanagement.service.test;

import static org.junit.jupiter.api.Assertions.*;

import de.thws.fiw.gymmanagement.domain.CourseLogic;
import de.thws.fiw.gymmanagement.domain.Course;
import de.thws.fiw.gymmanagement.domain.Trainer;
import de.thws.fiw.gymmanagement.infrastructure.CourseRepositoryInterface;
import de.thws.fiw.gymmanagement.infrastructure.TrainerRepositoryInterface;
import de.thws.fiw.gymmanagement.infrastructure.fakes.FakeCourseRepository;
import de.thws.fiw.gymmanagement.infrastructure.fakes.FakeTrainerRepository;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CourseLogicTest {

    private CourseRepositoryInterface courseRepository;
    private TrainerRepositoryInterface trainerRepository;
    private CourseLogic courseLogic;

    @BeforeEach
    public void setUp() {
        courseRepository = new FakeCourseRepository();
        trainerRepository = new FakeTrainerRepository();
        courseLogic = new CourseLogic(courseRepository, trainerRepository);
    }

    @Test
    public void testCreateCourse() {
        Trainer trainer = new Trainer.Builder()
                .withName("Carol")
                .withExpertise("Yoga")
                .build();
        trainer = trainerRepository.save(trainer);

        Course course = courseLogic.createCourse("Yoga Class", 20, trainer.getId());
        assertNotNull(course);
        assertNotNull(course.getId());
        assertEquals("Yoga Class", course.getName());
        assertEquals(20, course.getCapacity());
        assertEquals(trainer.getId(), course.getTrainer().getId());
    }

    @Test
    public void testUpdateCourse() {
        Trainer trainer = new Trainer.Builder()
                .withName("Carol")
                .withExpertise("Yoga")
                .build();
        trainer = trainerRepository.save(trainer);

        Course course = courseLogic.createCourse("Yoga Class", 20, trainer.getId());
        Course updated = courseLogic.updateCourse(course.getId(), "Advanced Yoga", 25, trainer.getId());
        assertNotNull(updated);
        assertEquals("Advanced Yoga", updated.getName());
        assertEquals(25, updated.getCapacity());
    }

    @Test
    public void testGetCourse() {
        Trainer trainer = new Trainer.Builder()
                .withName("Carol")
                .withExpertise("Yoga")
                .build();
        trainer = trainerRepository.save(trainer);

        Course course = courseLogic.createCourse("Yoga Class", 20, trainer.getId());
        Course fetched = courseLogic.getCourse(course.getId());
        assertNotNull(fetched);
        assertEquals("Yoga Class", fetched.getName());
    }

    @Test
    public void testGetAllCourses() {
        Trainer trainer = new Trainer.Builder()
                .withName("Carol")
                .withExpertise("Yoga")
                .build();
        trainer = trainerRepository.save(trainer);

        courseLogic.createCourse("Yoga Class", 20, trainer.getId());
        courseLogic.createCourse("Pilates Class", 15, trainer.getId());
        courseLogic.createCourse("Dance Class", 30, trainer.getId());

        List<Course> page = courseLogic.getAllCourses(2, 0);
        assertEquals(2, page.size());
        page = courseLogic.getAllCourses(2, 1);
        assertEquals(1, page.size());
    }

    @Test
    public void testGetCourseByName() {
        Trainer trainer = new Trainer.Builder()
                .withName("Carol")
                .withExpertise("Yoga")
                .build();
        trainer = trainerRepository.save(trainer);

        courseLogic.createCourse("Yoga Class", 20, trainer.getId());
        courseLogic.createCourse("Yoga Class", 25, trainer.getId());

        List<Course> result = courseLogic.getCourseByName("Yoga Class", 10, 0);
        assertEquals(2, result.size());
    }

    @Test
    public void testGetCourseByTrainer() {
        Trainer trainer = new Trainer.Builder()
                .withName("Carol")
                .withExpertise("Yoga")
                .build();
        trainer = trainerRepository.save(trainer);

        courseLogic.createCourse("Yoga Class", 20, trainer.getId());
        courseLogic.createCourse("Pilates Class", 15, trainer.getId());

        List<Course> result = courseLogic.getCourseByTrainer(trainer.getId(), 10, 0);
        assertEquals(2, result.size());
    }

    @Test
    public void testDeleteCourse() {
        Trainer trainer = new Trainer.Builder()
                .withName("Carol")
                .withExpertise("Yoga")
                .build();
        trainer = trainerRepository.save(trainer);

        Course course = courseLogic.createCourse("Yoga Class", 20, trainer.getId());
        courseLogic.deleteCourse(course.getId());
        Course fetched = courseLogic.getCourse(course.getId());
        assertNull(fetched);
    }
}
