package com.imran.spring.security.demo.controller;

import com.imran.spring.security.demo.entity.Student;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Controller
public class SecurityController {
    @GetMapping("/")
    @ResponseBody
    public String testSecurity(){
        return "normal page";
    }
    @GetMapping("/test")
    @ResponseBody
    public String firstpage(){
        return "security Page first";
    }

    @GetMapping("/test2")
    @ResponseBody
    public String secondpage(){
        return "security Page second";
    }

     private static final List<Student> STUDENTS= Arrays.asList(
             new Student(1,"imran"),
             new Student (2,"sri"),
             new Student(3,"thameem"),
             new Student( 4,"samthosh")
     );

    @GetMapping("/student/{id}")
    @ResponseBody
    public Student getStudent(@PathVariable Integer id){
      return STUDENTS.stream().filter(student ->id.equals(student.getStudentId()))
              .findFirst()
              .orElseThrow(()->new IllegalStateException("Student "+id+"does not exist"));

    }
}
