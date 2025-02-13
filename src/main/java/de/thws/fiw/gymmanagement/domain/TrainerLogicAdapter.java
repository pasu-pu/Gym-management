package de.thws.fiw.gymmanagement.domain;

import de.thws.fiw.gymmanagement.domain.Trainer;
import java.util.List;

public interface TrainerLogicAdapter {
    Trainer createTrainer(String name, String expertise);
    Trainer updateTrainer(long id, String name, String expertise);
    Trainer getTrainer(long id);
    List<Trainer> getAllTrainers(int pageSize, int index);
    List<Trainer> getTrainerByName(int pageSize, int index, String name);
    List<Trainer> getTrainerByExpertise(int pageSize, int index, String expertise);
    void deleteTrainer(long id);
}
