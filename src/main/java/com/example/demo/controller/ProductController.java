package com.example.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "/api/hello")
public class ProductController {

    @GetMapping("")
    List<String> Hello(){
        return List.of("Test", "Test2", "Test3");
    }
}
