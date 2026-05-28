package com.eduhub.eduhub_backend.controller;

import com.eduhub.eduhub_backend.component.Course;
import com.eduhub.eduhub_backend.exceptions.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
@RestController
public class CController {
    static List<Course> courseList = new ArrayList<>();

    static {
        courseList.add(new Course(202,"Full Stack",4));
        courseList.add(new Course(99,"Maths",3));
        courseList.add(new Course(101,"DBMS",4));
        courseList.add(new Course(249,"DS",2));
        courseList.add(new Course(304,"Java",3));
    }

//    public CController() {
//        courseList.add(new Course(202,"Full Stack",4));
//        courseList.add(new Course(99,"Maths",3));
//        courseList.add(new Course(101,"DBMS",4));
//        courseList.add(new Course(249,"DS",2));
//        courseList.add(new Course(304,"Java",3));
//    }
//    @GetMapping("courses")
//    public ResponseEntity<List<Course>> getCourses(){
//        return new ResponseEntity<>(courseList, HttpStatus.OK);
//    }
//    @GetMapping("course/{id}")
//    public ResponseEntity<Course> getCoursePathVariable(@PathVariable("id") int courseCode){
//        for(Course c : courseList){
//            if(c.getCourseCode()==courseCode){
//                return new ResponseEntity<>(c,HttpStatus.OK);
//            }
//        }
//        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//    }
//    @GetMapping("search")
//    public ResponseEntity<Course> courseRequestParam(@RequestParam int id){
//        for(Course c : courseList){
//            if(c.getCourseCode()==id){
//                return new ResponseEntity<>(c,HttpStatus.OK);
//            }
//        }
//        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//    }
//    @PostMapping("newCourse")
//    public ResponseEntity<String> createCourse(@RequestBody Course course){
//        courseList.add(course);
//        return new ResponseEntity<>("Course added",HttpStatus.OK);
//    }
//    @PutMapping("updateCourse/{courseCode}")
//    public ResponseEntity<String> updateCourse(@PathVariable int courseCode, @RequestBody Course Ucourse){
//        for(Course c : courseList) {
//            if (c.getCourseCode() == courseCode) {
//                c.setSubjectName(Ucourse.getSubjectName());
//                c.setCredits(Ucourse.getCredits());
//                return new ResponseEntity<>("Course Updated", HttpStatus.OK);
//            }
//        }
//        return new ResponseEntity<>("Course not fount", HttpStatus.NOT_FOUND);
//    }
//    @DeleteMapping("deleteCourse/{code}")
//    public ResponseEntity<String> deleteCourse(@PathVariable int code){
//        for(Course c : courseList){
//            if(c.getCourseCode()==code) {
//                courseList.remove(c);
//                return new ResponseEntity<>("Deleted successfully", HttpStatus.OK);
//
//            }
//        }
//        return new ResponseEntity<>("Course not fount", HttpStatus.NOT_FOUND);
//
//    }
    @GetMapping("course")
    public ResponseEntity<List<Course>> getCourse() {
        return ResponseEntity.ok(courseList);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Course> getCourseById(
            @PathVariable int id) {

        Course course = courseList.stream()
                .filter(c -> c.getCourseCode() == id)
                .findFirst()
                .orElseThrow(() ->
                        new ResourceNotFoundException("Course", "id", String.valueOf(id))
                );

        return ResponseEntity.ok(course);
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<Course> updateCourse(
            @PathVariable int id,
            @RequestBody Course updatedCourse) {

        Course course = courseList.stream()
                .filter(c -> c.getCourseCode() == id)
                .findFirst()
                .orElseThrow(() ->
                        new ResourceNotFoundException("Course", "id", String.valueOf(id))
                );

        course.setSubjectName(updatedCourse.getSubjectName());
        course.setCredits(updatedCourse.getCredits());

        return ResponseEntity.ok(course);
    }
    @DeleteMapping("course/{id}")
    public ResponseEntity<String> deleteCourse(
            @PathVariable int id) {

        Course course = courseList.stream()
                .filter(c -> c.getCourseCode() == id)
                .findFirst()
                .orElseThrow(() ->
                        new ResourceNotFoundException("Course", "id", String.valueOf(id))
                );

        courseList.remove(course);

        return ResponseEntity.ok("Course deleted successfully");
    }
    @PutMapping("/query/{code}")
    public String queryCourse(@PathVariable String code) throws Exception {
        if(code.startsWith("*")){
            throw new IllegalAccessException("It is having a special character");
        } else if (code.startsWith("6")) {
            throw new Exception();

        }
        return code;
    }
}
