package de.thws.fiw.gymmanagement.infrastructure;

import de.thws.fiw.gymmanagement.domain.Booking;
import de.thws.fiw.gymmanagement.domain.Course;
import de.thws.fiw.gymmanagement.domain.Trainer;

import java.util.List;
import java.util.Optional;

public interface TrainerRepositoryInterface {
    Trainer save(Trainer trainer);
    Optional<Trainer> findById(Long id);
    List<Trainer> findAll();
    void deleteById(Long id);
    Trainer update(Long id, String name, String expertise);
    List<Course> findCoursesByTrainerId(Long trainerId); // Neu
}
