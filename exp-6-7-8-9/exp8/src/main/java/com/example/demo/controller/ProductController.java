package com.example.demo.controller;

import com.example.demo.model.Product;
import com.example.demo.service.ProductService;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    private final ProductService service;

    public ProductController(ProductService service) {
        this.service = service;
    }

    @PostMapping
    public Product add(@RequestBody Product p) {
        return service.save(p);
    }

    @GetMapping("/category/{category}")
    public List<Product> byCategory(@PathVariable String category) {
        return service.getByCategory(category);
    }

    @GetMapping("/filter")
    public List<Product> byPrice(@RequestParam double min, @RequestParam double max) {
        return service.getByPriceRange(min, max);
    }

    @GetMapping("/sorted")
    public List<Product> sorted() {
        return service.getSorted();
    }

    @GetMapping("/expensive/{price}")
    public List<Product> expensive(@PathVariable double price) {
        return service.getExpensive(price);
    }
}