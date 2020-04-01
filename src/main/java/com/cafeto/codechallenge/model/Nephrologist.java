package com.cafeto.codechallenge.model;

import org.hibernate.engine.internal.Cascade;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "nephrologist")
public class Nephrologist {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "name")
    private String name;

    @OneToMany(mappedBy = "nephrologist", cascade = {
            CascadeType.ALL
    })
    private List< NephrologistType > nephrologistTypes;

    @Column(name = "email")
    private String email;

    @Column(name = "active")
    private Boolean active;

    public Nephrologist() {

    }

    public Nephrologist(String name, String email, Boolean active) {
        this.name = name;
        this.email = email;
        this.active = active;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public Boolean getActive() {
        return active;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {

        this.email = email;
    }

    public void setActive(Boolean active) {

        this.active = active;
    }

    public List < NephrologistType > getNephrologistTypes() {
        return nephrologistTypes;
    }

    public void setCourses(List < NephrologistType > courses) {
        this.nephrologistTypes = nephrologistTypes;
    }
}
