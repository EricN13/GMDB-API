package com.galvanize.gmdbapi.service;

import com.galvanize.gmdbapi.model.Movie;
import com.galvanize.gmdbapi.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieSevice {
    @Autowired
    MovieRepository movieRepository;
    public Movie add(Movie movie) {
        return movieRepository.save(movie);
    }

    public List<Movie> getAll() {

        return movieRepository.findAll();
    }
}
