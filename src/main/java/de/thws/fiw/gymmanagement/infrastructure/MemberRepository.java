package de.thws.fiw.gymmanagement.infrastructure;

import de.thws.fiw.gymmanagement.domain.Member;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import java.util.List;
import java.util.Optional;

public class MemberRepository implements MemberRepositoryInterface {

    private final SessionFactory sessionFactory;

    public MemberRepository() {
        this.sessionFactory = HibernateUtil.getSessionFactory();
    }

    @Override
    public Member save(Member member) {
        try (Session session = sessionFactory.openSession()) {
            Transaction tx = session.beginTransaction();
            session.saveOrUpdate(member);
            tx.commit();
            return member;
        }
    }

    @Override
    public Optional<Member> findById(Long id) {
        try (Session session = sessionFactory.openSession()) {
            Member member = session.get(Member.class, id);
            return Optional.ofNullable(member);
        }
    }

    @Override
    public List<Member> findAll() {
        try (Session session = sessionFactory.openSession()) {
            return session.createQuery("FROM Member", Member.class).list();
        }
    }

    @Override
    public Member update(Long id, String name, String membershipType) {
        try (Session session = sessionFactory.openSession()) {
            Transaction tx = session.beginTransaction();
            Member member = session.get(Member.class, id);
            if (member != null) {
                member.setName(name);
                member.setMembershipType(membershipType);
                session.update(member);
            }
            tx.commit();
            return member;
        }
    }

    @Override
    public void deleteById(Long id) {
        try (Session session = sessionFactory.openSession()) {
            Transaction tx = session.beginTransaction();
            Member member = session.get(Member.class, id);
            if (member != null) {
                session.delete(member);
            }
            tx.commit();
        }
    }

    @Override
    public List<Member> findByName(String name) {
        try (Session session = sessionFactory.openSession()) {
            String hql = "FROM Member m WHERE lower(m.name) = :name";
            Query<Member> query = session.createQuery(hql, Member.class);
            query.setParameter("name", name.toLowerCase());
            return query.list();
        }
    }

    @Override
    public List<Member> findByMembership(String membership) {
        try (Session session = sessionFactory.openSession()) {
            String hql = "FROM Member m WHERE lower(m.membershipType) = :membership";
            Query<Member> query = session.createQuery(hql, Member.class);
            query.setParameter("membership", membership.toLowerCase());
            return query.list();
        }
    }

    @Override
    public void deleteAll() {
        Transaction transaction = null;
        try (Session session = sessionFactory.openSession()) {
            transaction = session.beginTransaction();
            session.createQuery("DELETE FROM Member").executeUpdate();
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }
}
