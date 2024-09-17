package com.example.itacademy.data.services;

import com.example.itacademy.models.Faculty;
import lombok.NonNull;

import java.util.Optional;

public interface FacultyService {

    Faculty save(Faculty faculty);

    Optional<Faculty> findById(@NonNull Integer id);
}
