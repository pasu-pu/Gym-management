package de.thws.fiw.gymmanagement.application.service;

import de.thws.fiw.gymmanagement.domain.Course;
import de.thws.fiw.gymmanagement.domain.Trainer;
import de.thws.fiw.gymmanagement.infrastructure.CourseRepositoryInterface;
import de.thws.fiw.gymmanagement.infrastructure.TrainerRepositoryInterface;

import java.util.List;

public class CourseService implements CourseServiceAdapter {

    CourseRepositoryInterface courseRepository;
    TrainerRepositoryInterface trainerRepository;

    public CourseService(CourseRepositoryInterface courseRepository, TrainerRepositoryInterface trainerRepository){
        this.courseRepository=courseRepository;
        this.trainerRepository=trainerRepository;
    }
    @Override
    public Course createCourse(String name, int capacity, long trainer_Id) {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    @Override
    public Course updateCourse(long id, String name, int capacity, long trainer_Id) {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    @Override
    public Course getCourse(long id) {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    @Override
    public List<Course> getAllCourses(int pageSize, int index) {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    @Override
    public List<Course> getCourseByName(String name, int pageSize, int index) {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    @Override
    public List<Course> getCourseByTrainer(long trainerId, int pageSize, int index) {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    @Override
    public boolean deleteCourse(long id) {
        throw new UnsupportedOperationException("Not implemented yet");
    }
}
