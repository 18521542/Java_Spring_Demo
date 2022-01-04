package com.example.demo.controller;

import com.example.demo.model.CustomResponse;
import com.example.demo.model.Product;
import com.example.demo.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/api/Product")
public class ProductController {

    @Autowired
    private ProductRepository repository;

    @GetMapping("")
    List<Product> Hello(){
        return repository.findAll();
    }

    @GetMapping("/{id}")
    CustomResponse findProductById(@PathVariable Long id){
        try {
            Optional<Product> foundProduct = repository.findById(id);
            return foundProduct.isPresent() ?
                    (new CustomResponse("OK", "Product Found!", foundProduct))
                    :
                    (new CustomResponse("failed", "Product not found!", null));
        }
        catch (RuntimeException e){
            return new CustomResponse("failed", "Product not found!", null);
        }
    }
}
