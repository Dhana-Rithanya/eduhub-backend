package com.eduhub.eduhub_backend.controller;

import com.eduhub.eduhub_backend.component.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CourseController {
  //  @Autowired
    CourseService courseService;

    public CourseController(CourseService courseService){
        this.courseService=courseService;
    }

    @GetMapping("get-course")

    public String getCourse(){
        return courseService.getCourse();
    }

}