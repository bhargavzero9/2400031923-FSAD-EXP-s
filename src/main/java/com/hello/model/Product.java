package com.hello.model;

import javax.persistence.*;

@Entity
@Table(name="product")

public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;
    private String description;

    private Double price;

    private int quantity;

    public Product() {}

    public Product(String name, String description, Double price, int quantity) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.quantity = quantity;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String toString() {
        return id + " " + name + " " + description + " " + price + " " + quantity;
    }
}