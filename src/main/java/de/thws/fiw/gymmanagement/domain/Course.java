package de.thws.fiw.gymmanagement.domain;

import jakarta.persistence.*;

@Entity
@Table(name = "courses")
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private int capacity;

    @ManyToOne
    @JoinColumn(name = "trainer", nullable = false)
    private Trainer trainer;

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getCapacity() {
        return capacity;
    }

    public Trainer getTrainer() {
        return trainer;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public void setTrainer(Trainer trainer) {
        this.trainer = trainer;
    }

    // Builder Pattern for Course
    public static class Builder {
        private Long id; // Optional; typically not set for new courses
        private String name;
        private int capacity;
        private Trainer trainer;

        public Builder() {}

        public Builder withId(Long id) {
            this.id = id;
            return this;
        }

        public Builder withName(String name) {
            this.name = name;
            return this;
        }

        public Builder withCapacity(int capacity) {
            this.capacity = capacity;
            return this;
        }

        public Builder withTrainer(Trainer trainer) {
            this.trainer = trainer;
            return this;
        }

        public Course build() {
            Course course = new Course();
            course.id = this.id;  // This is usually null for new courses
            course.name = this.name;
            course.capacity = this.capacity;
            course.trainer = this.trainer;
            return course;
        }
    }
}
