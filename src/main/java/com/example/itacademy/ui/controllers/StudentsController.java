package com.example.itacademy.ui.controllers;

import com.example.itacademy.data.services.GroupService;
import com.example.itacademy.data.services.StudentService;
import com.example.itacademy.models.Group;
import com.example.itacademy.models.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Optional;

@Controller
public class StudentsController {

    @Autowired
    private StudentService studentService;

    @Autowired
    private GroupService groupService;

    @GetMapping("students")
    public String load(Model model){
        List<Student> students = studentService.findAll();
        model.addAttribute("studentList", students);
        List<Group> groups = groupService.findAll();
        model.addAttribute("groupList", groups);
        return "students";
    }

    @PostMapping("addStudentForm")
    public String addStudentForm(@ModelAttribute("Student") Student student, @RequestParam("groupId") Integer groupId){
        Optional<Group> optionalGroup = groupService.findById(groupId);
        optionalGroup.ifPresent(student::setGroup);
        studentService.save(student);
        return "redirect:students";
    }

    @PostMapping("studentUpdateRedirect")
    public ModelAndView studentUpdateRedirect(@RequestParam("studentId") Integer studentId){
        return new ModelAndView(
                "redirect:studentupdate",
                new ModelMap("studentId", studentId)
        );
    }
}
