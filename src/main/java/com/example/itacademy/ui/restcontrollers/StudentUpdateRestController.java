package com.example.itacademy.ui.restcontrollers;

import com.example.itacademy.data.services.PaymentService;
import com.example.itacademy.models.Payment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentUpdateRestController {

    @Autowired
    PaymentService paymentService;

    @PostMapping("/rest/paymentUpdateForm")
            return new ResponseEntity<>(HttpStatus.OK);
        }
}
