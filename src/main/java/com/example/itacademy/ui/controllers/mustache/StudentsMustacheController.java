package com.example.itacademy.ui.controllers.mustache;

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
public class StudentsMustacheController {
    @Autowired
    StudentService studentService;

    @GetMapping("mustache/students")
    public String loadStudents(Model model){
        List<Student> list = studentService.findAll();
        model.addAttribute("students", list);
        return "mustache/students";
    }

    //    @PostMapping("mustache/studentFormMustache")
    public String studentForm1(
            @RequestParam("name") String name,
            @RequestParam("lastname") String lastname,
            @RequestParam("age") int age,
            @RequestParam("phone") String phone,
            @RequestParam("email") String email
    ){
        Student student = new Student(0, name, lastname, age, email, phone);
        System.err.println(student);

        return "redirect:students";
    }

    @PostMapping("mustache/studentFormMustache")
    public String studentForm2(@ModelAttribute("student") Student student){
        System.err.println(student);
        studentService.save(student);
        return "redirect:students";
    }
}
