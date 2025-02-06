package de.thws.fiw.gymmanagement.domain;

import java.util.ArrayList;
import java.util.List;
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

    // Getter und Setter
    public Long getId() { return id; }
    //public void setId(Long id) { this.id = id; } nicht benötigt weil sich hibernate darum kuemmert

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getExpertise() { return expertise; }
    public void setExpertise(String expertise) { this.expertise = expertise; }

}
