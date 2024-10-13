package com.example.itacademy.ui.restcontrollers;

import com.example.itacademy.data.services.PaymentService;
import com.example.itacademy.data.services.StudentService;
import com.example.itacademy.models.Payment;
import com.example.itacademy.models.Student;
import com.example.itacademy.services.AsyncService;
import lombok.Getter;
import lombok.ToString;
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

    @Getter
    @ToString(callSuper = true)
    public static class PaymentDto extends Payment{
        private Integer studentId;

        public Payment toPayment(){
            return new Payment(getId(), getPaymentAmount(), getPaymentDate(), getYearNumber());
        }
    }

    @Autowired
    PaymentService paymentService;

    @Autowired
    StudentService studentService;

    @Autowired
    AsyncService asyncService;

    @PostMapping("/rest/paymentUpdateForm")
    public ResponseEntity<?> paymentUpdateForm(@RequestBody PaymentDto paymentDto){
        Payment payment = paymentDto.toPayment();
        Integer studentId = paymentDto.getStudentId();
        try {
            Optional<Student> student = studentService.findById(studentId);
            if(student.isPresent()){
                payment.setStudent(student.get());
                paymentService.update(payment);
            }
            else{
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }
            //
            asyncService.asyncMethod();
            //
            return new ResponseEntity<>(HttpStatus.OK);
        }
        catch(Exception ex){
            System.err.println(ex.getMessage());
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}
