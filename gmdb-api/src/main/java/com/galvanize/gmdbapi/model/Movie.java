package com.galvanize.gmdbapi.model;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String title;
    private String actor;
    public Movie(){}


    public Movie(String title, String actor) {
        this.title=title;
        this.actor=actor;
    }
}
