package com.eduhub.eduhub_backend.controller;

import com.eduhub.eduhub_backend.component.CourseService;
import com.eduhub.eduhub_backend.component.newComponent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class newController {
    @Autowired

     newComponent nc;

//    public newController(newComponent nc){
//        this.nc=nc;
//    }
    @GetMapping("get-component")
    public String getComponent(){
        return nc.getComponent();
    }

}
