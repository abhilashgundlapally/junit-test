package com.spring.test.junittest.services;


import com.spring.test.junittest.model.Item;
import com.spring.test.junittest.respository.ItemsRepository;

import java.util.List;

public class ItemsService {

    private ItemsRepository repository;
    public ItemsService(ItemsRepository repository) {
        this.repository = repository;
    }

    public Item getItems(){
        return new Item(1, "Aaron", 1, 1);
    }

    public List<Item> getItemsJpa(){
        List<Item> items = this.repository.findAll();
        for (Item item: items){
            item.setValue(item.getPrice() * item.getQuantity());
        }
        return items;
    }
}
