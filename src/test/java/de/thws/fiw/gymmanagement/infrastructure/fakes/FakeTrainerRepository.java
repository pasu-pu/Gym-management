package de.thws.fiw.gymmanagement.infrastructure.fakes;

import de.thws.fiw.gymmanagement.domain.Trainer;
import de.thws.fiw.gymmanagement.infrastructure.TrainerRepositoryInterface;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;

public class FakeTrainerRepository implements TrainerRepositoryInterface {
    private final List<Trainer> trainers = new ArrayList<>();
    private final AtomicLong idGenerator = new AtomicLong(1);

    @Override
    public Trainer save(Trainer trainer) {
        if (trainer.getId() == null || trainer.getId() == 0) {
            long newId = idGenerator.getAndIncrement();
            // Erstelle ein neues Trainer-Objekt über den Builder
            Trainer newTrainer = new Trainer.Builder()
                    .withId(newId)
                    .withName(trainer.getName())
                    .withExpertise(trainer.getExpertise())
                    .build();
            trainers.add(newTrainer);
            return newTrainer;
        } else {
            trainers.add(trainer);
            return trainer;
        }
    }

    @Override
    public Optional<Trainer> findById(Long id) {
        return trainers.stream()
                .filter(t -> t.getId().equals(id))
                .findFirst();
    }

    @Override
    public List<Trainer> findAll() {
        return new ArrayList<>(trainers);
    }

    @Override
    public Trainer update(Long id, String name, String expertise) {
        Optional<Trainer> opt = findById(id);
        if (opt.isPresent()) {
            // Erzeuge ein neues Trainer-Objekt mit den aktualisierten Werten über den Builder
            Trainer updatedTrainer = new Trainer.Builder()
                    .withId(id)
                    .withName(name)
                    .withExpertise(expertise)
                    .build();
            trainers.removeIf(t -> t.getId().equals(id));
            trainers.add(updatedTrainer);
            return updatedTrainer;
        }
        return null;
    }

    @Override
    public void deleteById(Long id) {
        trainers.removeIf(t -> t.getId().equals(id));
    }

    @Override
    public List<Trainer> findByName(String name) {
        List<Trainer> result = new ArrayList<>();
        for (Trainer t : trainers) {
            if (t.getName().equalsIgnoreCase(name)) {
                result.add(t);
            }
        }
        return result;
    }

    @Override
    public List<Trainer> findByExpertise(String expertise) {
        List<Trainer> result = new ArrayList<>();
        for (Trainer t : trainers) {
            if (t.getExpertise().equalsIgnoreCase(expertise)) {
                result.add(t);
            }
        }
        return result;
    }
}
