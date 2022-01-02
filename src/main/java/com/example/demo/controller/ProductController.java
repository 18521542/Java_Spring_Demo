package com.example.demo.controller;

import com.example.demo.model.Product;
import com.example.demo.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "/api/hello")
public class ProductController {

    @Autowired
    private ProductRepository repository;

    @GetMapping("")
    List<Product> Hello(){
        return repository.findAll();
    }
}
