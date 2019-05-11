package com.spring.test.junittest.controller;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

import com.spring.test.junittest.JunitTestApplication;
import com.spring.test.junittest.controllers.HelloController;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = JunitTestApplication.class)
@WebMvcTest(HelloController.class)
@ActiveProfiles("test")
public class HelloControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void helloworld_basic() throws Exception {
        mockMvc.perform(get("/hello")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().is2xxSuccessful())
                .andExpect(content().string("HelloWorld!"))
                .andReturn();
    }
}
