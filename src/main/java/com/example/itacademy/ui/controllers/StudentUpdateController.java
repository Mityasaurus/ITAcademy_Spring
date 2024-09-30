package com.example.itacademy.ui.controllers;

import com.example.itacademy.data.services.StudentService;
import com.example.itacademy.models.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;

@Controller
public class StudentUpdateController {

    @Autowired
    StudentService studentService;

    @GetMapping("studentupdate")
    public String load(Model model, @RequestParam("studentId") Integer studentId){
        Optional<Student> optionalStudent = studentService.findById(studentId);
        optionalStudent.ifPresent(student -> model.addAttribute("student", student));
        return "studentUpdate";
    }

    @PostMapping("studentupdateform")
    public String studentUpdateForm(@ModelAttribute("Student") Student student){
        studentService.update(student);
        return "redirect:students";
    }

}
