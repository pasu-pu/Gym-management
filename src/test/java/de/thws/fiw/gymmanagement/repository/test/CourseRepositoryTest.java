package de.thws.fiw.gymmanagement.repository.test;

import de.thws.fiw.gymmanagement.domain.Course;
import de.thws.fiw.gymmanagement.domain.Trainer;
import de.thws.fiw.gymmanagement.infrastructure.CourseRepository;
import de.thws.fiw.gymmanagement.infrastructure.CourseRepositoryInterface;
import de.thws.fiw.gymmanagement.infrastructure.TrainerRepository;
import de.thws.fiw.gymmanagement.infrastructure.TrainerRepositoryInterface;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import java.util.Optional;

public class CourseRepositoryTest {

    private CourseRepositoryInterface courseRepository;
    private TrainerRepositoryInterface trainerRepository;

    @BeforeEach
    public void setUp() {
        courseRepository = new CourseRepository();
        trainerRepository = new TrainerRepository();
    }

    @Test
    public void testSaveAndFindById() {
        // Create a Trainer using the builder so that the ID is generated automatically
        Trainer trainer = new Trainer.Builder()
                .withName("Trainer1")
                .withExpertise("Expertise")
                .build();
        trainer = trainerRepository.save(trainer);

        // Create a Course using the builder
        Course course = new Course.Builder()
                .withName("Course1")
                .withCapacity(30)
                .withTrainer(trainer)
                .build();
        Course savedCourse = courseRepository.save(course);
        assertNotNull(savedCourse);
        assertNotNull(savedCourse.getId());

        Optional<Course> found = courseRepository.findById(savedCourse.getId());
        assertTrue(found.isPresent());
        assertEquals("Course1", found.get().getName());
    }

    @Test
    public void testUpdateCourse() {
        Trainer trainer = new Trainer.Builder()
                .withName("Trainer1")
                .withExpertise("Expertise")
                .build();
        trainer = trainerRepository.save(trainer);

        Course course = new Course.Builder()
                .withName("Course1")
                .withCapacity(30)
                .withTrainer(trainer)
                .build();
        Course savedCourse = courseRepository.save(course);

        Course updatedCourse = courseRepository.update(savedCourse.getId(), "Course Updated", 40, trainer.getId());
        assertNotNull(updatedCourse);
        assertEquals("Course Updated", updatedCourse.getName());
        assertEquals(40, updatedCourse.getCapacity());
    }

    @Test
    public void testFindAll() {
        Trainer trainer = new Trainer.Builder()
                .withName("Trainer1")
                .withExpertise("Expertise")
                .build();
        trainer = trainerRepository.save(trainer);

        // Create three courses using the builder; note that passing null for id allows repository to generate one.
        courseRepository.save(new Course.Builder().withName("Course1").withCapacity(30).withTrainer(trainer).build());
        courseRepository.save(new Course.Builder().withName("Course2").withCapacity(25).withTrainer(trainer).build());
        courseRepository.save(new Course.Builder().withName("Course3").withCapacity(20).withTrainer(trainer).build());

        List<Course> courses = courseRepository.findAll();
        assertTrue(courses.size() >= 3);
    }

    @Test
    public void testFindByName() {
        Trainer trainer = new Trainer.Builder()
                .withName("Trainer1")
                .withExpertise("Expertise")
                .build();
        trainer = trainerRepository.save(trainer);

        Course course = new Course.Builder()
                .withName("UniqueCourse")
                .withCapacity(30)
                .withTrainer(trainer)
                .build();
        courseRepository.save(course);

        List<Course> found = courseRepository.findByName("UniqueCourse");
        assertFalse(found.isEmpty());
        for (Course c : found) {
            assertEquals("UniqueCourse", c.getName());
        }
    }

    @Test
    public void testFindByTrainerId() {
        Trainer trainer = new Trainer.Builder()
                .withName("TrainerForCourse")
                .withExpertise("Expertise")
                .build();
        trainer = trainerRepository.save(trainer);

        Course course1 = new Course.Builder()
                .withName("Course1")
                .withCapacity(30)
                .withTrainer(trainer)
                .build();
        courseRepository.save(course1);

        Course course2 = new Course.Builder()
                .withName("Course2")
                .withCapacity(25)
                .withTrainer(trainer)
                .build();
        courseRepository.save(course2);

        List<Course> found = courseRepository.findByTrainerId(trainer.getId());
        assertEquals(2, found.size());
    }

    @Test
    public void testDeleteCourse() {
        Trainer trainer = new Trainer.Builder()
                .withName("Trainer1")
                .withExpertise("Expertise")
                .build();
        trainer = trainerRepository.save(trainer);

        Course course = new Course.Builder()
                .withName("CourseToDelete")
                .withCapacity(30)
                .withTrainer(trainer)
                .build();
        Course savedCourse = courseRepository.save(course);

        courseRepository.deleteById(savedCourse.getId());
        Optional<Course> found = courseRepository.findById(savedCourse.getId());
        assertFalse(found.isPresent());
    }
}
