package de.thws.fiw.gymmanagement.domain;

import jakarta.persistence.*;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity // Markiert diese Klasse als eine JPA-Entity.
@Table(name = "members") // Optional: Gibt den Tabellennamen an.
public class Member {

    public Member(){}
    public Member(long Id, String name, String membershipType) {
        this();
        this.name = name;
        this.membershipType = membershipType;
        this.id = Id;
    }

    @Id // Definiert das Primärschlüsselfeld.
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    // Automatische ID-Generierung durch die Datenbank.
    private Long id;

    @Column(nullable = false) // Setzt die Spalte "name" als nicht-null.
    private String name;

    @Column(nullable = false) // Setzt die Spalte "membershipType" als nicht-null.
    private String membershipType;


    // Getter und Setter
    public Long getId() { return id; }
    //public void setId(Long id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getMembershipType() { return membershipType; }
    public void setMembershipType(String membershipType) { this.membershipType = membershipType; }
}
