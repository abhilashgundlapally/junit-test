package com.spring.test.junittest.controllers;

import com.spring.test.junittest.model.Item;
import com.spring.test.junittest.services.ItemsService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ItemsController {

    private ItemsService service;

    public ItemsController(ItemsService service){
        this.service = service;
    }

    @GetMapping("/items")
    public ResponseEntity<?> getItems(){
        return ResponseEntity.ok(new Item(1 , "Aaron", 1, 1));
    }

    @GetMapping("/api/items")
    public ResponseEntity<?> getItemsApi(@RequestParam(required = false) String item){
        return ResponseEntity.ok(this.service.getItems());
    }

    @GetMapping("/api/jpa/items")
    public ResponseEntity<?> getItemsJpa(){
        return ResponseEntity.ok(this.service.getItemsJpa());
    }
}
