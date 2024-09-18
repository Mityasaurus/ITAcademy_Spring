package com.example.itacademy.data.services.db;

import com.example.itacademy.data.services.PaymentService;
import com.example.itacademy.models.Payment;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class PaymentServiceDbTests {
    private static Payment a = new Payment(0, 1, Date.valueOf(LocalDate.now()), 1);
    private static Payment b = new Payment(0, 2, Date.valueOf(LocalDate.now()), 2);

    @Autowired
    PaymentService paymentService;

    @Test
    @Order(1)
    public void save(){
        Payment saved_a = paymentService.save(a);
        a.setId(saved_a.getId());
        Payment saved_b = paymentService.save(b);
        b.setId(saved_b.getId());
        Assertions.assertEquals(a, saved_a);
        Assertions.assertEquals(b, saved_b);
    }

    @Test
    @Order(2)
    public void findById(){
        Optional<Payment> optional = paymentService.findById(a.getId());
        optional.ifPresentOrElse(Payment -> {
            Assertions.assertEquals(a, Payment);
        }, () -> Assertions.fail("Found no Payment with Id: " + a.getId()));
    }

    @Test
    @Order(3)
    public void findAll(){
        List<Payment> payments = paymentService.findAll();
        Assertions.assertEquals(2, payments.size());
        Assertions.assertIterableEquals(List.of(a, b), payments);
    }

    @Test
    @Order(4)
    public void update(){
        a.setPaymentAmount(3);
        a.setYearNumber(3);
        Payment updated = paymentService.update(a);
        Assertions.assertEquals(a, updated);
    }

    @Test
    @Order(5)
    public void deleteById(){
        paymentService.deleteById(a.getId());
        List<Payment> payments = paymentService.findAll();
        Assertions.assertEquals(1, payments.size());
        Assertions.assertEquals(b, payments.getFirst());
    }

    @Test
    @Order(6)
    public void deleteAll(){
        paymentService.deleteAll();
        List<Payment> payments = paymentService.findAll();
        Assertions.assertEquals(0, payments.size());
    }
}
