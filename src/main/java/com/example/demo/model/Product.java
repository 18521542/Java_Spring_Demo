package com.example.demo.model;

public class Product {
    private Long id;
    private String Name;
    private int price;
    private String imageURL;

    public Product(){};

    public Product(Long id, String name, int price, String imageURL) {
        this.id = id;
        Name = name;
        this.price = price;
        this.imageURL = imageURL;
    }
}
