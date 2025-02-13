package de.thws.fiw.gymmanagement.domain;

import de.thws.fiw.gymmanagement.infrastructure.CourseRepositoryInterface;
import de.thws.fiw.gymmanagement.infrastructure.TrainerRepositoryInterface;
import java.util.ArrayList;
import java.util.List;

public class CourseLogic implements CourseLogicAdapter {

    private final CourseRepositoryInterface courseRepository;
    private final TrainerRepositoryInterface trainerRepository;

    public CourseLogic(CourseRepositoryInterface courseRepository, TrainerRepositoryInterface trainerRepository) {
        this.courseRepository = courseRepository;
        this.trainerRepository = trainerRepository;
    }

    @Override
    public Course createCourse(String name, int capacity, long trainer_Id) {
        System.out.println("[CourseLogic] createCourse called with name: " + name
                + ", capacity: " + capacity + ", trainerId: " + trainer_Id);
        try {
            System.out.println("[CourseLogic] Fetching Trainer with id: " + trainer_Id);
            Trainer trainer = trainerRepository.findById(trainer_Id)
                    .orElseThrow(() -> new RuntimeException("Trainer not found"));
            System.out.println("[CourseLogic] Creating new Course using Builder");
            Course course = new Course.Builder()
                    .withName(name)
                    .withCapacity(capacity)
                    .withTrainer(trainer)
                    .build();
            Course savedCourse = courseRepository.save(course);
            System.out.println("[CourseLogic] createCourse succeeded: created course with id " + savedCourse.getId());
            return savedCourse;
        } catch (Exception e) {
            System.err.println("[CourseLogic] Error in createCourse: " + e.getMessage());
            throw new RuntimeException(e);
        }
    }

    @Override
    public Course updateCourse(long id, String name, int capacity, long trainer_Id) {
        System.out.println("[CourseLogic] updateCourse called for courseId: " + id
                + " with new name: " + name + ", capacity: " + capacity + ", trainerId: " + trainer_Id);
        try {
            System.out.println("[CourseLogic] Fetching Trainer with id: " + trainer_Id);
            Trainer trainer = trainerRepository.findById(trainer_Id)
                    .orElseThrow(() -> new RuntimeException("Trainer not found"));
            System.out.println("[CourseLogic] Invoking repository update for courseId: " + id);
            Course updatedCourse = courseRepository.update(id, name, capacity, trainer_Id);
            System.out.println("[CourseLogic] updateCourse succeeded for courseId: " + updatedCourse.getId());
            return updatedCourse;
        } catch (Exception e) {
            System.err.println("[CourseLogic] Error in updateCourse: " + e.getMessage());
            throw new RuntimeException(e);
        }
    }

    @Override
    public Course getCourse(long id) {
        System.out.println("[CourseLogic] getCourse called for courseId: " + id);
        try {
            Course course = courseRepository.findById(id).orElse(null);
            if (course == null) {
                System.err.println("[CourseLogic] getCourse: Course with id " + id + " not found");
            } else {
                System.out.println("[CourseLogic] getCourse succeeded for courseId: " + course.getId());
            }
            return course;
        } catch (Exception e) {
            System.err.println("[CourseLogic] Error in getCourse: " + e.getMessage());
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Course> getAllCourses(int pageSize, int index) {
        System.out.println("[CourseLogic] getAllCourses called with pagesize: " + pageSize
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
            System.out.println("[CourseLogic] getAllCourses succeeded: returned " + result.size() + " courses");
            return result;
        } catch (Exception e) {
            System.err.println("[CourseLogic] Error in getAllCourses: " + e.getMessage());
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Course> getCourseByName(String name, int pageSize, int index) {
        System.out.println("[CourseLogic] getCourseByName called with name: " + name
                + ", pagesize: " + pageSize + ", index: " + index);
        try {
            List<Course> filtered = courseRepository.findByName(name);
            int start = index * pageSize;
            int end = Math.min(start + pageSize, filtered.size());
            List<Course> result;
            if (start >= filtered.size()) {
                result = new ArrayList<>();
            } else {
                result = filtered.subList(start, end);
            }
            System.out.println("[CourseLogic] getCourseByName succeeded: returned " + result.size() + " courses");
            return result;
        } catch (Exception e) {
            System.err.println("[CourseLogic] Error in getCourseByName: " + e.getMessage());
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Course> getCourseByTrainer(long trainerId, int pageSize, int index) {
        System.out.println("[CourseLogic] getCourseByTrainer called for trainerId: " + trainerId
                + ", pagesize: " + pageSize + ", index: " + index);
        try {
            List<Course> filtered = courseRepository.findByTrainerId(trainerId);
            int start = index * pageSize;
            int end = Math.min(start + pageSize, filtered.size());
            List<Course> result;
            if (start >= filtered.size()) {
                result = new ArrayList<>();
            } else {
                result = filtered.subList(start, end);
            }
            System.out.println("[CourseLogic] getCourseByTrainer succeeded: returned " + result.size() + " courses");
            return result;
        } catch (Exception e) {
            System.err.println("[CourseLogic] Error in getCourseByTrainer: " + e.getMessage());
            throw new RuntimeException(e);
        }
    }

    @Override
    public void deleteCourse(long id) {
        System.out.println("[CourseLogic] deleteCourse called for courseId: " + id);
        try {
            courseRepository.deleteById(id);
            System.out.println("[CourseLogic] deleteCourse succeeded for courseId: " + id);
        } catch (Exception e) {
            System.err.println("[CourseLogic] Error in deleteCourse: " + e.getMessage());
            throw new RuntimeException(e);
        }
    }
}
