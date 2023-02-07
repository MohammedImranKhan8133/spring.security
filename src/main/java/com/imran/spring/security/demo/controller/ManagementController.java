package com.imran.spring.security.demo.controller;

import com.imran.spring.security.demo.entity.Student;
import org.checkerframework.checker.units.qual.s;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@Controller
public class ManagementController {
    private static final List<Student> STUDENTS= Arrays.asList(
            new Student(1,"maradona"),
            new Student (2,"messi"),
            new Student(3,"pele"),
            new Student( 4,"ronaldo")
    );

    @GetMapping("test/api/getAll")
    @ResponseBody
    public List<Student> getAllStudent(){
        return STUDENTS;
    }

    @PostMapping("test/api/put")
    @ResponseBody
    public Student putStudent(@RequestBody Student student){
        System.out.println(student);
        return student;
    }

}
