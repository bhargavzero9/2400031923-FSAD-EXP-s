package com.hello.repository;

import com.hello.model.Student;
import org.springframework.stereotype.Repository;
import java.util.*;

@Repository
public class StudentRepository {

    private List<Student> students = new ArrayList<>();

    public List<Student> findAll(){
        return students;
    }

    public void save(Student s){
        students.add(s);
    }

    public void delete(Long id){
        students.removeIf(st -> st.getId().equals(id));
    }

    public void update(Student student){
        for(Student s:students){
            if(s.getId().equals(student.getId())){
                s.setName(student.getName());
                s.setEmail(student.getEmail());
                s.setCourse(student.getCourse());
            }
        }
    }
}