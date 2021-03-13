package com.example.Cryptozoology;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.awt.*;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class ZooTestIT {
    @Autowired
    MockMvc mockMvc;

    @Autowired
    ObjectMapper objectMapper;

    @Test
        public void addAnimalsTest() throws Exception {
        mockMvc.perform(post("/animal").contentType(MediaType.APPLICATION_JSON).content("{}")
        ).andExpect(status().isCreated());


        }

    @Test
    public void getAnimalsTest() throws Exception{
        AnimalDto animalDto = new AnimalDto("Cat","walking");

        mockMvc.perform(post("/animal")
                .content(objectMapper.writeValueAsString(animalDto))
                .contentType(MediaType.APPLICATION_JSON)
        ).andExpect(status().isCreated()
        );
        mockMvc.perform(get("/animal")
        ).andExpect(status().isOk())
                .andExpect(jsonPath("length()").value(1))
                .andExpect(jsonPath("[0].name").value("Cat"))
                .andExpect(jsonPath("[0].type").value("walking"));
    }


}
