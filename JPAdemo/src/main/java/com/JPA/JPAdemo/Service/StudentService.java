package com.JPA.JPAdemo.Service;

import com.JPA.JPAdemo.Model.Student;
import com.JPA.JPAdemo.Repository.Repo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    @Autowired
    Repo r;
    public List<Student> getAllStudents(){
        return r.findAll();
    }

    public String addStudent(Student std) {
        r.save(std);
        return "Successful";
    }

    public Student getStudentByRoll(int roll) {
        return  r.findById(roll).orElse(new Student());
    }

    public String updateStudent(Student std) {
        r.save(std);
        return "Update Successful";
    }

    public String deleteStudent(int roll) {
        r.deleteById(roll);
        return "Successful";
    }

    public String deleteAll() {
        r.deleteAll();
        return "All Students deleted";
    }

    public List<Student> getAllStudentsByTechandRoll(String tech,int roll) {
        return r.findByTechAndRno(tech,roll);
    }

    public List<Student> getStudentByTech(String tech) {
        return r.findByTech(tech);
    }

    public List<Student> getAllStudentsByNameAndTech(String name, String tech) {
        return r.findByNameAndTech(name,tech);
    }

    public List<Student> getstudentbyjpql(String name) {
        return r.findbyName(name);
    }
}