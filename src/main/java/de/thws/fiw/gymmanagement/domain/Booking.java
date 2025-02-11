package de.thws.fiw.gymmanagement.domain;

import java.time.LocalDate;

import jakarta.persistence.*;

@Entity // Markiert diese Klasse als eine JPA-Entity, sodass Hibernate sie in eine Tabelle umwandelt.
@Table(name = "bookings") // Optional: Gibt explizit den Tabellennamen an.
public class Booking {

    @Id // Definiert das Primärschlüsselfeld.
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    // Automatische ID-Generierung durch die Datenbank (H2 unterstützt Identity-Strategie).
    private Long id;

    @ManyToOne // Viele Buchungen gehören zu einem Mitglied.
    @JoinColumn(name = "member_id", nullable = false)
    // Erstellt eine Fremdschlüsselspalte "member_id", die auf die Member-Tabelle verweist.
    private Member member;

    @ManyToOne // Viele Buchungen können sich auf einen Kurs beziehen.
    @JoinColumn(name = "course_id", nullable = false)
    // Erstellt eine Fremdschlüsselspalte "course_id", die auf die Class-Tabelle verweist.
    private Course course;

    @Column(name = "booking_date", nullable = false)
    // Spaltenname wird "booking_date", darf nicht null sein.
    private LocalDate bookingDate;

    // Getter und Setter
    public Long getId() {
        return id;
    }

    public void setId(Long id) { this.id = id; }

    public Member getMember() {
        return member;
    }

    public void setMember(Member member) {
        this.member = member;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public LocalDate getBookingDate() {
        return bookingDate;
    }

    public void setBookingDate(LocalDate bookingDate) {
        this.bookingDate = bookingDate;
    }
}
