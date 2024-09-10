package com.example.itacademy.data.repositories;

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
public class PaymentRepositoryTests {
    public static Payment a = new Payment(0, 100, Date.valueOf(LocalDate.now()), 1);
    public static Payment b = new Payment(0, 200, Date.valueOf(LocalDate.now()), 2);

    @Autowired
    private PaymentRepository paymentRepository;

    @Test
    @Order(1)
    public void save() {
        Payment saved_a = paymentRepository.save(a);
        Payment saved_b = paymentRepository.save(b);

        a.setId(saved_a.getId());
        b.setId(saved_b.getId());

        Assertions.assertEquals(a, saved_a);
        Assertions.assertEquals(b, saved_b);
    }

    @Test
    @Order(2)
    public void findById() {
        Optional<Payment> find_a = paymentRepository.findById(a.getId());
        if (find_a.isPresent()) {
            Assertions.assertEquals(a, find_a.get());
        } else {
            Assertions.fail();
        }
    }

    @Test
    @Order(3)
    public void getAll() {
        List<Payment> all = paymentRepository.findAll();
        Assertions.assertEquals(2, all.size());
        Assertions.assertIterableEquals(List.of(a, b), all);
    }

    @Test
    @Order(4)
    public void update() {
        a.setPaymentAmount(1200);
        a.setYearNumber(20);
        Payment saved = paymentRepository.save(a);
        Assertions.assertEquals(a, saved);
    }

    @Test
    @Order(5)
    public void deleteById() {
        paymentRepository.deleteById(b.getId());
        List<Payment> all = paymentRepository.findAll();
        Assertions.assertEquals(1, all.size());
        Assertions.assertEquals(a, all.getFirst());
    }

    @Test
    @Order(6)
    public void deleteAll() {
        paymentRepository.deleteAll();
        List<Payment> all = paymentRepository.findAll();
        Assertions.assertEquals(0, all.size());
    }
}
