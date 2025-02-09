package de.thws.fiw.gymmanagement.application.service;

import de.thws.fiw.gymmanagement.domain.Course;
import de.thws.fiw.gymmanagement.domain.Trainer;
import de.thws.fiw.gymmanagement.infrastructure.CourseRepositoryInterface;
import de.thws.fiw.gymmanagement.infrastructure.TrainerRepositoryInterface;

import java.util.List;
import java.util.Optional;

public class CourseService {
    private final CourseRepositoryInterface courseRepository;
    private final TrainerRepositoryInterface trainerRepository;

    public CourseService(CourseRepositoryInterface courseRepository, TrainerRepositoryInterface trainerRepository) {
        this.courseRepository = courseRepository;
        this.trainerRepository = trainerRepository;
    }

    public Course createCourse(String name, int capacity, Long trainerId) {
        Trainer trainer = trainerRepository.findById(trainerId)
                .orElseThrow(() -> new RuntimeException("Trainer not found"));

        Course course = new Course();
        course.setName(name);
        course.setCapacity(capacity);
        course.setTrainer(trainer);

        return courseRepository.save(course);
    }

    public Optional<Course> getCourse(Long courseId) {
        return courseRepository.findById(courseId);
    }

    public List<Course> getAllCourses() {
        return courseRepository.findAll();
    }

    public boolean deleteCourse(Long courseId) {
        return courseRepository.findById(courseId)
                .map(course -> {
                    courseRepository.deleteById(course.getId());
                    return true;
                })
                .orElse(false);
    }

    public boolean updateCourse(Long courseId, String name, int capacity, Long trainerId) {
        Optional<Course> optionalCourse = courseRepository.findById(courseId);

        if (optionalCourse.isPresent()) {
            Course course = optionalCourse.get();
            course.setName(name);
            course.setCapacity(capacity);

            // Trainer prüfen und setzen
            Trainer trainer = trainerRepository.findById(trainerId)
                    .orElseThrow(() -> new RuntimeException("Trainer not found"));
            course.setTrainer(trainer);

            courseRepository.save(course);
            return true;
        }
        return false;
    }



}
