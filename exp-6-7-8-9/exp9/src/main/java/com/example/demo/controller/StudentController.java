package com.example.demo.controller;

import com.example.demo.exception.InvalidInputException;
import com.example.demo.exception.StudentNotFoundException;
import org.springframework.web.bind.annotation.*;

@RestController
public class StudentController {

    // TEST 1: Student lookup
    @GetMapping("/student/{id}")
    public String getStudent(@PathVariable int id) {

        if (id != 1) {
            throw new StudentNotFoundException("Student not found with id: " + id);
        }

        return "Student Found";
    }

    // TEST 2: Invalid input
    @GetMapping("/test")
    public String test(@RequestParam String input) {
        try {
            int value = Integer.parseInt(input);
            return "Valid number: " + value;
        } catch (Exception e) {
            throw new InvalidInputException("Invalid input: must be a number");
        }
    }
}