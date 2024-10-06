package com.example.itacademy.ui.controllers;

import com.example.itacademy.data.services.PaymentService;
import com.example.itacademy.data.services.StudentService;
import com.example.itacademy.models.Payment;
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

import java.util.Optional;

@Controller
public class StudentUpdateController {

    @Autowired
    StudentService studentService;

    @Autowired
    PaymentService paymentService;

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

    @PostMapping("/addPaymentForm")
    public ModelAndView addPayment(@ModelAttribute("Payment") Payment payment,
                                   @RequestParam("studentId") Integer studentId) {
        System.err.println(payment);
        System.err.println(studentId);
        //
        Optional<Student> student = studentService.findById(studentId);
        if(student.isPresent()) {
            payment.setStudent(student.get());
            Payment savedPayment = paymentService.save(payment);
        }
        return new ModelAndView(
                "redirect:/studentupdate",
                new ModelMap("studentId", studentId)
        );
    }
}
