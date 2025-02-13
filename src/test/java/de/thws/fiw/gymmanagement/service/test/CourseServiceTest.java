package de.thws.fiw.gymmanagement.service.test;

import static org.junit.jupiter.api.Assertions.*;

import de.thws.fiw.gymmanagement.application.service.CourseService;
import de.thws.fiw.gymmanagement.domain.Course;
import de.thws.fiw.gymmanagement.domain.Trainer;
import de.thws.fiw.gymmanagement.infrastructure.FakeCourseRepository;
import de.thws.fiw.gymmanagement.infrastructure.FakeTrainerRepository;
import de.thws.fiw.gymmanagement.infrastructure.CourseRepositoryInterface;
import de.thws.fiw.gymmanagement.infrastructure.TrainerRepositoryInterface;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CourseServiceTest{

    private CourseRepositoryInterface courseRepository;
    private TrainerRepositoryInterface trainerRepository;
    private CourseService courseService;

    @BeforeEach
    public void setUp() {
        courseRepository = new FakeCourseRepository();
        trainerRepository = new FakeTrainerRepository();
        courseService = new CourseService(courseRepository, trainerRepository);
    }

    @Test
    public void testCreateCourse() {
        Trainer trainer = new Trainer();
        trainer.setName("Carol");
        trainer.setExpertise("Yoga");
        trainer = trainerRepository.save(trainer);

        Course course = courseService.createCourse("Yoga Class", 20, trainer.getId());
        assertNotNull(course);
        assertNotNull(course.getId());
        assertEquals("Yoga Class", course.getName());
        assertEquals(20, course.getCapacity());
        assertEquals(trainer.getId(), course.getTrainer().getId());
    }

    @Test
    public void testUpdateCourse() {
        Trainer trainer = new Trainer();
        trainer.setName("Carol");
        trainer.setExpertise("Yoga");
        trainer = trainerRepository.save(trainer);

        Course course = courseService.createCourse("Yoga Class", 20, trainer.getId());
        Course updated = courseService.updateCourse(course.getId(), "Advanced Yoga", 25, trainer.getId());
        assertNotNull(updated);
        assertEquals("Advanced Yoga", updated.getName());
        assertEquals(25, updated.getCapacity());
    }

    @Test
    public void testGetCourse() {
        Trainer trainer = new Trainer();
        trainer.setName("Carol");
        trainer.setExpertise("Yoga");
        trainer = trainerRepository.save(trainer);

        Course course = courseService.createCourse("Yoga Class", 20, trainer.getId());
        Course fetched = courseService.getCourse(course.getId());
        assertNotNull(fetched);
        assertEquals("Yoga Class", fetched.getName());
    }

    @Test
    public void testGetAllCourses() {
        Trainer trainer = new Trainer();
        trainer.setName("Carol");
        trainer.setExpertise("Yoga");
        trainer = trainerRepository.save(trainer);

        courseService.createCourse("Yoga Class", 20, trainer.getId());
        courseService.createCourse("Pilates Class", 15, trainer.getId());
        courseService.createCourse("Dance Class", 30, trainer.getId());

        List<Course> page = courseService.getAllCourses(2, 0);
        assertEquals(2, page.size());
        page = courseService.getAllCourses(2, 1);
        assertEquals(1, page.size());
    }

    @Test
    public void testGetCourseByName() {
        Trainer trainer = new Trainer();
        trainer.setName("Carol");
        trainer.setExpertise("Yoga");
        trainer = trainerRepository.save(trainer);

        courseService.createCourse("Yoga Class", 20, trainer.getId());
        courseService.createCourse("Yoga Class", 25, trainer.getId());

        List<Course> result = courseService.getCourseByName("Yoga Class", 10, 0);
        assertEquals(2, result.size());
    }

    @Test
    public void testGetCourseByTrainer() {
        Trainer trainer = new Trainer();
        trainer.setName("Carol");
        trainer.setExpertise("Yoga");
        trainer = trainerRepository.save(trainer);

        courseService.createCourse("Yoga Class", 20, trainer.getId());
        courseService.createCourse("Pilates Class", 15, trainer.getId());

        List<Course> result = courseService.getCourseByTrainer(trainer.getId(), 10, 0);
        assertEquals(2, result.size());
    }

    @Test
    public void testDeleteCourse() {
        Trainer trainer = new Trainer();
        trainer.setName("Carol");
        trainer.setExpertise("Yoga");
        trainer = trainerRepository.save(trainer);

        Course course = courseService.createCourse("Yoga Class", 20, trainer.getId());
        courseService.deleteCourse(course.getId());
        Course fetched = courseService.getCourse(course.getId());
        assertNull(fetched);
    }
}
