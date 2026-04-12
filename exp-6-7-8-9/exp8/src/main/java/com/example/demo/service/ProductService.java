package com.example.demo.service;

import com.example.demo.model.Product;
import com.example.demo.repository.ProductRepository;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    private final ProductRepository repo;

    public ProductService(ProductRepository repo) {
        this.repo = repo;
    }

    public Product save(Product p) {
        return repo.save(p);
    }

    public List<Product> getByCategory(String category) {
        return repo.findByCategory(category);
    }

    public List<Product> getByPriceRange(double min, double max) {
        return repo.findByPriceBetween(min, max);
    }

    public List<Product> getSorted() {
        return repo.sortByPrice();
    }

    public List<Product> getExpensive(double price) {
        return repo.expensiveProducts(price);
    }
}