package com.practice2.demo.Controller;

import com.practice2.demo.Service.StudentService;
import com.practice2.demo.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudentController {
    @Autowired
    StudentService s;

    @GetMapping("students")
    public List<Student> getAllStudents(){
        return s.getAllStudents();
    }

    @GetMapping("students/{id}")
    public Student getStudentById(@PathVariable("id") int rollno){
        return s.getStudentById(rollno);
    }
    @PostMapping("addStudent")
    public String addStudent(@RequestBody Student std){
        s.addStudent(std);
        return "Success";
    }

    @PutMapping("updateStudent")
    public String updateStudent(@RequestBody Student std){
        return s.updateStudent(std);
//        return "Update successful";
    }
    @DeleteMapping("deleteStudent/{id}")
    public String deleteStudent(@PathVariable("id")int roll){
        return s.deleteStudent(roll);
    }
}
