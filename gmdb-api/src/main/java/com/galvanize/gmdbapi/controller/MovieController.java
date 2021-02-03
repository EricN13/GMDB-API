package com.galvanize.gmdbapi.controller;

import com.galvanize.gmdbapi.model.Movie;
import com.galvanize.gmdbapi.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MovieController {
    @Autowired
    MovieService movieService;

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
    public Movie getMovieByTitle(@PathVariable String title) throws Exception {
        return this.movieService.getMovieByTitle(title);

    }
    @PutMapping("/movie{title}")
    public Movie ratingAMovie(@PathVariable String title, @RequestBody Movie movie) throws Exception {
        return this.movieService.setRating(title,movie);
    }
}
