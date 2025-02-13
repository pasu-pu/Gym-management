package de.thws.fiw.gymmanagement.service.test;

import static org.junit.jupiter.api.Assertions.*;

import de.thws.fiw.gymmanagement.application.service.TrainerService;
import de.thws.fiw.gymmanagement.domain.Trainer;
import de.thws.fiw.gymmanagement.infrastructure.FakeTrainerRepository;
import de.thws.fiw.gymmanagement.infrastructure.TrainerRepositoryInterface;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TrainerServiceTest {

    private TrainerRepositoryInterface trainerRepository;
    private TrainerService trainerService;

    @BeforeEach
    public void setUp() {
        trainerRepository = new FakeTrainerRepository();
        trainerService = new TrainerService(trainerRepository);
    }

    @Test
    public void testCreateTrainer() {
        Trainer trainer = trainerService.createTrainer("Bob", "Strength");
        assertNotNull(trainer);
        assertNotNull(trainer.getId());
        assertEquals("Bob", trainer.getName());
        assertEquals("Strength", trainer.getExpertise());
    }

    @Test
    public void testUpdateTrainer() {
        Trainer trainer = trainerService.createTrainer("Bob", "Strength");
        Trainer updated = trainerService.updateTrainer(trainer.getId(), "Bob Updated", "Cardio");
        assertNotNull(updated);
        assertEquals("Bob Updated", updated.getName());
        assertEquals("Cardio", updated.getExpertise());
    }

    @Test
    public void testGetTrainer() {
        Trainer trainer = trainerService.createTrainer("Bob", "Strength");
        Trainer fetched = trainerService.getTrainer(trainer.getId());
        assertNotNull(fetched);
        assertEquals("Bob", fetched.getName());
    }

    @Test
    public void testGetAllTrainers() {
        trainerService.createTrainer("Bob", "Strength");
        trainerService.createTrainer("Alice", "Cardio");
        trainerService.createTrainer("Carol", "Yoga");
        List<Trainer> page = trainerService.getAllTrainers(2, 0);
        assertEquals(2, page.size());
        page = trainerService.getAllTrainers(2, 1);
        assertEquals(1, page.size());
    }

    @Test
    public void testGetTrainerByName() {
        trainerService.createTrainer("Bob", "Strength");
        trainerService.createTrainer("Bob", "Cardio");
        List<Trainer> result = trainerService.getTrainerByName(10, 0, "Bob");
        assertEquals(2, result.size());
    }

    @Test
    public void testGetTrainerByExpertise() {
        trainerService.createTrainer("Bob", "Strength");
        trainerService.createTrainer("Alice", "Cardio");
        trainerService.createTrainer("Carol", "Strength");
        List<Trainer> result = trainerService.getTrainerByExpertise(10, 0, "Strength");
        assertEquals(2, result.size());
    }

    @Test
    public void testDeleteTrainer() {
        Trainer trainer = trainerService.createTrainer("Bob", "Strength");
        trainerService.deleteTrainer(trainer.getId());
        Trainer fetched = trainerService.getTrainer(trainer.getId());
        assertNull(fetched);
    }
}
