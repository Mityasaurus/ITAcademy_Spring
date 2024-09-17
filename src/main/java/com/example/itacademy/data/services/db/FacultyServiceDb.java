package com.example.itacademy.data.services.db;

import com.example.itacademy.data.repositories.FacultyRepository;
import com.example.itacademy.data.services.FacultyService;
import com.example.itacademy.models.Faculty;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class FacultyServiceDb implements FacultyService{
    @Autowired
    private FacultyRepository facultyRepository;

    @Override
    public Faculty save(Faculty faculty) {
        return facultyRepository.save(faculty);
    }

    @Override
    public Optional<Faculty> findById(@NonNull Integer id) {
        Optional<Faculty> optional = facultyRepository.findById(id);
        if(optional.isEmpty()){
            System.err.println("Optional Empty");
        }
        return optional;
    }
}
