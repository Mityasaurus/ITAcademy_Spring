package com.example.itacademy.data.services.db;

import com.example.itacademy.data.repositories.StudentRepository;
import com.example.itacademy.data.services.StudentService;
import com.example.itacademy.models.Student;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceDb implements StudentService {
    @Autowired
    private StudentRepository studentRepository;

    @Override
    public Student save(Student student) {
        return studentRepository.save(student);
    }

    @Override
    public Optional<Student> findById(@NonNull Integer id) {
        Optional<Student> optional = studentRepository.findById(id);
        if(optional.isEmpty()){
            System.err.println("Student Optional Empty");
        }
        return optional;
    }

    @Override
    public List<Student> findAll() {
        List<Student> students = studentRepository.findAll();
        if(students.isEmpty()){
            System.err.println("Student list empty");
        }
        return students;
    }

    @Override
    public Student update(Student student) {
        Optional<Student> optional = findById(student.getId());
        if(optional.isEmpty()){
            System.err.println("Student not found");
        }
        return studentRepository.save(student);
    }

    @Override
    public void deleteById(@NonNull Integer id) {
        Optional<Student> optional = findById(id);
        if(optional.isEmpty()){
            System.err.println("Student not found");
        }
        studentRepository.deleteById(id);
    }

    @Override
    public void deleteAll() {
        studentRepository.deleteAll();
    }
}
