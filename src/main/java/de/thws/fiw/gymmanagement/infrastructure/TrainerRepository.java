package de.thws.fiw.gymmanagement.infrastructure;

import de.thws.fiw.gymmanagement.domain.Course;
import de.thws.fiw.gymmanagement.domain.Trainer;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery;

import java.util.*;
import java.util.concurrent.atomic.AtomicLong;
import java.util.function.Function;

public class TrainerRepository implements TrainerRepositoryInterface {
    private final Map<Long, Trainer> trainers = new HashMap<>();
    private final AtomicLong idCounter = new AtomicLong(1);

    @Override
    public Trainer save(Trainer trainer) {
        if (trainer.getId() == null) {
            trainer.setId(idCounter.getAndIncrement());
        }
        trainers.put(trainer.getId(), trainer);
        return trainer;
    }

    @Override
    public Optional<Trainer> findById(Long id) {
        return Optional.ofNullable(trainers.get(id));
    }

    @Override
    public boolean existsById(Long aLong) {
        return false;
    }

    @Override
    public List<Trainer> findAll() {
        return new ArrayList<>(trainers.values());
    }

    @Override
    public List<Trainer> findAll(Sort sort) {
        return null;
    }

    @Override
    public Page<Trainer> findAll(Pageable pageable) {
        return null;
    }

    @Override
    public List<Trainer> findAllById(Iterable<Long> longs) {
        return null;
    }

    @Override
    public long count() {
        return 0;
    }

    @Override
    public <S extends Trainer> List<S> saveAll(Iterable<S> entities) {
        return null;
    }

    @Override
    public void flush() {

    }

    @Override
    public <S extends Trainer> S saveAndFlush(S entity) {
        return null;
    }

    @Override
    public <S extends Trainer> List<S> saveAllAndFlush(Iterable<S> entities) {
        return null;
    }

    @Override
    public void deleteAllInBatch(Iterable<Trainer> entities) {

    }

    @Override
    public void deleteAllByIdInBatch(Iterable<Long> longs) {

    }

    @Override
    public void deleteAllInBatch() {

    }

    @Override
    public Trainer getOne(Long aLong) {
        return null;
    }

    @Override
    public Trainer getById(Long aLong) {
        return null;
    }

    @Override
    public Trainer getReferenceById(Long aLong) {
        return null;
    }

    @Override
    public <S extends Trainer> Optional<S> findOne(Example<S> example) {
        return Optional.empty();
    }

    @Override
    public <S extends Trainer> List<S> findAll(Example<S> example) {
        return null;
    }

    @Override
    public <S extends Trainer> List<S> findAll(Example<S> example, Sort sort) {
        return null;
    }

    @Override
    public <S extends Trainer> Page<S> findAll(Example<S> example, Pageable pageable) {
        return null;
    }

    @Override
    public <S extends Trainer> long count(Example<S> example) {
        return 0;
    }

    @Override
    public <S extends Trainer> boolean exists(Example<S> example) {
        return false;
    }

    @Override
    public <S extends Trainer, R> R findBy(Example<S> example, Function<FluentQuery.FetchableFluentQuery<S>, R> queryFunction) {
        return null;
    }

    @Override
    public void deleteById(Long id) {
        trainers.remove(id);
    }

    @Override
    public void delete(Trainer entity) {

    }

    @Override
    public void deleteAllById(Iterable<? extends Long> longs) {

    }

    @Override
    public void deleteAll(Iterable<? extends Trainer> entities) {

    }

    @Override
    public void deleteAll() {

    }

    @Override
    public Trainer update(Long id, String name, String expertise) {
        Trainer trainer = trainers.get(id);
        if (trainer != null) {
            trainer.setName(name);
            trainer.setExpertise(expertise);
            trainers.put(id, trainer); // Aktualisieren der Map
        }
        return trainer;
    }
    @Override
    public List<Course> findCoursesByTrainerId(Long trainerId) {
        return trainers.get(trainerId).getCourses();
    }

}
