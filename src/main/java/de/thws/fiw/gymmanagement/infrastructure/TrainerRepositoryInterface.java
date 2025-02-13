package de.thws.fiw.gymmanagement.infrastructure;

import de.thws.fiw.gymmanagement.domain.Trainer;
import java.util.List;
import java.util.Optional;

public interface TrainerRepositoryInterface {
    Trainer save(Trainer trainer);
    Optional<Trainer> findById(Long id);
    List<Trainer> findAll();
    Trainer update(Long id, String name, String expertise);
    void deleteById(Long id);

    // Filterabfragen
    List<Trainer> findByName(String name);
    List<Trainer> findByExpertise(String expertise);
}
