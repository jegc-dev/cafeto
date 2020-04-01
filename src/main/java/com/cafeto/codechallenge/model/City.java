package com.cafeto.codechallenge.model;

import javax.persistence.*;

@Entity
@Table(name = "city")
public class City {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "description")
    private String description;

    public City() {
        super();
    }

    public City(long id, String description) {
        super();
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

    @Override
    public String toString(){
        return "{\"" + this.id + "\",\"" + this.description + "\"";
    }
}
