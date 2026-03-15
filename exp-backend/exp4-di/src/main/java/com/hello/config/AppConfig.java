package com.hello.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.hello.model.Student;

@Configuration
public class AppConfig {

    @Bean
    public Student student() {

        // Constructor Injection
        Student student = new Student(101, "Bhargav");

        // Setter Injection
        student.setCourse("FSAD");
        student.setYear("2026");

        return student;
    }
}