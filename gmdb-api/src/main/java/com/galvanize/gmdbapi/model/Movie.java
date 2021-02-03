package com.galvanize.gmdbapi.model;


import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String title;
    private String director;
    private String actors;
    private String release;
    private String description;
    private String rating;



    public Movie( String title,String director,String actors,String release,String description,String rating) {
    this.title=title;
    this.director=director;
    this.actors=actors;
    this.release=release;
    this.description=description;
    this.rating=rating;
    this.actors=actors;
    }
    public Movie(){

    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getDirector() {
        return director;
    }

    public String getActors() {
        return actors;
    }

    public String getRelease() {
        return release;
    }

    public String getDescription() {
        return description;
    }

    public String getRating() {
        return rating;
    }
}
