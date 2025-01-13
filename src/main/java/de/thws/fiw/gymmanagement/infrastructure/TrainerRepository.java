package de.thws.fiw.gymmanagement.infrastructure;

import de.thws.fiw.gymmanagement.domain.Course;
import de.thws.fiw.gymmanagement.domain.Trainer;

import java.util.*;
import java.util.concurrent.atomic.AtomicLong;

public class TrainerRepository implements TrainerRepositoryInterface {
    private final Map<Long, Trainer> trainers = new HashMap<>();
    private final AtomicLong idCounter = new AtomicLong(1);

    @Override
    public Trainer save(Trainer trainer) {
        if (trainer.getId() == null) {
            trainer.setId(idCounter.getAndIncrement());
        }
        trainers.put(trainer.getId(), trainer);
        return trainer;
    }

    @Override
    public Optional<Trainer> findById(Long id) {
        return Optional.ofNullable(trainers.get(id));
    }

    @Override
    public List<Trainer> findAll() {
        return new ArrayList<>(trainers.values());
    }

    @Override
    public void deleteById(Long id) {
        trainers.remove(id);
    }

    @Override
    public Trainer update(Long id, String name, String expertise) {
        Trainer trainer = trainers.get(id);
        if (trainer != null) {
            trainer.setName(name);
            trainer.setExpertise(expertise);
            trainers.put(id, trainer); // Aktualisieren der Map
        }
        return trainer;
    }
    @Override
    public List<Course> findCoursesByTrainerId(Long trainerId) {
        return trainers.get(trainerId).getCourses();
    }

}
