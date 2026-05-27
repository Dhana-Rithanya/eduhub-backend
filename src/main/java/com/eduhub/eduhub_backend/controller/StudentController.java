package com.eduhub.eduhub_backend.controller;

import com.eduhub.eduhub_backend.component.Student;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class StudentController {

//    http://localhost:8080/Student
    @GetMapping("Student")
    public ResponseEntity<Student> getStudent(){
        Student student = new Student(1,"abi","shree");
        return new ResponseEntity<>(student, HttpStatus.OK);
    }

//    http://localhost:8080/students
   @GetMapping("students")
    public ResponseEntity<List<Student>> getStudents(){
        List<Student> studentList = new ArrayList<>();
        studentList.add(new Student(2,"dhana","rithanya"));
       studentList.add(new Student(3,"dhivya","v"));
       return new ResponseEntity<>(studentList,HttpStatus.OK);
   }

//   http://localhost:8080/2/dhana/rithanya
    @GetMapping("{id}/{first-name}/{last-name}")
    public ResponseEntity<Student> studentPathVariable(@PathVariable("id") int id,
                                                       @PathVariable("first-name") String firstName,
                                                       @PathVariable("last-name") String lastName){
        Student student = new Student(id,firstName,lastName);
        return new ResponseEntity<>(student,HttpStatus.OK);
    }

//   http://localhost:8080/2/fn=dhana/ln=rithanya
    @GetMapping("query")
    public ResponseEntity<Student> studentRequestParam(@RequestParam int id,
                                                       @RequestParam String firstName,
                                                       @RequestParam String lastName){
        Student student = new Student(id,firstName,lastName);
        return new ResponseEntity<>(student,HttpStatus.OK);
    }

    @PostMapping("create")
    public ResponseEntity<Student> createStudent(@RequestBody Student student){
        System.out.println(student.getId());
        System.out.println(student.getFirstName());
        System.out.println(student.getLastName());
        return ResponseEntity.ok(student);
    }

    @PutMapping("{id}/update")
    public ResponseEntity updateStudent(@PathVariable("id") int students,@RequestBody Student student){
        return ResponseEntity.accepted().body(student);
    }

//    @DeleteMapping("{id}/delete")
//    public ResponseEntity deleteStudent(@PathVariable("id") int s_id){
//
//    }
}
