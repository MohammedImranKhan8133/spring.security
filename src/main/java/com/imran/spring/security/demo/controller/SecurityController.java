package com.imran.spring.security.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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
        return "security Page";
    }
}
