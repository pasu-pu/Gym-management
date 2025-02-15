package de.thws.fiw.gymmanagement.domain;

import java.time.LocalDate;
import jakarta.persistence.*;

@Entity
@Table(name = "bookings")
public class Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(cascade = CascadeType.REMOVE)
    @JoinColumn(name = "member", nullable = false)
    private Member member;

    public void setMember(Member member) {
        this.member = member;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public void setBookingDate(LocalDate bookingDate) {
        this.bookingDate = bookingDate;
    }

    @ManyToOne(cascade = CascadeType.REMOVE)
    @JoinColumn(name = "course", nullable = false)
    private Course course;

    @Column(name = "booking_date", nullable = false)
    private LocalDate bookingDate;

    // Getters (setters omitted if not needed)
    public Long getId() {
        return id;
    }

    public Member getMember() {
        return member;
    }

    public Course getCourse() {
        return course;
    }

    public LocalDate getBookingDate() {
        return bookingDate;
    }

    // Builder Pattern
    public static class Builder {
        private Long id; // Optional: typically, the DB will generate the id.
        private Member member;
        private Course course;
        private LocalDate bookingDate;

        public Builder() {}

        public Builder withId(Long id) {
            this.id = id;
            return this;
        }

        public Builder withMember(Member member) {
            this.member = member;
            return this;
        }

        public Builder withCourse(Course course) {
            this.course = course;
            return this;
        }

        public Builder withBookingDate(LocalDate bookingDate) {
            this.bookingDate = bookingDate;
            return this;
        }

        public Booking build() {
            Booking booking = new Booking();
            booking.id = this.id;  // Usually left null for new bookings (auto-generated)
            booking.member = this.member;
            booking.course = this.course;
            booking.bookingDate = this.bookingDate;
            return booking;
        }
    }
}
