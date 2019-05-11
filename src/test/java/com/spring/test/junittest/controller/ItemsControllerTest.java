package com.spring.test.junittest.controller;

import com.spring.test.junittest.JunitTestApplication;
import com.spring.test.junittest.controllers.ItemsController;
import com.spring.test.junittest.model.Item;
import com.spring.test.junittest.respository.ItemsRepository;
import com.spring.test.junittest.services.ItemsService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.Arrays;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = JunitTestApplication.class)
@WebMvcTest(ItemsController.class)
@ActiveProfiles("test")
public class ItemsControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ItemsService service;

    @MockBean
    private ItemsRepository repository;

    @Test
    public void getItems() throws Exception {
        mockMvc.perform(get("/items").accept(MediaType.APPLICATION_JSON))
                .andExpect(status().is2xxSuccessful())
                .andExpect(content().json("{\"id\":1,\"name\":\"Aaron\",\"price\":1,\"quantity\":1}"))
                .andReturn();
    }

    @Test
    public void getItemsApi() throws Exception {
        when(service.getItems()).thenReturn(new Item(1, "Aaron", 1, 1));
        mockMvc.perform(get("/api/items")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().is2xxSuccessful())
                .andExpect(content().json("{\"id\":1,\"name\":\"Aaron\",\"price\":1,\"quantity\":1}"))
                .andReturn();
    }

    @Test
    public void getItemsJpaApi() throws Exception{
        when(service.getItemsJpa()).thenReturn(Arrays.asList(new Item(1,"Aaron",1,1),
                new Item(2,"Assange",2,2),
                new Item(3, "Steve", 3, 3)));
        mockMvc.perform(get("/api/jpa/items")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().is2xxSuccessful())
                .andExpect(content().json("[{\"id\":1,\"name\":\"Aaron\",\"price\":1,\"quantity\":1},{\"id\":2,\"name\":\"Assange\",\"price\":2,\"quantity\":2},{\"id\":3,\"name\":\"Steve\",\"price\":3,\"quantity\":3}]"))
                .andReturn();
    }
}
