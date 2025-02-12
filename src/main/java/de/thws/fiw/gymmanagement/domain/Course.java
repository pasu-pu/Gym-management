package de.thws.fiw.gymmanagement.domain;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity // Markiert diese Klasse als eine JPA-Entity, sodass Hibernate sie in eine Tabelle umwandelt.
@Table(name = "courses") // Optional: Gibt explizit den Tabellennamen an.
public class Course {

    public Course(){}
    public Course(long Id, String name, int capacity, Trainer trainer) {
        this();
        this.name = name;
        this.capacity = capacity;
        this.id = Id;
        this.trainer = trainer;
    }
    @Id // Definiert das Primärschlüsselfeld.
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    // Automatische ID-Generierung durch die Datenbank.
    private Long id;

    @Column(nullable = false)
    // Setzt die Spalte "name" als nicht-null, also obligatorisch.
    private String name;

    @Column(nullable = false)
    // Setzt die Spalte "capacity" als nicht-null.
    private int capacity;

    @ManyToOne // Viele Kurse gehören zu einem Trainer.
    @JoinColumn(name = "trainer_id", nullable = false)
    // Erstellt eine Fremdschlüsselspalte "trainer_id", die auf die Trainer-Tabelle verweist.
    private Trainer trainer;

    // Getter und Setter
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public int getCapacity() { return capacity; }
    public void setCapacity(int capacity) { this.capacity = capacity; }

    public Trainer getTrainer() { return trainer; }
    public void setTrainer(Trainer trainer) { this.trainer = trainer; }
}
