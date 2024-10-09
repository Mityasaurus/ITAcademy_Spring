package com.example.itacademy.ui.restcontrollers;

import com.example.itacademy.data.services.PaymentService;
import com.example.itacademy.data.services.StudentService;
import com.example.itacademy.models.Payment;
import com.example.itacademy.models.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
public class StudentUpdateRestController {

    @Autowired
    PaymentService paymentService;

    @Autowired
    StudentService studentService;

    @PostMapping("/rest/paymentUpdateForm")
    public ResponseEntity<?> paymentUpdateForm(@RequestParam("studentId") Integer studentId, @RequestBody Payment payment){
//        System.err.println(payment);
//        System.err.println(studentId);
        try {
            Optional<Student> student = studentService.findById(studentId);
            if(student.isPresent()){
                payment.setStudent(student.get());
                paymentService.update(payment);
            }
            else{
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }
            return new ResponseEntity<>(HttpStatus.OK);
        }
        catch(Exception ex){
            System.err.println(ex.getMessage());
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}
