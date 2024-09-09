package com.example.itacademy.data.repositories;

import com.example.itacademy.models.Faculty;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FacultyRepository extends JpaRepository<Faculty, Integer> {
    Faculty findByName(String name);
}
