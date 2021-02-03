package com.galvanize.gmdbapi.integrationTests;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.galvanize.gmdbapi.exception.NotExistMovieException;
import com.galvanize.gmdbapi.model.Movie;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
public class MovieIntegrationTest {
    private ObjectMapper mapper;
    @BeforeEach
    public void init(){
        mapper=new ObjectMapper();
    }


    @Autowired
    MockMvc mockMvc;

    @Test
    public void addMovie() throws Exception {

        Movie movie= new Movie("The Avenger1", "Joss Whedon", "Robert Downey Jr.," +
                " Chris Evans, Mark Ruffalo, Chris Hemsworth", "2002",
                "Earth's mightiest heroes must come together and learn to fight as a team if they are going to stop the mischievous Loki and his alien army from enslaving humanity.", "5");

        String postedMovie=mapper.writeValueAsString(movie);

        mockMvc.perform(post("/movie")
                .contentType(MediaType.APPLICATION_JSON)
                .content(postedMovie))
                .andExpect(status().isCreated());
    }
    @Test
    public void getAllMovies() throws Exception {
        mockMvc.perform(get("/movies"))
                .andExpect(status().isOk());

    }
    @Test
    public void getMovieDetails() throws Exception {
        Movie movie = new Movie("The Avengers", "Joss Whedon", "Robert Downey Jr.," +
                " Chris Evans, Mark Ruffalo, Chris Hemsworth", "2002",
                "Earth's mightiest heroes must come together and learn to fight as a team if they are going to stop the mischievous Loki and his alien army from enslaving humanity.", "5");

        String postedMovie=mapper.writeValueAsString(movie);
        String title= movie.getTitle();

        mockMvc.perform(post("/movie")
                .contentType(MediaType.APPLICATION_JSON)
                .content(postedMovie))
                .andExpect(status().isCreated());

        mockMvc.perform(get("/movie"+title))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.title").value("The Avengers"))
                .andExpect(jsonPath("$.director").value("Joss Whedon"))
                .andExpect(jsonPath("$.actors").value("Robert Downey Jr.," +
                        " Chris Evans, Mark Ruffalo, Chris Hemsworth"))
                .andExpect(jsonPath("$.release").value("2002"))
                .andExpect(jsonPath("$.description").value("Earth's mightiest heroes must come together and learn to fight as a team if they are going to stop the mischievous Loki and his alien army from enslaving humanity."))
                .andExpect(jsonPath("$.rating").value("5")).andReturn();

    }

//    @Test
//    public void displayErrorMessageForNoExistingTitle() throws Exception {
//        Movie movie = new Movie("The Avengers", "Joss Whedon", "Robert Downey Jr.," +
//                " Chris Evans, Mark Ruffalo, Chris Hemsworth", "2002",
//                "Earth's mightiest heroes must come together and learn to fight as a team if they are going to stop the mischievous Loki and his alien army from enslaving humanity.", "5");
//
//        String postedMovie=mapper.writeValueAsString(movie);
//        Movie movie1=new Movie("The war", "Joss Whedon", "Robert Downey Jr.," +
//                " Chris Evans, Mark Ruffalo, Chris Hemsworth", "2002",
//                "Earth's mightiest heroes must come together and learn to fight as a team if they are going to stop the mischievous Loki and his alien army from enslaving humanity.", "5");
//
//        mockMvc.perform(post("/movie")
//                .contentType(MediaType.APPLICATION_JSON)
//                .content(postedMovie))
//                .andExpect(status().isCreated());
//
//        NotExistMovieException exception = assertThrows(NotExistMovieException.class,()->movie1.getTitle());
//        assertEquals("Movie doesn't exist",exception.getMessage());
//

//
//    }

    }



