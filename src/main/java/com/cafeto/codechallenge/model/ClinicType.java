package com.cafeto.codechallenge.model;

import javax.persistence.*;

@Entity
@Table(name = "clinictype")
public class ClinicType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "name")
    private String name;

    public ClinicType() {
        super();
    }

    public ClinicType(long id, String name) {
        super();
        this.id = id;
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }
}
