package com.example.itacademy.data.services.db;

import com.example.itacademy.data.repositories.FacultyRepository;
import com.example.itacademy.data.services.FacultyService;
import com.example.itacademy.models.Faculty;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
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
            System.err.println("Faculty Optional Empty");
        }
        return optional;
    }

    @Override
    public List<Faculty> findAll() {
        List<Faculty> faculties = facultyRepository.findAll();
        if(faculties.isEmpty()){
            System.err.println("Faculty list empty");
        }
        return faculties;
    }

    @Override
    public Faculty update(Faculty faculty) {
        Optional<Faculty> optional = findById(faculty.getId());
        if(optional.isEmpty()){
            System.err.println("Faculty not found");
        }
       return facultyRepository.save(faculty);
    }

    @Override
    public void deleteById(@NonNull Integer id) {
        Optional<Faculty> optional = findById(id);
        if(optional.isEmpty()){
            System.err.println("Faculty not found");
        }
        facultyRepository.deleteById(id);
    }

    @Override
    public void deleteAll() {
        facultyRepository.deleteAll();
    }

    @Override
    public List<Faculty> saveAll(List<Faculty> faculties) {
        return facultyRepository.saveAll(faculties);
    }
}
