package com.JPA.JPAdemo.Service;

import com.JPA.JPAdemo.Dto.StudentDto;
import com.JPA.JPAdemo.Model.Student;
import com.JPA.JPAdemo.Repository.Repo;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
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

    public Student getStudentByRoll(Integer roll) {
        return  r.findById(roll).orElse(new Student());
    }

    public String updateStudent(Student std) {
        r.save(std);
        return "Update Successful";
    }

    public String deleteStudent(Integer roll) {
        r.deleteById(roll);
        return "Successful";
    }

    public String deleteAll() {
        r.deleteAll();
        return "All Students deleted";
    }

    public List<Student> getAllStudentsByTechandRoll(String tech,Integer roll) {
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

    public StudentDto getAllStudentByRoll(Integer roll) {
        Student s1 =r.findById(roll).orElse(new Student( ));
        return convertStudentToDto(s1);
    }
    public StudentDto convertStudentToDto(Student s1){
        StudentDto std = new StudentDto();
        std.setRno(s1.getRno());
        std.setName(s1.getName());
        std.setTech(s1.getTech());
        std.setEmail(s1.getEmail());
        return std;
    }

    public String addStudents(@Valid StudentDto dto) {
        Student std = new Student();
        std.setRno(dto.getRno());
        std.setName(dto.getName());
        std.setTech(dto.getTech());
        std.setEmail(dto.getEmail());
        r.save(std);
        return "Successful";
    }

    public Page<Student> getPageStud(int page, int size) {
        //Pageable pag = PageRequest.of()
        return r.findAll(PageRequest.of(page, size));
    }
}