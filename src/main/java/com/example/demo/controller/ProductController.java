package com.example.demo.controller;

import com.example.demo.model.CustomResponse;
import com.example.demo.model.Product;
import com.example.demo.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping
    ResponseEntity<CustomResponse> insertProduct(@RequestBody Product newProduct){
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(new CustomResponse("OK", "Product Created!", repository.save(newProduct)));
    }

    @DeleteMapping("/{id}")
    ResponseEntity<CustomResponse> updateProduct(@PathVariable Long id){
        boolean isProductExist = repository.existsById(id);
        if(isProductExist){
            repository.deleteById(id);
            String result = "Delete product with id = "+ id;
            return ResponseEntity.status(HttpStatus.OK)
                    .body(new CustomResponse("OK","Product Deleted!",result));
        }
        return ResponseEntity.status(HttpStatus.OK)
                .body(new CustomResponse("OK","Product not found!",null));
    }
}
