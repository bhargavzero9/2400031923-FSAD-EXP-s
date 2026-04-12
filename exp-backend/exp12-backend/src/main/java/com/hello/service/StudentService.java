package com.hello.service;

import com.hello.model.Student;
import com.hello.repository.StudentRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class StudentService {

    @Autowired
    StudentRepository repo;

    public List<Student> getStudents(){
        return repo.findAll();
    }

    public void addStudent(Student s){
        repo.save(s);
    }

    public void deleteStudent(Long id){
        repo.delete(id);
    }

    public void updateStudent(Student s){
        repo.update(s);
    }
}