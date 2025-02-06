package de.thws.fiw.gymmanagement.infrastructure;

import de.thws.fiw.gymmanagement.domain.Booking;
import de.thws.fiw.gymmanagement.domain.Course;
import de.thws.fiw.gymmanagement.domain.Trainer;

import java.util.List;
import java.util.Optional;

public interface CourseRepositoryInterface {
    Course save(Course course);
    Optional<Course> findById(Long id);
    Optional<Course> findByName(String name);
    List<Course> findAll();
    void deleteById(Long id);
    Course update(Long id, String name, int capacity, Long trainerId);
}
