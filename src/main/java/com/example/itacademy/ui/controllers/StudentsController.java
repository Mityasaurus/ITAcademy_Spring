package com.example.itacademy.ui.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class StudentsController {
    @GetMapping("students")
    public String load(){
        return "students";
    }

    @PostMapping("addStudentForm")
    public String addStudentForm(@RequestParam("name") String name){
        System.err.println(name);
        return "redirect:students";
    }
}
