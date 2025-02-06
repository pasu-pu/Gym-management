package de.thws.fiw.gymmanagement.infrastructure;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.Collectors;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import de.thws.fiw.gymmanagement.domain.Booking;
import org.hibernate.Transaction;

public class BookingRepository implements BookingRepositoryInterface {
    private final Map<Long, Booking> bookings = new HashMap<>();
    private final AtomicLong idCounter = new AtomicLong(1);
    private final SessionFactory sessionFactory;

    public BookingRepository() {
        this.sessionFactory = HibernateUtil.getSessionFactory();
    }

    @Override
    public Booking save(Booking booking, Long memberId, Long courseId) {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();

            // Setzt das Buchungsdatum auf das heutige Datum
            booking.setBookingDate(LocalDate.now());

            // Speichert die Buchung, Hibernate kümmert sich um die ID (Automatisch generiert)
            session.saveOrUpdate(booking); // saveOrUpdate entscheidet je nach Zustand der Entität, ob es ein neues oder Update ist

            transaction.commit();
            return booking;
        }
    }

    @Override
    // Findet eine Buchung anhand der ID
    public Optional<Booking> findById(Long id) {
        try (Session session = sessionFactory.openSession()) {
            Booking booking = session.get(Booking.class, id); // Holt die Buchung anhand der ID
            return Optional.ofNullable(booking);
        }
    }

    @Override
    // Findet alle Buchungen eines bestimmten Members
    public List<Booking> findByMemberId(Long memberId) {
        try (Session session = sessionFactory.openSession()) {
            String hql = "FROM Booking b WHERE b.member.id = :memberId"; // HQL-Abfrage
            return session.createQuery(hql, Booking.class)
                    .setParameter("memberId", memberId)
                    .getResultList();
        }
    }

    @Override
    // Findet alle Buchungen für ein bestimmtes Course
    public List<Booking> findByCourseId(Long courseId) {
        try (Session session = sessionFactory.openSession()) {
            String hql = "FROM Booking b WHERE b.course.id = :courseId"; // HQL-Abfrage
            return session.createQuery(hql, Booking.class)
                    .setParameter("courseId", courseId)
                    .getResultList();
        }
    }

    @Override
    // Löscht eine Buchung anhand der ID
    public void deleteById(Long id) {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();

            Booking booking = session.get(Booking.class, id); // Holt die Buchung aus der DB
            if (booking != null) {
                session.delete(booking); // Löscht die Buchung
            }

            transaction.commit();
        }
    }
}
