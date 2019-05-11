package com.spring.test.junittest.service;

import com.spring.test.junittest.model.Item;
import com.spring.test.junittest.respository.ItemsRepository;
import com.spring.test.junittest.services.ItemsService;
import org.junit.Test;
import org.junit.runner.RunWith;
import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Arrays;
import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class ItemsServiceTest {

    @InjectMocks
    private ItemsService service;

    @Mock
    private ItemsRepository repository;

    @Test
    public void getItem(){
        assertEquals(new Item(1,"Aaron",1,1).getName(),service.getItems().getName());
    }

    @Test
    public void getItemsJpa(){
        when(repository.findAll()).thenReturn(Arrays.asList(new Item(1,"Aaron",1,1),
                new Item(2,"Assange",2,2),
                new Item(3, "Steve", 3, 3)));
        List<Item> itemList = service.getItemsJpa();
        assertEquals(1, itemList.get(0).getValue());
        assertEquals(4, itemList.get(1).getValue());
        assertEquals(9, itemList.get(2).getValue());
    }
}
