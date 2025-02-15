package de.thws.fiw.gymmanagement.infrastructure;

import de.thws.fiw.gymmanagement.domain.Course;
import java.util.List;
import java.util.Optional;

public interface CourseRepositoryInterface {
    Course save(Course course);
    Optional<Course> findById(Long id);
    List<Course> findAll();
    Course update(Long id, String name, int capacity, Long trainerId);
    void deleteById(Long id);

    // Filterabfragen
    List<Course> findByName(String name);
    List<Course> findByTrainerId(Long trainerId);

    void deleteAll();
}
