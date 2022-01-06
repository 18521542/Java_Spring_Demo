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
                Product prod1 = new Product("Macbook",2000,"img.com/mac");
                Product prod2 = new Product("Iphone",3000,"img.com/iphone");

                //hard code
                if(!productRepository.existsById(1L)){
                    productRepository.save(prod1);
                    productRepository.save(prod2);
                }
            }
        };
    }
}
