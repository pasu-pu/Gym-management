package de.thws.fiw.gymmanagement.application.service;

import de.thws.fiw.gymmanagement.domain.Trainer;
import de.thws.fiw.gymmanagement.infrastructure.TrainerRepositoryInterface;

import java.util.List;
import java.util.Optional;

public class TrainerService {
    private final TrainerRepositoryInterface trainerRepository;

    public TrainerService(TrainerRepositoryInterface trainerRepository) {
        this.trainerRepository = trainerRepository;
    }

    public Trainer createTrainer(String name, String expertise) {
        Trainer trainer = new Trainer();
        trainer.setName(name);
        trainer.setExpertise(expertise);
        return trainerRepository.save(trainer);
    }

    public Optional<Trainer> getTrainer(Long trainerId) {
        return trainerRepository.findById(trainerId);
    }

    public List<Trainer> getAllTrainers() {
        return trainerRepository.findAll();
    }

    public boolean updateTrainer(Long trainerId, String name, String expertise) {
        return trainerRepository.update(trainerId, name, expertise) != null;
    }

    public boolean deleteTrainer(Long trainerId) {
        return trainerRepository.findById(trainerId)
                .map(trainer -> {
                    trainerRepository.deleteById(trainer.getId());
                    return true;
                })
                .orElse(false);
    }
}
