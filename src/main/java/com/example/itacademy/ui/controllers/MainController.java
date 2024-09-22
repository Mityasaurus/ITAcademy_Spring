package com.example.itacademy.ui.controllers;

import com.example.itacademy.data.services.StudentService;
import com.example.itacademy.models.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class MainController {

    @Autowired
    StudentService studentService;

//    @RequestMapping(method = {RequestMethod.GET}, path = "/")
    @GetMapping("/")
    public String load(){
        return "redirect:students";
    }

    @GetMapping("students")
    public String loadStudents(Model model){
        List<Student> list = studentService.findAll();
        model.addAttribute("students", list);
        return "main";
    }

//    @PostMapping("studentForm")
    public String studentForm1(
            @RequestParam("name") String name,
            @RequestParam("lastname") String lastname,
            @RequestParam("age") int age,
            @RequestParam("phone") String phone,
            @RequestParam("email") String email
    ){
        Student student = new Student(0, name, lastname, age, email, phone);
        System.err.println(student);

        return "redirect:";
    }

    @PostMapping("studentForm")
    public String studentForm2(@ModelAttribute("student") Student student){
        System.err.println(student);
        studentService.save(student);
        return "redirect:";
    }
}
