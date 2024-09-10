package com.example.itacademy.data.repositories;

import com.example.itacademy.models.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Integer> {
}
