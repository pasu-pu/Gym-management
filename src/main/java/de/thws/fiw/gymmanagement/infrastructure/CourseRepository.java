package de.thws.fiw.gymmanagement.infrastructure;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import de.thws.fiw.gymmanagement.domain.Course;
import de.thws.fiw.gymmanagement.domain.Trainer;

public class CourseRepository implements CourseRepositoryInterface {
    private final Map<Long, Course> courses = new HashMap<>();
    private final AtomicLong idCounter = new AtomicLong(1);
    private final SessionFactory sessionFactory;

    // Konstruktor
    public CourseRepository() {
        this.sessionFactory = HibernateUtil.getSessionFactory();
    }

    @Override
    public Course save(Course course) {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();

            // Speichert oder aktualisiert den Kurs
            session.saveOrUpdate(course);

            transaction.commit();
            return course;
        }
    }

    @Override
    public Optional<Course> findById(Long id) {
        try (Session session = sessionFactory.openSession()) {
            Course course = session.get(Course.class, id); // Holt den Kurs anhand der ID
            return Optional.ofNullable(course);
        }
    }

    @Override
    public Optional<Course> findByName(String name) {
        try (Session session = sessionFactory.openSession()) {
            String hql = "FROM Course c WHERE c.name = :name";
            Course course = session.createQuery(hql, Course.class)
                    .setParameter("name", name)
                    .uniqueResult(); // Gibt das einzelne Ergebnis zurück
            return Optional.ofNullable(course);
        }
    }

    @Override
    public List<Course> findAll() {
        try (Session session = sessionFactory.openSession()) {
            String hql = "FROM Course"; // HQL-Abfrage
            return session.createQuery(hql, Course.class).getResultList(); // Gibt alle Kurse zurück
        }
    }

    @Override
    public void deleteById(Long id) {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();

            Course course = session.get(Course.class, id); // Holt den Kurs
            if (course != null) {
                session.delete(course); // Löscht den Kurs
            }

            transaction.commit();
        }
    }

    @Override
    public Course update(Long id, String name, int capacity, Long trainerId) {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();

            Course course = session.get(Course.class, id); // Holt den Kurs
            Trainer trainer = session.get(Trainer.class, trainerId);
            if (course != null) {
                course.setName(name);
                course.setCapacity(capacity);

                // Trainer als Fremdschlüssel setzen
                if (trainer != null) {
                    course.setTrainer(trainer); // Setzt den Trainer
                } else {
                    throw new RuntimeException("Trainer not found");
                }

                session.saveOrUpdate(course); // Speichert den Kurs nach der Aktualisierung
            }

            transaction.commit();
            return course;
        }
    }

}
