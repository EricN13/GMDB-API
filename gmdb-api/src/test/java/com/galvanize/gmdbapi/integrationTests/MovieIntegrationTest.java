package com.galvanize.gmdbapi.integrationTests;

import com.fasterxml.jackson.databind.ObjectMapper;
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

        Movie movie= new Movie("arrow","Bob");
        String postedMovie=mapper.writeValueAsString(movie);

        mockMvc.perform(post("/movie")
                .contentType(MediaType.APPLICATION_JSON)
                .content(postedMovie))
                .andExpect(status().isCreated());
    }
    @Test
    public void getAllMovies() throws Exception {
        mockMvc.perform(get("/movies"))
                .andExpect(status().isOk()).andReturn();

    }
    }


