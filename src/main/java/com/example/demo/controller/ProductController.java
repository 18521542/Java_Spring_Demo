package com.example.demo.controller;

import com.example.demo.model.Product;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "/api/hello")
public class ProductController {

    @GetMapping("")
    List<Product> Hello(){
        return List.of(
            new Product(1L, "Macbook", 2000, "bsdhfjsd.com/sadas"),
            new Product(2L, "Iphone", 1000, "bsdhfjsd.com/iphone")
        );
    }
}
