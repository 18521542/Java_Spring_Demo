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

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", Name='" + Name + '\'' +
                ", price=" + price +
                ", imageURL='" + imageURL + '\'' +
                '}';
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return Name;
    }

    public int getPrice() {
        return price;
    }

    public String getImageURL() {
        return imageURL;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        Name = name;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }
}
