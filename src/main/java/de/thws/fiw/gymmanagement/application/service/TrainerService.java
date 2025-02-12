package de.thws.fiw.gymmanagement.application.service;

import de.thws.fiw.gymmanagement.domain.Trainer;
import de.thws.fiw.gymmanagement.infrastructure.TrainerRepositoryInterface;

import java.util.List;

public class TrainerService implements TrainerServiceAdapter {

    TrainerRepositoryInterface trainerRepository;

    public TrainerService(TrainerRepositoryInterface trainerRepository){
        this.trainerRepository=trainerRepository;
    }
    @Override
    public Trainer createTrainer(String name, String expertise) {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    @Override
    public Trainer updateTrainer(long id, String name, String expertise) {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    @Override
    public Trainer getTrainer(long id) {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    @Override
    public List<Trainer> getAllTrainers(int pageSize, int index) {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    @Override
    public List<Trainer> getTrainerByName(int pageSize, int index, String name) {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    @Override
    public List<Trainer> getTrainerByExpertise(int pageSize, int index, String expertise) {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    @Override
    public void deleteTrainer(long id) {
        throw new UnsupportedOperationException("Not implemented yet");
    }
}
