package de.thws.fiw.gymmanagement.infrastructure;

import de.thws.fiw.gymmanagement.domain.Course;
import de.thws.fiw.gymmanagement.domain.Trainer;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import java.util.List;
import java.util.Optional;

public class CourseRepository implements CourseRepositoryInterface {

    private final SessionFactory sessionFactory;

    public CourseRepository() {
        this.sessionFactory = HibernateUtil.getSessionFactory();
    }

    @Override
    public Course save(Course course) {
        try (Session session = sessionFactory.openSession()) {
            Transaction tx = session.beginTransaction();
            session.saveOrUpdate(course);
            tx.commit();
            return course;
        }
    }

    @Override
    public Optional<Course> findById(Long id) {
        try (Session session = sessionFactory.openSession()) {
            Course course = session.get(Course.class, id);
            return Optional.ofNullable(course);
        }
    }

    @Override
    public List<Course> findAll() {
        try (Session session = sessionFactory.openSession()) {
            return session.createQuery("FROM Course", Course.class).list();
        }
    }

    @Override
    public Course update(Long id, String name, int capacity, Long trainerId) {
        try (Session session = sessionFactory.openSession()) {
            Transaction tx = session.beginTransaction();
            Course course = session.get(Course.class, id);
            if (course != null) {
                course.setName(name);
                course.setCapacity(capacity);
                Trainer trainer = session.get(Trainer.class, trainerId);
                if (trainer == null) {
                    throw new RuntimeException("Trainer not found");
                }
                course.setTrainer(trainer);
                session.update(course);
            }
            tx.commit();
            return course;
        }
    }

    @Override
    public void deleteById(Long id) {
        try (Session session = sessionFactory.openSession()) {
            Transaction tx = session.beginTransaction();
            Course course = session.get(Course.class, id);
            if (course != null) {
                session.delete(course);
            }
            tx.commit();
        }
    }

    @Override
    public List<Course> findByName(String name) {
        try (Session session = sessionFactory.openSession()) {
            String hql = "FROM Course c WHERE lower(c.name) = :name";
            Query<Course> query = session.createQuery(hql, Course.class);
            query.setParameter("name", name.toLowerCase());
            return query.list();
        }
    }

    @Override
    public List<Course> findByTrainerId(Long trainerId) {
        try (Session session = sessionFactory.openSession()) {
            String hql = "FROM Course c WHERE c.trainer.id = :trainerId";
            Query<Course> query = session.createQuery(hql, Course.class);
            query.setParameter("trainerId", trainerId);
            return query.list();
        }
    }
}
