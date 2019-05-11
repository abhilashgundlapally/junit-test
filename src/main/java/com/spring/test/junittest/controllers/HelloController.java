package com.spring.test.junittest.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    public HelloController(){

    }

    @GetMapping("/hello")
    public ResponseEntity<?> getHello(){
        return ResponseEntity.ok("HelloWorld!");
    }
}
