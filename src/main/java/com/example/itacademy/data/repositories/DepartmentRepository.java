package com.example.itacademy.data.repositories;

import com.example.itacademy.models.Department;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepository extends JpaRepository<Department, Integer> {
}
