package de.thws.fiw.gymmanagement.repository.test;

import de.thws.fiw.gymmanagement.domain.Trainer;
import de.thws.fiw.gymmanagement.infrastructure.TrainerRepository;
import de.thws.fiw.gymmanagement.infrastructure.TrainerRepositoryInterface;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import java.util.Optional;

public class TrainerRepositoryTest {

    private TrainerRepositoryInterface trainerRepository;

    @BeforeEach
    public void setUp() {
        // Use your actual TrainerRepository (or fake repository) here
        trainerRepository = new TrainerRepository();
    }

    @Test
    public void testSaveAndFindById() {
        Trainer trainer = new Trainer.Builder()
                .withName("Bob")
                .withExpertise("Strength")
                .build();
        Trainer savedTrainer = trainerRepository.save(trainer);
        assertNotNull(savedTrainer);
        assertNotNull(savedTrainer.getId());

        Optional<Trainer> found = trainerRepository.findById(savedTrainer.getId());
        assertTrue(found.isPresent());
        assertEquals("Bob", found.get().getName());
    }

    @Test
    public void testUpdateTrainer() {
        Trainer trainer = new Trainer.Builder()
                .withName("Bob")
                .withExpertise("Strength")
                .build();
        Trainer savedTrainer = trainerRepository.save(trainer);

        Trainer updatedTrainer = trainerRepository.update(savedTrainer.getId(), "Bob Updated", "Cardio");
        assertNotNull(updatedTrainer);
        assertEquals("Bob Updated", updatedTrainer.getName());
        assertEquals("Cardio", updatedTrainer.getExpertise());
    }

    @Test
    public void testFindAll() {
        // Add some trainers using the builder
        trainerRepository.save(new Trainer.Builder().withName("Alice").withExpertise("Cardio").build());
        trainerRepository.save(new Trainer.Builder().withName("Bob").withExpertise("Strength").build());
        trainerRepository.save(new Trainer.Builder().withName("Carol").withExpertise("Yoga").build());

        List<Trainer> trainers = trainerRepository.findAll();
        assertTrue(trainers.size() >= 3);
    }

    @Test
    public void testFindByName() {
        Trainer trainer = new Trainer.Builder()
                .withName("UniqueName")
                .withExpertise("Strength")
                .build();
        trainerRepository.save(trainer);

        List<Trainer> found = trainerRepository.findByName("UniqueName");
        assertFalse(found.isEmpty());
        for (Trainer t : found) {
            assertEquals("UniqueName", t.getName());
        }
    }

    @Test
    public void testFindByExpertise() {
        Trainer trainer = new Trainer.Builder()
                .withName("TestTrainer")
                .withExpertise("UniqueExpertise")
                .build();
        trainerRepository.save(trainer);

        List<Trainer> found = trainerRepository.findByExpertise("UniqueExpertise");
        assertFalse(found.isEmpty());
        for (Trainer t : found) {
            assertEquals("UniqueExpertise", t.getExpertise());
        }
    }

    @Test
    public void testDeleteTrainer() {
        Trainer trainer = new Trainer.Builder()
                .withName("ToDelete")
                .withExpertise("Test")
                .build();
        Trainer savedTrainer = trainerRepository.save(trainer);
        trainerRepository.deleteById(savedTrainer.getId());
        Optional<Trainer> found = trainerRepository.findById(savedTrainer.getId());
        assertFalse(found.isPresent());
    }
}
