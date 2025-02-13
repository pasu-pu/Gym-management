package de.thws.fiw.gymmanagement.application.service;

import de.thws.fiw.gymmanagement.domain.Trainer;
import de.thws.fiw.gymmanagement.infrastructure.TrainerRepositoryInterface;
import java.util.ArrayList;
import java.util.List;

public class TrainerService implements TrainerServiceAdapter {

    private final TrainerRepositoryInterface trainerRepository;

    public TrainerService(TrainerRepositoryInterface trainerRepository) {
        this.trainerRepository = trainerRepository;
    }

    @Override
    public Trainer createTrainer(String name, String expertise) {
        System.out.println("[TrainerService] createTrainer called with name: " + name + ", expertise: " + expertise);
        try {
            System.out.println("[TrainerService] Creating new Trainer object");
            Trainer trainer = new Trainer();
            trainer.setName(name);
            trainer.setExpertise(expertise);
            Trainer savedTrainer = trainerRepository.save(trainer);
            System.out.println("[TrainerService] createTrainer succeeded: created trainer with id " + savedTrainer.getId());
            return savedTrainer;
        } catch (Exception e) {
            System.err.println("[TrainerService] Error in createTrainer: " + e.getMessage());
            throw e;
        }
    }

    @Override
    public Trainer updateTrainer(long id, String name, String expertise) {
        System.out.println("[TrainerService] updateTrainer called for trainerId: " + id + " with new name: " + name + ", expertise: " + expertise);
        try {
            Trainer updatedTrainer = trainerRepository.update(id, name, expertise);
            System.out.println("[TrainerService] updateTrainer succeeded for trainerId: " + updatedTrainer.getId());
            return updatedTrainer;
        } catch (Exception e) {
            System.err.println("[TrainerService] Error in updateTrainer: " + e.getMessage());
            throw e;
        }
    }

    @Override
    public Trainer getTrainer(long id) {
        System.out.println("[TrainerService] getTrainer called for trainerId: " + id);
        try {
            Trainer trainer = trainerRepository.findById(id).orElse(null);
            if (trainer == null) {
                System.err.println("[TrainerService] getTrainer: Trainer with id " + id + " not found");
            } else {
                System.out.println("[TrainerService] getTrainer succeeded for trainerId: " + trainer.getId());
            }
            return trainer;
        } catch (Exception e) {
            System.err.println("[TrainerService] Error in getTrainer: " + e.getMessage());
            throw e;
        }
    }

    @Override
    public List<Trainer> getAllTrainers(int pageSize, int index) {
        System.out.println("[TrainerService] getAllTrainers called with pagesize: " + pageSize + ", index: " + index);
        try {
            List<Trainer> allTrainers = trainerRepository.findAll();
            int start = index * pageSize;
            int end = Math.min(start + pageSize, allTrainers.size());
            List<Trainer> result = (start >= allTrainers.size()) ? new ArrayList<>() : allTrainers.subList(start, end);
            System.out.println("[TrainerService] getAllTrainers succeeded: returned " + result.size() + " trainers");
            return result;
        } catch (Exception e) {
            System.err.println("[TrainerService] Error in getAllTrainers: " + e.getMessage());
            throw e;
        }
    }

    @Override
    public List<Trainer> getTrainerByName(int pageSize, int index, String name) {
        System.out.println("[TrainerService] getTrainerByName called with name: " + name
                + ", pagesize: " + pageSize + ", index: " + index);
        try {
            // Annahme: Das Repository bietet eine Methode findByName(String name) an
            List<Trainer> filtered = trainerRepository.findByName(name);
            int start = index * pageSize;
            int end = Math.min(start + pageSize, filtered.size());
            List<Trainer> result = (start >= filtered.size()) ? new ArrayList<>() : filtered.subList(start, end);
            System.out.println("[TrainerService] getTrainerByName succeeded: returned " + result.size() + " trainers");
            return result;
        } catch (Exception e) {
            System.err.println("[TrainerService] Error in getTrainerByName: " + e.getMessage());
            throw e;
        }
    }

    @Override
    public List<Trainer> getTrainerByExpertise(int pageSize, int index, String expertise) {
        System.out.println("[TrainerService] getTrainerByExpertise called with expertise: " + expertise
                + ", pagesize: " + pageSize + ", index: " + index);
        try {
            // Annahme: Das Repository bietet eine Methode findByExpertise(String expertise) an
            List<Trainer> filtered = trainerRepository.findByExpertise(expertise);
            int start = index * pageSize;
            int end = Math.min(start + pageSize, filtered.size());
            List<Trainer> result = (start >= filtered.size()) ? new ArrayList<>() : filtered.subList(start, end);
            System.out.println("[TrainerService] getTrainerByExpertise succeeded: returned " + result.size() + " trainers");
            return result;
        } catch (Exception e) {
            System.err.println("[TrainerService] Error in getTrainerByExpertise: " + e.getMessage());
            throw e;
        }
    }

    @Override
    public void deleteTrainer(long id) {
        System.out.println("[TrainerService] deleteTrainer called for trainerId: " + id);
        try {
            trainerRepository.deleteById(id);
            System.out.println("[TrainerService] deleteTrainer succeeded for trainerId: " + id);
        } catch (Exception e) {
            System.err.println("[TrainerService] Error in deleteTrainer: " + e.getMessage());
            throw e;
        }
    }
}
