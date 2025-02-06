package de.thws.fiw.gymmanagement.infrastructure;

import de.thws.fiw.gymmanagement.domain.Course;
import de.thws.fiw.gymmanagement.domain.Trainer;

import java.util.*;
import java.util.concurrent.atomic.AtomicLong;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class TrainerRepository implements TrainerRepositoryInterface {
    private final Map<Long, Trainer> trainers = new HashMap<>();
    private final AtomicLong idCounter = new AtomicLong(1);
    private final SessionFactory sessionFactory;

    public TrainerRepository() {
        this.sessionFactory = HibernateUtil.getSessionFactory();
    }

    @Override
    public Trainer save(Trainer trainer) {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();

            // Speichert oder aktualisiert den Trainer
            session.saveOrUpdate(trainer);

            transaction.commit();
            return trainer;
        }
    }

    @Override
    public Optional<Trainer> findById(Long id) {
        try (Session session = sessionFactory.openSession()) {
            Trainer trainer = session.get(Trainer.class, id); // Holt den Trainer anhand der ID
            return Optional.ofNullable(trainer);
        }
    }

    @Override
    public List<Trainer> findAll() {
        try (Session session = sessionFactory.openSession()) {
            String hql = "FROM Trainer"; // HQL-Abfrage
            return session.createQuery(hql, Trainer.class).getResultList(); // Gibt alle Trainer zurück
        }
    }

    @Override
    public void deleteById(Long id) {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();

            Trainer trainer = session.get(Trainer.class, id); // Holt den Trainer
            if (trainer != null) {
                session.delete(trainer); // Löscht den Trainer
            }

            transaction.commit();
        }
    }

    @Override
    public Trainer update(Long id, String name, String expertise) {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();

            Trainer trainer = session.get(Trainer.class, id); // Holt den Trainer anhand der ID
            if (trainer != null) {
                trainer.setName(name); // Aktualisiert den Namen
                trainer.setExpertise(expertise); // Aktualisiert die Expertise
                session.saveOrUpdate(trainer); // Speichert den Trainer nach der Aktualisierung
            }

            transaction.commit();
            return trainer;
        }
    }

    @Override
    public List<Course> findCoursesByTrainerId(Long trainerId) {
        try (Session session = sessionFactory.openSession()) {
            // Erstellen einer HQL-Abfrage, um Kurse zu finden, die den angegebenen Trainer haben
            String hql = "FROM Course c WHERE c.trainer.id = :trainerId"; // Hier greifen wir auf die Trainer-Referenz zu
            List<Course> courses;
            courses = session.createQuery(hql, Course.class).setParameter("trainerId", trainerId).getResultList();

            return courses;
        }
    }

}
