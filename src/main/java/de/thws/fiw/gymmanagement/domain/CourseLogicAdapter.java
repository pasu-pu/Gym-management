package de.thws.fiw.gymmanagement.domain;

import de.thws.fiw.gymmanagement.domain.Course;

import java.util.List;

public interface CourseLogicAdapter {
    Course createCourse(String name, int capacity, long trainer_Id);
    Course updateCourse(long id, String name, int capacity, long trainer_Id);
    Course getCourse(long id);
    List<Course> getAllCourses(int pageSize, int index);
    List<Course> getCourseByName(String name, int pageSize, int index);
    List<Course> getCourseByTrainer(long trainerId, int pageSize, int index);
    void deleteCourse(long id);
}
