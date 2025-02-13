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
        Trainer trainer = new Trainer();
        trainer.setName("Trainer1");
        trainer.setExpertise("Expertise");
        trainer = trainerRepository.save(trainer);

        Course course = new Course();
        course.setName("Course1");
        course.setCapacity(30);
        course.setTrainer(trainer);
        Course savedCourse = courseRepository.save(course);
        assertNotNull(savedCourse);
        assertNotNull(savedCourse.getId());

        Optional<Course> found = courseRepository.findById(savedCourse.getId());
        assertTrue(found.isPresent());
        assertEquals("Course1", found.get().getName());
    }

    @Test
    public void testUpdateCourse() {
        Trainer trainer = new Trainer();
        trainer.setName("Trainer1");
        trainer.setExpertise("Expertise");
        trainer = trainerRepository.save(trainer);

        Course course = new Course();
        course.setName("Course1");
        course.setCapacity(30);
        course.setTrainer(trainer);
        Course savedCourse = courseRepository.save(course);

        Course updatedCourse = courseRepository.update(savedCourse.getId(), "Course Updated", 40, trainer.getId());
        assertNotNull(updatedCourse);
        assertEquals("Course Updated", updatedCourse.getName());
        assertEquals(40, updatedCourse.getCapacity());
    }

    @Test
    public void testFindAll() {
        Trainer trainer = new Trainer();
        trainer.setName("Trainer1");
        trainer.setExpertise("Expertise");
        trainer = trainerRepository.save(trainer);

        courseRepository.save(new Course(null, "Course1", 30, trainer));
        courseRepository.save(new Course(null, "Course2", 25, trainer));
        courseRepository.save(new Course(null, "Course3", 20, trainer));

        List<Course> courses = courseRepository.findAll();
        assertTrue(courses.size() >= 3);
    }

    @Test
    public void testFindByName() {
        Trainer trainer = new Trainer();
        trainer.setName("Trainer1");
        trainer.setExpertise("Expertise");
        trainer = trainerRepository.save(trainer);

        Course course = new Course();
        course.setName("UniqueCourse");
        course.setCapacity(30);
        course.setTrainer(trainer);
        courseRepository.save(course);

        List<Course> found = courseRepository.findByName("UniqueCourse");
        assertFalse(found.isEmpty());
        for (Course c : found) {
            assertEquals("UniqueCourse", c.getName());
        }
    }

    @Test
    public void testFindByTrainerId() {
        Trainer trainer = new Trainer();
        trainer.setName("TrainerForCourse");
        trainer.setExpertise("Expertise");
        trainer = trainerRepository.save(trainer);

        Course course1 = new Course();
        course1.setName("Course1");
        course1.setCapacity(30);
        course1.setTrainer(trainer);
        courseRepository.save(course1);

        Course course2 = new Course();
        course2.setName("Course2");
        course2.setCapacity(25);
        course2.setTrainer(trainer);
        courseRepository.save(course2);

        List<Course> found = courseRepository.findByTrainerId(trainer.getId());
        assertEquals(2, found.size());
    }

    @Test
    public void testDeleteCourse() {
        Trainer trainer = new Trainer();
        trainer.setName("Trainer1");
        trainer.setExpertise("Expertise");
        trainer = trainerRepository.save(trainer);

        Course course = new Course();
        course.setName("CourseToDelete");
        course.setCapacity(30);
        course.setTrainer(trainer);
        Course savedCourse = courseRepository.save(course);

        courseRepository.deleteById(savedCourse.getId());
        Optional<Course> found = courseRepository.findById(savedCourse.getId());
        assertFalse(found.isPresent());
    }
}
