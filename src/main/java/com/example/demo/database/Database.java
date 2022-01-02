package com.example.demo.database;

import com.example.demo.model.Product;
import com.example.demo.repositories.ProductRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Database {

    @Bean
    CommandLineRunner initDatabase(ProductRepository productRepository){
        return new CommandLineRunner() {
            @Override
            public void run(String... args) throws Exception {
                Product prod1 = new Product(1L,"Macbook",2000,"img.com/mac");
                Product prod2 = new Product(2L,"Iphone",3000,"img.com/iphone");
                productRepository.save(prod1);
                productRepository.save(prod2);
            }
        };
    }
}
