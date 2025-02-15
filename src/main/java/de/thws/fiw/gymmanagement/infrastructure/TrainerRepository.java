package de.thws.fiw.gymmanagement.infrastructure;

import de.thws.fiw.gymmanagement.domain.Trainer;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import java.util.List;
import java.util.Optional;

public class TrainerRepository implements TrainerRepositoryInterface {

    private final SessionFactory sessionFactory;

    public TrainerRepository() {
        this.sessionFactory = HibernateUtil.getSessionFactory();
    }

    @Override
    public Trainer save(Trainer trainer) {
        try (Session session = sessionFactory.openSession()) {
            Transaction tx = session.beginTransaction();
            session.saveOrUpdate(trainer);
            tx.commit();
            return trainer;
        }
    }

    @Override
    public Optional<Trainer> findById(Long id) {
        try (Session session = sessionFactory.openSession()) {
            Trainer trainer = session.get(Trainer.class, id);
            return Optional.ofNullable(trainer);
        }
    }

    @Override
    public List<Trainer> findAll() {
        try (Session session = sessionFactory.openSession()) {
            return session.createQuery("FROM Trainer", Trainer.class).list();
        }
    }

    @Override
    public Trainer update(Long id, String name, String expertise) {
        try (Session session = sessionFactory.openSession()) {
            Transaction tx = session.beginTransaction();
            Trainer trainer = session.get(Trainer.class, id);
            if (trainer != null) {
                trainer.setName(name);
                trainer.setExpertise(expertise);
                session.update(trainer);
            }
            tx.commit();
            return trainer;
        }
    }

    @Override
    public void deleteById(Long id) {
        try (Session session = sessionFactory.openSession()) {
            Transaction tx = session.beginTransaction();
            Trainer trainer = session.get(Trainer.class, id);
            if (trainer != null) {
                session.delete(trainer);
            }
            tx.commit();
        }
    }

    @Override
    public List<Trainer> findByName(String name) {
        try (Session session = sessionFactory.openSession()) {
            String hql = "FROM Trainer t WHERE lower(t.name) = :name";
            Query<Trainer> query = session.createQuery(hql, Trainer.class);
            query.setParameter("name", name.toLowerCase());
            return query.list();
        }
    }

    @Override
    public List<Trainer> findByExpertise(String expertise) {
        try (Session session = sessionFactory.openSession()) {
            String hql = "FROM Trainer t WHERE lower(t.expertise) = :expertise";
            Query<Trainer> query = session.createQuery(hql, Trainer.class);
            query.setParameter("expertise", expertise.toLowerCase());
            return query.list();
        }
    }

    @Override
    public void deleteAll() {
        Transaction transaction = null;
        try (Session session = sessionFactory.openSession()) {
            transaction = session.beginTransaction();
            session.createQuery("DELETE FROM Trainer").executeUpdate();
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }
}
