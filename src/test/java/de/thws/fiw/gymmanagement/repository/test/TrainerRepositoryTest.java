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
        // Use your actual TrainerRepository which uses Hibernate
        trainerRepository = new TrainerRepository();
    }

    @Test
    public void testSaveAndFindById() {
        Trainer trainer = new Trainer();
        trainer.setName("Bob");
        trainer.setExpertise("Strength");
        Trainer savedTrainer = trainerRepository.save(trainer);
        assertNotNull(savedTrainer);
        assertNotNull(savedTrainer.getId());

        Optional<Trainer> found = trainerRepository.findById(savedTrainer.getId());
        assertTrue(found.isPresent());
        assertEquals("Bob", found.get().getName());
    }

    @Test
    public void testUpdateTrainer() {
        Trainer trainer = new Trainer();
        trainer.setName("Bob");
        trainer.setExpertise("Strength");
        Trainer savedTrainer = trainerRepository.save(trainer);

        Trainer updatedTrainer = trainerRepository.update(savedTrainer.getId(), "Bob Updated", "Cardio");
        assertNotNull(updatedTrainer);
        assertEquals("Bob Updated", updatedTrainer.getName());
        assertEquals("Cardio", updatedTrainer.getExpertise());
    }

    @Test
    public void testFindAll() {
        // Add some trainers
        trainerRepository.save(new Trainer(null, "Alice", "Cardio"));
        trainerRepository.save(new Trainer(null, "Bob", "Strength"));
        trainerRepository.save(new Trainer(null, "Carol", "Yoga"));

        List<Trainer> trainers = trainerRepository.findAll();
        assertTrue(trainers.size() >= 3);
    }

    @Test
    public void testFindByName() {
        Trainer trainer = new Trainer();
        trainer.setName("UniqueName");
        trainer.setExpertise("Strength");
        trainerRepository.save(trainer);

        List<Trainer> found = trainerRepository.findByName("UniqueName");
        assertFalse(found.isEmpty());
        for (Trainer t : found) {
            assertEquals("UniqueName", t.getName());
        }
    }

    @Test
    public void testFindByExpertise() {
        Trainer trainer = new Trainer();
        trainer.setName("TestTrainer");
        trainer.setExpertise("UniqueExpertise");
        trainerRepository.save(trainer);

        List<Trainer> found = trainerRepository.findByExpertise("UniqueExpertise");
        assertFalse(found.isEmpty());
        for (Trainer t : found) {
            assertEquals("UniqueExpertise", t.getExpertise());
        }
    }

    @Test
    public void testDeleteTrainer() {
        Trainer trainer = new Trainer();
        trainer.setName("ToDelete");
        trainer.setExpertise("Test");
        Trainer savedTrainer = trainerRepository.save(trainer);
        trainerRepository.deleteById(savedTrainer.getId());
        Optional<Trainer> found = trainerRepository.findById(savedTrainer.getId());
        assertFalse(found.isPresent());
    }
}
