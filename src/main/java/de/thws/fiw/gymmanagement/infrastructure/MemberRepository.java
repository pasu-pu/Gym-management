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

import de.thws.fiw.gymmanagement.domain.Member;

public class MemberRepository implements MemberRepositoryInterface {
    private final Map<Long, Member> members = new HashMap<>();
    private final AtomicLong idCounter = new AtomicLong(1);
    private final SessionFactory sessionFactory;

    public MemberRepository() {
        this.sessionFactory = HibernateUtil.getSessionFactory();
    }

    @Override
    public Member save(Member member) {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();

            // Speichert oder aktualisiert das Member-Objekt
            session.saveOrUpdate(member);

            transaction.commit();
            return member;
        }
    }

    @Override
    public Optional<Member> findById(Long id) {
        try (Session session = sessionFactory.openSession()) {
            Member member = session.get(Member.class, id); // Holt das Member anhand der ID
            return Optional.ofNullable(member);
        }
    }

    @Override
    public List<Member> findAll() {
        try (Session session = sessionFactory.openSession()) {
            String hql = "FROM Member"; // HQL-Abfrage
            return session.createQuery(hql, Member.class).getResultList(); // Gibt alle Mitglieder zurück
        }
    }

    @Override
    public void deleteById(Long id) {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();

            Member member = session.get(Member.class, id); // Holt das Member
            if (member != null) {
                session.delete(member); // Löscht das Member
            }

            transaction.commit();
        }
    }

    @Override
    public Member update(Long id, String name, String membershipType) {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();

            Member member = session.get(Member.class, id); // Holt das Member anhand der ID
            if (member != null) {
                member.setName(name); // Aktualisiert den Namen
                member.setMembershipType(membershipType); // Aktualisiert den Membership-Typ
                session.saveOrUpdate(member); // Speichert das Member nach der Aktualisierung
            }

            transaction.commit();
            return member;
        }
    }
}
