package com.cafeto.codechallenge.model;

import javax.persistence.*;

@Entity
@Table(name = "nephrologisttype")
public class NephrologistType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "description")
    private String description;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "nephrologist_id")
    private Nephrologist nephrologist;

    public NephrologistType() {

    }

    public NephrologistType(String description) {
        this.description = description;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setDescription(String description) {

        this.description = description;
    }

    public long getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public Nephrologist getNephrologist() {
        return nephrologist;
    }

    public void setNephrologist(Nephrologist nephrologist) {
        this.nephrologist = nephrologist;
    }

    @Override
    public String toString() {
        return "NephrologistType [id=" + id + ", description=" + description + "]";
    }

}
