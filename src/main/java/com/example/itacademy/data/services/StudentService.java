package com.example.itacademy.data.services;

import com.example.itacademy.models.Student;
import lombok.NonNull;

import java.util.List;
import java.util.Optional;

public interface StudentService {
    Student save(Student student);

    Optional<Student> findById(@NonNull Integer id);

    List<Student> findAll();

    Student update(Student student);

    void deleteById(@NonNull Integer id);

    void deleteAll();
}
