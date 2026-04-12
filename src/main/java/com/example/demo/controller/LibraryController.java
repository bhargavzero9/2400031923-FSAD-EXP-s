package com.example.demo.controller;

import com.example.demo.model.Book;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class LibraryController {

    List<Book> bookList = new ArrayList<>();

    // 1. /welcome
    @GetMapping("/welcome")
    public String welcome() {
        return "Welcome to Library API";
    }

    // 2. /count
    @GetMapping("/count")
    public int countBooks() {
        return bookList.size();
    }

    // 3. /price
    @GetMapping("/price")
    public double getPrice() {
        return 499.99;
    }

    // 4. /books
    @GetMapping("/books")
    public List<String> getBooks() {
        List<String> titles = new ArrayList<>();
        for (Book b : bookList) {
            titles.add(b.getTitle());
        }
        return titles;
    }

    // 5. /books/{id}
    @GetMapping("/books/{id}")
    public Book getBookById(@PathVariable int id) {
        for (Book b : bookList) {
            if (b.getId() == id) {
                return b;
            }
        }
        return null;
    }

    // 6. /search?keyword=java
    @GetMapping("/search")
    public String search(@RequestParam String keyword) {
        return "You searched for: " + keyword;
    }

    // 7. /author/{name}
    @GetMapping("/author/{name}")
    public String getAuthor(@PathVariable String name) {
        return "Books by author: " + name;
    }

    // 8. POST /addbook
    @PostMapping("/addbook")
    public String addBook(@RequestBody Book book) {
        bookList.add(book);
        return "Book added successfully";
    }

    // 9. /viewbooks
    @GetMapping("/viewbooks")
    public List<Book> viewBooks() {
        return bookList;
    }
}