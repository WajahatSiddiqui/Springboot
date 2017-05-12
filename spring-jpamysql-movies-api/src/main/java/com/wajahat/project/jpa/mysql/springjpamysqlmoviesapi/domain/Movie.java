package com.wajahat.project.jpa.mysql.springjpamysqlmoviesapi.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Created by wajahat on 12/5/17.
 */
@Entity
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long Id;

    private String name;
    private int year;

    Movie() {}

    public Movie(Long id, String name, int year) {
        Id = id;
        this.name = name;
        this.year = year;
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "Id=" + Id +
                ", name='" + name + '\'' +
                ", year=" + year +
                '}';
    }
}
