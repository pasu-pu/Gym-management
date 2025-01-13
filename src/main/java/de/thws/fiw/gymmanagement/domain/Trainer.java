package de.thws.fiw.gymmanagement.domain;

import java.util.ArrayList;
import java.util.List;

public class Trainer {
    private Long id;
    private String name;
    private String expertise;
    private List<Course> courses = new ArrayList<>(); // 1-n Beziehung

    // Getter und Setter
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getExpertise() { return expertise; }
    public void setExpertise(String expertise) { this.expertise = expertise; }

    public List<Course> getCourses() { return courses; }
    public void setCourses(List<Course> courses) { this.courses = courses; }
}
