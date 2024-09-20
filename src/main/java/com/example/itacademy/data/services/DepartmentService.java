package com.example.itacademy.data.services;

import com.example.itacademy.models.Department;
import lombok.NonNull;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public interface DepartmentService {
    Department save(Department department);

    Optional<Department> findById(@NonNull Integer id);

    List<Department> findAll();

    Department update(Department department);

    void deleteById(@NonNull Integer id);

    void deleteAll();

    List<Department> saveAll(List<Department> departmentList);
}
