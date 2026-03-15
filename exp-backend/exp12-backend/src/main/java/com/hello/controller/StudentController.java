package com.hello.controller;

import com.hello.model.Student;
import com.hello.service.StudentService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class StudentController {

    @Autowired
    StudentService service;

    @GetMapping("/students")
    public List<Student> getStudents(){
        return service.getStudents();
    }

    @PostMapping("/students")
    public void addStudent(@RequestBody Student s){
        service.addStudent(s);
    }

    @DeleteMapping("/students/{id}")
    public void deleteStudent(@PathVariable Long id){
        service.deleteStudent(id);
    }

    @PutMapping("/students")
    public void updateStudent(@RequestBody Student s){
        service.updateStudent(s);
    }
}