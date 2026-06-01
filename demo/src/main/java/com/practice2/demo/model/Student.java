package com.practice2.demo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data                   // getter,settter
@AllArgsConstructor    // parametrized constructor
@NoArgsConstructor    //default constructor
public class Student {
    private int rno;
    private String sname;
    private String tech;

}
