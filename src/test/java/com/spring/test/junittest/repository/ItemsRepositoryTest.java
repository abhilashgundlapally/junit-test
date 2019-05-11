package com.spring.test.junittest.repository;

import com.spring.test.junittest.JunitTestApplication;
import com.spring.test.junittest.model.Item;
import com.spring.test.junittest.respository.ItemsRepository;
import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.AutoConfigureDataJpa;
import org.springframework.boot.test.autoconfigure.orm.jpa.AutoConfigureTestEntityManager;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = {JunitTestApplication.class})
@ActiveProfiles("test")
@AutoConfigureDataJpa
public class ItemsRepositoryTest {

    @Autowired
    private ItemsRepository repository;

    @Test
    public void getAll(){
        List<Item> items = this.repository.findAll();
        assertEquals(3,items.size());
    }

}