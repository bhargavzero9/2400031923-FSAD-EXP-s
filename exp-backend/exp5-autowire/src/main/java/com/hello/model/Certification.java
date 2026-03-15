package com.hello.model;

import org.springframework.stereotype.Component;

@Component
public class Certification {

    private String course = "FSAD";
    private String completionDate = "2026";

    public void displayCertification() {
        System.out.println("Course: " + course);
        System.out.println("Completion Year: " + completionDate);
    }
}