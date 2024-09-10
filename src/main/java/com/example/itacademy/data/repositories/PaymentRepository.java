package com.example.itacademy.data.repositories;

import com.example.itacademy.models.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentRepository extends JpaRepository<Payment, Integer> {
}
