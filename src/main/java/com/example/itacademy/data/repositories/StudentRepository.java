package com.example.itacademy.data.repositories;

import com.example.itacademy.models.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.stream.Stream;

public interface StudentRepository extends JpaRepository<Student, Integer> {
    List<Student> findByLastnameIgnoreCaseAndNameIgnoreCase(String lastname, String name);

    List<Student> findByEmail(String email);

    long countByAgeBetween(Integer ageStart, Integer ageEnd);

    Stream<Student> findByAgeNot(Integer age);
}
