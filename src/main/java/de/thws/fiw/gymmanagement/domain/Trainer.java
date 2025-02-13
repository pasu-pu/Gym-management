package de.thws.fiw.gymmanagement.domain;

import jakarta.persistence.*;

@Entity
@Table(name = "trainers")
public class Trainer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String expertise;

    public void setName(String name) {
        this.name = name;
    }

    public void setExpertise(String expertise) {
        this.expertise = expertise;
    }
    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getExpertise() {
        return expertise;
    }

    // Builder Pattern for Trainer
    public static class Builder {
        private Long id; // Optional; typically not set for new trainers
        private String name;
        private String expertise;

        public Builder() {}

        public Builder withId(Long id) {
            this.id = id;
            return this;
        }

        public Builder withName(String name) {
            this.name = name;
            return this;
        }

        public Builder withExpertise(String expertise) {
            this.expertise = expertise;
            return this;
        }

        public Trainer build() {
            Trainer trainer = new Trainer();
            trainer.id = this.id;  // This is usually null for new courses
            trainer.name = this.name;
            trainer.expertise = this.expertise;
            return trainer;
        }
    }
}
