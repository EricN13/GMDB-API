package com.galvanize.gmdbapi.service;

import com.galvanize.gmdbapi.exception.NotExistMovieException;
import com.galvanize.gmdbapi.model.Movie;
import com.galvanize.gmdbapi.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class MovieService {
    @Autowired
    MovieRepository movieRepository;

    public Movie add(Movie movie) {
        return movieRepository.save(movie);
    }

    public List<Movie> getAll() {

        return movieRepository.findAll();
    }

    public Movie getMovieByTitle(String title) throws Exception {
        Movie movieData=this.movieRepository.findByTitle(title);
        if(movieData.getTitle().equals(title)){
            return movieData;

        }else{
            throw new NotExistMovieException("Movie Doesn't exist");
        }
    }

    public Movie setRating(String title, Movie movie) {
        String rating=movie.getRating();
        Movie movieData = this.movieRepository.findByTitle(title);
            movie.setRating(rating);
            return this.movieRepository.save(movie);

        }

}
