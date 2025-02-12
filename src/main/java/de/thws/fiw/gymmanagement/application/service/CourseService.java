package de.thws.fiw.gymmanagement.application.service;

import de.thws.fiw.gymmanagement.domain.Course;
import de.thws.fiw.gymmanagement.domain.Trainer;
import de.thws.fiw.gymmanagement.infrastructure.CourseRepositoryInterface;
import de.thws.fiw.gymmanagement.infrastructure.TrainerRepositoryInterface;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class CourseService implements CourseServiceAdapter {

    private final CourseRepositoryInterface courseRepository;
    private final TrainerRepositoryInterface trainerRepository;

    public CourseService(CourseRepositoryInterface courseRepository, TrainerRepositoryInterface trainerRepository) {
        this.courseRepository = courseRepository;
        this.trainerRepository = trainerRepository;
    }

    @Override
    public Course createCourse(String name, int capacity, long trainer_Id) {
        System.out.println("[CourseService] createCourse called with name: " + name
                + ", capacity: " + capacity + ", trainerId: " + trainer_Id);
        try {
            System.out.println("[CourseService] Fetching Trainer with id: " + trainer_Id);
            Trainer trainer = trainerRepository.findById(trainer_Id)
                    .orElseThrow(() -> new RuntimeException("Trainer not found"));
            System.out.println("[CourseService] Creating new Course");
            Course course = new Course();
            course.setName(name);
            course.setCapacity(capacity);
            course.setTrainer(trainer);
            Course savedCourse = courseRepository.save(course);
            System.out.println("[CourseService] createCourse succeeded: created course with id " + savedCourse.getId());
            return savedCourse;
        } catch (Exception e) {
            System.err.println("[CourseService] Error in createCourse: " + e.getMessage());
            throw new RuntimeException(e);
        }
    }

    @Override
    public Course updateCourse(long id, String name, int capacity, long trainer_Id) {
        System.out.println("[CourseService] updateCourse called for courseId: " + id
                + " with new name: " + name + ", capacity: " + capacity + ", trainerId: " + trainer_Id);
        try {
            System.out.println("[CourseService] Fetching Trainer with id: " + trainer_Id);
            Trainer trainer = trainerRepository.findById(trainer_Id)
                    .orElseThrow(() -> new RuntimeException("Trainer not found"));
            System.out.println("[CourseService] Invoking repository update for courseId: " + id);
            Course updatedCourse = courseRepository.update(id, name, capacity, trainer_Id);
            System.out.println("[CourseService] updateCourse succeeded for courseId: " + updatedCourse.getId());
            return updatedCourse;
        } catch (Exception e) {
            System.err.println("[CourseService] Error in updateCourse: " + e.getMessage());
            throw new RuntimeException(e);
        }
    }

    @Override
    public Course getCourse(long id) {
        System.out.println("[CourseService] getCourse called for courseId: " + id);
        try {
            Course course = courseRepository.findById(id).orElse(null);
            if (course == null) {
                System.err.println("[CourseService] getCourse: Course with id " + id + " not found");
                throw new RuntimeException("Course not found");
            } else {
                System.out.println("[CourseService] getCourse succeeded for courseId: " + course.getId());
            }
            return course;
        } catch (Exception e) {
            System.err.println("[CourseService] Error in getCourse: " + e.getMessage());
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Course> getAllCourses(int pageSize, int index) {
        System.out.println("[CourseService] getAllCourses called with pagesize: " + pageSize
                + ", index: " + index);
        try {
            List<Course> allCourses = courseRepository.findAll();
            int start = index * pageSize;
            int end = Math.min(start + pageSize, allCourses.size());
            List<Course> result;
            if (start >= allCourses.size()) {
                result = new ArrayList<>();
            } else {
                result = allCourses.subList(start, end);
            }
            System.out.println("[CourseService] getAllCourses succeeded: returned " + result.size() + " courses");
            return result;
        } catch (Exception e) {
            System.err.println("[CourseService] Error in getAllCourses: " + e.getMessage());
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Course> getCourseByName(String name, int pageSize, int index) {
        System.out.println("[CourseService] getCourseByName called with name: " + name
                + ", pagesize: " + pageSize + ", index: " + index);
        try {
            // Annahme: Repository bietet eine direkte Methode zum Filtern
            List<Course> filtered = courseRepository.findByName(name);
            int start = index * pageSize;
            int end = Math.min(start + pageSize, filtered.size());
            List<Course> result;
            if (start >= filtered.size()) {
                result = new ArrayList<>();
            } else {
                result = filtered.subList(start, end);
            }
            System.out.println("[CourseService] getCourseByName succeeded: returned " + result.size() + " courses");
            return result;
        } catch (Exception e) {
            System.err.println("[CourseService] Error in getCourseByName: " + e.getMessage());
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Course> getCourseByTrainer(long trainerId, int pageSize, int index) {
        System.out.println("[CourseService] getCourseByTrainer called for trainerId: " + trainerId
                + ", pagesize: " + pageSize + ", index: " + index);
        try {
            // Annahme: Repository bietet eine Methode findByTrainerId
            List<Course> filtered = courseRepository.findByTrainerId(trainerId);
            int start = index * pageSize;
            int end = Math.min(start + pageSize, filtered.size());
            List<Course> result;
            if (start >= filtered.size()) {
                result = new ArrayList<>();
            } else {
                result = filtered.subList(start, end);
            }
            System.out.println("[CourseService] getCourseByTrainer succeeded: returned " + result.size() + " courses");
            return result;
        } catch (Exception e) {
            System.err.println("[CourseService] Error in getCourseByTrainer: " + e.getMessage());
            throw new RuntimeException(e);
        }
    }

    @Override
    public void deleteCourse(long id) {
        System.out.println("[CourseService] deleteCourse called for courseId: " + id);
        try {
            courseRepository.deleteById(id);
            System.out.println("[CourseService] deleteCourse succeeded for courseId: " + id);
        } catch (Exception e) {
            System.err.println("[CourseService] Error in deleteCourse: " + e.getMessage());
            throw new RuntimeException(e);
        }
    }
}
