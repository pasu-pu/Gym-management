package de.thws.fiw.gymmanagement.domain;

import de.thws.fiw.gymmanagement.infrastructure.TrainerRepositoryInterface;
import java.util.ArrayList;
import java.util.List;

public class TrainerLogic implements TrainerLogicAdapter {

    private final TrainerRepositoryInterface trainerRepository;

    public TrainerLogic(TrainerRepositoryInterface trainerRepository) {
        this.trainerRepository = trainerRepository;
    }

    @Override
    public Trainer createTrainer(String name, String expertise) {
        System.out.println("[TrainerLogic] createTrainer called with name: " + name + ", expertise: " + expertise);
        try {
            System.out.println("[TrainerLogic] Creating new Trainer object using Builder");
            Trainer trainer = new Trainer.Builder()
                    .withName(name)
                    .withExpertise(expertise)
                    .build();
            Trainer savedTrainer = trainerRepository.save(trainer);
            System.out.println("[TrainerLogic] createTrainer succeeded: created trainer with id " + savedTrainer.getId());
            return savedTrainer;
        } catch (Exception e) {
            System.err.println("[TrainerLogic] Error in createTrainer: " + e.getMessage());
            throw e;
        }
    }

    @Override
    public Trainer updateTrainer(long id, String name, String expertise) {
        System.out.println("[TrainerLogic] updateTrainer called for trainerId: " + id + " with new name: " + name + ", expertise: " + expertise);
        try {
            Trainer updatedTrainer = trainerRepository.update(id, name, expertise);
            System.out.println("[TrainerLogic] updateTrainer succeeded for trainerId: " + updatedTrainer.getId());
            return updatedTrainer;
        } catch (Exception e) {
            System.err.println("[TrainerLogic] Error in updateTrainer: " + e.getMessage());
            throw e;
        }
    }

    @Override
    public Trainer getTrainer(long id) {
        System.out.println("[TrainerLogic] getTrainer called for trainerId: " + id);
        try {
            Trainer trainer = trainerRepository.findById(id).orElse(null);
            if (trainer == null) {
                System.err.println("[TrainerLogic] getTrainer: Trainer with id " + id + " not found");
            } else {
                System.out.println("[TrainerLogic] getTrainer succeeded for trainerId: " + trainer.getId());
            }
            return trainer;
        } catch (Exception e) {
            System.err.println("[TrainerLogic] Error in getTrainer: " + e.getMessage());
            throw e;
        }
    }

    @Override
    public List<Trainer> getAllTrainers(int pageSize, int index) {
        System.out.println("[TrainerLogic] getAllTrainers called with pagesize: " + pageSize + ", index: " + index);
        try {
            List<Trainer> allTrainers = trainerRepository.findAll();
            int start = index * pageSize;
            int end = Math.min(start + pageSize, allTrainers.size());
            List<Trainer> result = (start >= allTrainers.size()) ? new ArrayList<>() : allTrainers.subList(start, end);
            System.out.println("[TrainerLogic] getAllTrainers succeeded: returned " + result.size() + " trainers");
            return result;
        } catch (Exception e) {
            System.err.println("[TrainerLogic] Error in getAllTrainers: " + e.getMessage());
            throw e;
        }
    }

    @Override
    public List<Trainer> getTrainerByName(int pageSize, int index, String name) {
        System.out.println("[TrainerLogic] getTrainerByName called with name: " + name
                + ", pagesize: " + pageSize + ", index: " + index);
        try {
            List<Trainer> filtered = trainerRepository.findByName(name);
            int start = index * pageSize;
            int end = Math.min(start + pageSize, filtered.size());
            List<Trainer> result = (start >= filtered.size()) ? new ArrayList<>() : filtered.subList(start, end);
            System.out.println("[TrainerLogic] getTrainerByName succeeded: returned " + result.size() + " trainers");
            return result;
        } catch (Exception e) {
            System.err.println("[TrainerLogic] Error in getTrainerByName: " + e.getMessage());
            throw e;
        }
    }

    @Override
    public List<Trainer> getTrainerByExpertise(int pageSize, int index, String expertise) {
        System.out.println("[TrainerLogic] getTrainerByExpertise called with expertise: " + expertise
                + ", pagesize: " + pageSize + ", index: " + index);
        try {
            List<Trainer> filtered = trainerRepository.findByExpertise(expertise);
            int start = index * pageSize;
            int end = Math.min(start + pageSize, filtered.size());
            List<Trainer> result = (start >= filtered.size()) ? new ArrayList<>() : filtered.subList(start, end);
            System.out.println("[TrainerLogic] getTrainerByExpertise succeeded: returned " + result.size() + " trainers");
            return result;
        } catch (Exception e) {
            System.err.println("[TrainerLogic] Error in getTrainerByExpertise: " + e.getMessage());
            throw e;
        }
    }

    @Override
    public void deleteTrainer(long id) {
        System.out.println("[TrainerLogic] deleteTrainer called for trainerId: " + id);
        try {
            trainerRepository.deleteById(id);
            System.out.println("[TrainerLogic] deleteTrainer succeeded for trainerId: " + id);
        } catch (Exception e) {
            System.err.println("[TrainerLogic] Error in deleteTrainer: " + e.getMessage());
            throw e;
        }
    }
}
