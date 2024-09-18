package com.example.itacademy.data.services.db;

import com.example.itacademy.data.repositories.DepartmentRepository;
import com.example.itacademy.data.services.DepartmentService;
import com.example.itacademy.models.Department;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DepartmentServiceDb implements DepartmentService {
    @Autowired
    private DepartmentRepository departmentRepository;

    @Override
    public Department save(Department department) {
        return departmentRepository.save(department);
    }

    @Override
    public Optional<Department> findById(@NonNull Integer id) {
        Optional<Department> optional = departmentRepository.findById(id);
        if(optional.isEmpty()){
            System.err.println("Department Optional Empty");
        }
        return optional;
    }

    @Override
    public List<Department> findAll() {
        List<Department> departments = departmentRepository.findAll();
        if(departments.isEmpty()){
            System.err.println("Department list empty");
        }
        return departments;
    }

    @Override
    public Department update(Department department) {
        Optional<Department> optional = findById(department.getId());
        if(optional.isEmpty()){
            System.err.println("Department not found");
        }
        return departmentRepository.save(department);
    }

    @Override
    public void deleteById(@NonNull Integer id) {
        Optional<Department> optional = findById(id);
        if(optional.isEmpty()){
            System.err.println("Department not found");
        }
        departmentRepository.deleteById(id);
    }

    @Override
    public void deleteAll() {
        departmentRepository.deleteAll();
    }
}
