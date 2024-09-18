package com.example.itacademy.data.services;

import com.example.itacademy.models.Department;
import lombok.NonNull;

import java.util.List;
import java.util.Optional;

public interface DepartmentService {
    Department save(Department Department);

    Optional<Department> findById(@NonNull Integer id);

    List<Department> findAll();

    Department update(Department a);

    void deleteById(@NonNull Integer id);

    void deleteAll();
}
