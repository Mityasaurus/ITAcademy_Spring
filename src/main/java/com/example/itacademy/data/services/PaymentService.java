package com.example.itacademy.data.services;

import com.example.itacademy.models.Payment;
import lombok.NonNull;

import java.util.List;
import java.util.Optional;

public interface PaymentService {
    Payment save(Payment payment);

    Optional<Payment> findById(@NonNull Integer id);

    List<Payment> findAll();

    Payment update(Payment payment);

    void deleteById(@NonNull Integer id);

    void deleteAll();
}
