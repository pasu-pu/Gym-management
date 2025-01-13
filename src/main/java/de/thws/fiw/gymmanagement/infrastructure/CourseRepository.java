package de.thws.fiw.gymmanagement.infrastructure;

import de.thws.fiw.gymmanagement.domain.Course;
import de.thws.fiw.gymmanagement.domain.Trainer;

import java.util.*;
import java.util.concurrent.atomic.AtomicLong;

public class CourseRepository implements CourseRepositoryInterface {
    private final Map<Long, Course> courses = new HashMap<>();
    private final AtomicLong idCounter = new AtomicLong(1);

    // Hinzufügen von trainerRepository
    private final TrainerRepositoryInterface trainerRepository;

    // Konstruktor
    public CourseRepository(TrainerRepositoryInterface trainerRepository) {
        this.trainerRepository = trainerRepository;
    }

    @Override
    public Course save(Course course) {
        if (course.getId() == null) {
            course.setId(idCounter.getAndIncrement());
        }
        courses.put(course.getId(), course);

        // Trainer aktualisieren
        Trainer trainer = trainerRepository.findById(course.getTrainerId())
                .orElseThrow(() -> new RuntimeException("Trainer not found"));

        // Überprüfen, ob der Kurs bereits existiert
        boolean courseExists = trainer.getCourses().stream()
                .anyMatch(existingCourse -> existingCourse.getId().equals(course.getId()));
        if (!courseExists) {
            trainer.getCourses().add(course);
        }

        return course;
    }


    @Override
    public Optional<Course> findById(Long id) {
        return Optional.ofNullable(courses.get(id));
    }

    @Override
    public List<Course> findAll() {
        return new ArrayList<>(courses.values());
    }

    @Override
    public void deleteById(Long id) {
        courses.remove(id);
    }
    @Override
    public Course update(Long id, String name, int capacity, Long trainerId) {
        Course course = courses.get(id);
        if (course != null) {
            course.setName(name);
            course.setCapacity(capacity);
            course.setTrainerId(trainerId);
            courses.put(id, course); // Aktualisieren der Map
        }
        return course;
    }

}
