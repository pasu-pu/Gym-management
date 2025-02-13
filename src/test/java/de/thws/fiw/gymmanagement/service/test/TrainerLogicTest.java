package de.thws.fiw.gymmanagement.service.test;

import static org.junit.jupiter.api.Assertions.*;

import de.thws.fiw.gymmanagement.domain.TrainerLogic;
import de.thws.fiw.gymmanagement.domain.Trainer;
import de.thws.fiw.gymmanagement.infrastructure.fakes.FakeTrainerRepository;
import de.thws.fiw.gymmanagement.infrastructure.TrainerRepositoryInterface;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TrainerLogicTest {

    private TrainerRepositoryInterface trainerRepository;
    private TrainerLogic trainerLogic;

    @BeforeEach
    public void setUp() {
        trainerRepository = new FakeTrainerRepository();
        trainerLogic = new TrainerLogic(trainerRepository);
    }

    @Test
    public void testCreateTrainer() {
        Trainer trainer = trainerLogic.createTrainer("Bob", "Strength");
        assertNotNull(trainer);
        assertNotNull(trainer.getId());
        assertEquals("Bob", trainer.getName());
        assertEquals("Strength", trainer.getExpertise());
    }

    @Test
    public void testUpdateTrainer() {
        Trainer trainer = trainerLogic.createTrainer("Bob", "Strength");
        Trainer updated = trainerLogic.updateTrainer(trainer.getId(), "Bob Updated", "Cardio");
        assertNotNull(updated);
        assertEquals("Bob Updated", updated.getName());
        assertEquals("Cardio", updated.getExpertise());
    }

    @Test
    public void testGetTrainer() {
        Trainer trainer = trainerLogic.createTrainer("Bob", "Strength");
        Trainer fetched = trainerLogic.getTrainer(trainer.getId());
        assertNotNull(fetched);
        assertEquals("Bob", fetched.getName());
    }

    @Test
    public void testGetAllTrainers() {
        trainerLogic.createTrainer("Bob", "Strength");
        trainerLogic.createTrainer("Alice", "Cardio");
        trainerLogic.createTrainer("Carol", "Yoga");
        List<Trainer> page = trainerLogic.getAllTrainers(2, 0);
        assertEquals(2, page.size());
        page = trainerLogic.getAllTrainers(2, 1);
        assertEquals(1, page.size());
    }

    @Test
    public void testGetTrainerByName() {
        trainerLogic.createTrainer("Bob", "Strength");
        trainerLogic.createTrainer("Bob", "Cardio");
        List<Trainer> result = trainerLogic.getTrainerByName(10, 0, "Bob");
        assertEquals(2, result.size());
    }

    @Test
    public void testGetTrainerByExpertise() {
        trainerLogic.createTrainer("Bob", "Strength");
        trainerLogic.createTrainer("Alice", "Cardio");
        trainerLogic.createTrainer("Carol", "Strength");
        List<Trainer> result = trainerLogic.getTrainerByExpertise(10, 0, "Strength");
        assertEquals(2, result.size());
    }

    @Test
    public void testDeleteTrainer() {
        Trainer trainer = trainerLogic.createTrainer("Bob", "Strength");
        trainerLogic.deleteTrainer(trainer.getId());
        Trainer fetched = trainerLogic.getTrainer(trainer.getId());
        assertNull(fetched);
    }
}
