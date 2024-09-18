package com.example.itacademy.data.services.db;

import com.example.itacademy.data.repositories.PaymentRepository;
import com.example.itacademy.data.services.PaymentService;
import com.example.itacademy.models.Payment;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PaymentServiceDb implements PaymentService {
    @Autowired
    private PaymentRepository paymentRepository;

    @Override
    public Payment save(Payment payment) {
        return paymentRepository.save(payment);
    }

    @Override
    public Optional<Payment> findById(@NonNull Integer id) {
        Optional<Payment> optional = paymentRepository.findById(id);
        if(optional.isEmpty()){
            System.err.println("Payment Optional Empty");
        }
        return optional;
    }

    @Override
    public List<Payment> findAll() {
        List<Payment> payments = paymentRepository.findAll();
        if(payments.isEmpty()){
            System.err.println("Payment list empty");
        }
        return payments;
    }

    @Override
    public Payment update(Payment payment) {
        Optional<Payment> optional = findById(payment.getId());
        if(optional.isEmpty()){
            System.err.println("Payment not found");
        }
        return paymentRepository.save(payment);
    }

    @Override
    public void deleteById(@NonNull Integer id) {
        Optional<Payment> optional = findById(id);
        if(optional.isEmpty()){
            System.err.println("Payment not found");
        }
        paymentRepository.deleteById(id);
    }

    @Override
    public void deleteAll() {
        paymentRepository.deleteAll();
    }
}
