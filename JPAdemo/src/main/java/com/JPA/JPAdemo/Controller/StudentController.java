package com.JPA.JPAdemo.Controller;

import com.JPA.JPAdemo.Model.Student;
import com.JPA.JPAdemo.Service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
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
    @PostMapping("students")
    public String addStudent(@RequestBody Student std){
        return s.addStudent(std);
    }
    @GetMapping("students/{id}")
    public Student getStudentByRollno(@PathVariable("id") int roll){
        return s.getStudentByRoll(roll);
    }
    @PutMapping("updateStudent")
    public String updateStudent(@RequestBody Student std){
        return s.updateStudent(std);
    }
    @DeleteMapping("deleteStudent/{id}")
    public String deleteStudent(@PathVariable("id") int roll){
        return s.deleteStudent(roll);
    }
    @DeleteMapping("students")
    public String deleteAllStudents(){
        return s.deleteAll();
    }

    @GetMapping("students/custom")
    public List<Student> getStudentByCustom(@Param("tech") String tech,@Param("rno") int roll){
        return  s.getAllStudentsByTechandRoll(tech,roll);
    }
    @GetMapping("student/{tech}")
    public List<Student> getStudentByTech(@PathVariable("tech") String tech){
        return s.getStudentByTech(tech);
    }
    //query write pandra naala post mapping
    @PostMapping("students/filter")
    public List<Student> getStudentByNameAndTech(@Param("name") String name , @Param("tech") String tech){
        return s.getAllStudentsByNameAndTech(name,tech);
    }
    @PostMapping("/students/byjpql")
    public List<Student>getstudentbyjpql(@Param("name") String name)
    {
        return s.getstudentbyjpql(name);
    }
}