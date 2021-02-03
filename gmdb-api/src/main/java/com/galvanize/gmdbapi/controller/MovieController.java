package com.galvanize.gmdbapi.controller;

import com.galvanize.gmdbapi.model.Movie;
import com.galvanize.gmdbapi.service.MovieSevice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MovieController {
    @Autowired
    MovieSevice movieService;

    @PostMapping("/movie")
    @ResponseStatus(HttpStatus.CREATED)
    public void createMovie(@RequestBody Movie movie){
        movieService.add(movie);

    }
    @GetMapping("/movies")
    public List<Movie> getAllMovies(){
        return movieService.getAll();

    }

    @GetMapping("/movie{title}")
    public Movie getMovieByTitle(@PathVariable String title){
        return this.movieService.getMovieByTitle(title);

    }

}
