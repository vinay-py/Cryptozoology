package com.example.Cryptozoology;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.awt.*;
@SpringBootTest

public class ZooTestIT {
    @Autowired
    MockMvc mockMvc;

    @Test
        public void addAnimalsTest() {
        mockMvc.perform(post("/animal").contentType(MediaType.APPLICATION_JSON).content("")
        ).andExpect(status().isCreated());


        }


}
