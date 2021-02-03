package com.galvanize.gmdbapi.repository;

import com.galvanize.gmdbapi.model.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieRepository extends JpaRepository<Movie,Long> {

    Movie findByTitle(String title);
}
