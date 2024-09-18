package com.example.itacademy.data.services.db;

import com.example.itacademy.data.services.StudentService;
import com.example.itacademy.models.Student;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class StudentServiceDbTests {
    private static Student a = new Student(0, "a", "a", 1, "a", "a");
    private static Student b = new Student(0, "b", "b", 1, "b", "b");

    @Autowired
    StudentService studentService;

    @Test
    @Order(1)
    public void save(){
        Student saved_a = studentService.save(a);
        a.setId(saved_a.getId());
        Student saved_b = studentService.save(b);
        b.setId(saved_b.getId());
        Assertions.assertEquals(a, saved_a);
        Assertions.assertEquals(b, saved_b);
    }

    @Test
    @Order(2)
    public void findById(){
        Optional<Student> optional = studentService.findById(a.getId());
        optional.ifPresentOrElse(Student -> {
            Assertions.assertEquals(a, Student);
        }, () -> Assertions.fail("Found no Student with Id: " + a.getId()));
    }

    @Test
    @Order(3)
    public void findAll(){
        List<Student> students = studentService.findAll();
        Assertions.assertEquals(2, students.size());
        Assertions.assertIterableEquals(List.of(a, b), students);
    }

    @Test
    @Order(4)
    public void update(){
        a.setName("new a");
        a.setLastname("new a");
        a.setAge(2);
        a.setEmail("new a");
        a.setPhone("new a");
        Student updated = studentService.update(a);
        Assertions.assertEquals(a, updated);
    }

    @Test
    @Order(5)
    public void deleteById(){
        studentService.deleteById(a.getId());
        List<Student> students = studentService.findAll();
        Assertions.assertEquals(1, students.size());
        Assertions.assertEquals(b, students.getFirst());
    }

    @Test
    @Order(6)
    public void deleteAll(){
        studentService.deleteAll();
        List<Student> students = studentService.findAll();
        Assertions.assertEquals(0, students.size());
    }
}
