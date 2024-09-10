package com.example.itacademy.data.repositories;

import com.example.itacademy.models.Group;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GroupRepository extends JpaRepository<Group, Integer> {
}
