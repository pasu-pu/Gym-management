package de.thws.fiw.gymmanagement.infrastructure;

import de.thws.fiw.gymmanagement.domain.Booking;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public class BookingRepository implements BookingRepositoryInterface {

    private final SessionFactory sessionFactory;

    public BookingRepository() {
        this.sessionFactory = HibernateUtil.getSessionFactory();
    }

    @Override
    public Booking save(Booking booking, Long memberId, Long courseId) {
        try (Session session = sessionFactory.openSession()) {
            Transaction tx = session.beginTransaction();
            // Optional: booking.setBookingDate(LocalDate.now());
            session.saveOrUpdate(booking);
            tx.commit();
            return booking;
        }
    }

    @Override
    public Optional<Booking> findById(Long id) {
        try (Session session = sessionFactory.openSession()) {
            Booking booking = session.get(Booking.class, id);
            return Optional.ofNullable(booking);
        }
    }

    @Override
    public List<Booking> findByMemberId(Long memberId) {
        try (Session session = sessionFactory.openSession()) {
            String hql = "FROM Booking b WHERE b.member.id = :memberId";
            Query<Booking> query = session.createQuery(hql, Booking.class);
            query.setParameter("memberId", memberId);
            return query.list();
        }
    }

    @Override
    public List<Booking> findByCourseId(Long courseId) {
        try (Session session = sessionFactory.openSession()) {
            String hql = "FROM Booking b WHERE b.course.id = :courseId";
            Query<Booking> query = session.createQuery(hql, Booking.class);
            query.setParameter("courseId", courseId);
            return query.list();
        }
    }

    @Override
    public List<Booking> findByDate(LocalDate date) {
        try (Session session = sessionFactory.openSession()) {
            String hql = "FROM Booking b WHERE b.bookingDate = :date";
            Query<Booking> query = session.createQuery(hql, Booking.class);
            query.setParameter("date", date);
            return query.list();
        }
    }

    @Override
    public void deleteById(Long id) {
        try (Session session = sessionFactory.openSession()) {
            Transaction tx = session.beginTransaction();
            Booking booking = session.get(Booking.class, id);
            if (booking != null) {
                session.delete(booking);
            }
            tx.commit();
        }
    }
}
