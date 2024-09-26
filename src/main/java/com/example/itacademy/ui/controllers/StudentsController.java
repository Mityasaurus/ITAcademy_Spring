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

import java.util.List;

@Controller
public class StudentsController {
    @Autowired
    private StudentService studentService;

    @GetMapping("students")
    public String load(Model model){
        List<Student> list = studentService.findAll();
        model.addAttribute("studentList", list);
        return "students";
    }

    @PostMapping("addStudentForm")
    public String addStudentForm(@ModelAttribute("Student") Student student){
        studentService.save(student);
        return "redirect:students";
    }
}
