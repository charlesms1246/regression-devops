package com.example.regression;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;

@WebMvcTest(HelloController.class)
public class HelloControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testSuccess() throws Exception {
        mockMvc.perform(post("/greet")
                .param("name", "admin"))
                .andExpect(status().is3xxRedirection())
                .andExpect(redirectedUrl("/success"));
    }

    @Test
    public void testFailure() throws Exception {
        mockMvc.perform(post("/greet")
                .param("name", "user"))
                .andExpect(status().isOk())
                .andExpect(view().name("home"))
                .andExpect(model().attributeExists("error"));
    }
}
