package com.example.itacademy.data.repositories;

import ch.qos.logback.core.net.server.Client;
import com.example.itacademy.models.Student;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class StudentRepositoryTests {
    public static Student a = new Student(0, "a", "b", 19, "a", "a", null, null);
    public static Student b = new Student(0, "b", "b", 20, "b", "b", null, null);

    @Autowired
    private StudentRepository studentRepository;

    @Test
    @Order(1)
    public void save() {
        Student saved_a = studentRepository.save(a);
        Student saved_b = studentRepository.save(b);

        a.setId(saved_a.getId());
        b.setId(saved_b.getId());

        Assertions.assertEquals(a, saved_a);
        Assertions.assertEquals(b, saved_b);
    }

    @Test
    @Order(2)
    public void findById() {
        Optional<Student> find_a = studentRepository.findById(a.getId());
        if (find_a.isPresent()) {
            Assertions.assertEquals(a, find_a.get());
        } else {
            Assertions.fail();
        }
    }

    @Test
    @Order(3)
    public void getAll() {
        List<Student> all = studentRepository.findAll();
        Assertions.assertEquals(2, all.size());
        Assertions.assertIterableEquals(List.of(a, b), all);
    }

    @Test
    @Order(4)
    public void update() {
        a.setName("new a");
        a.setLastname("new a");
        a.setAge(120);
        a.setEmail("new a");
        a.setPhone("new a");
        Student saved = studentRepository.save(a);
        Assertions.assertEquals(a, saved);
    }

    @Test
    @Order(5)
    public void deleteById() {
        studentRepository.deleteById(b.getId());
        List<Student> all = studentRepository.findAll();
        Assertions.assertEquals(1, all.size());
        Assertions.assertEquals(a, all.getFirst());
    }

//    @Test
    @Order(6)
    public void deleteAll() {
        studentRepository.deleteAll();
        List<Student> all = studentRepository.findAll();
        Assertions.assertEquals(0, all.size());
    }

    @Test
    @Order(7)
    @Transactional
    public void test(){
        List<Student> studentList = studentRepository.findByEmail("new a");
        System.out.println(studentList);
        long count = studentRepository.countByAgeBetween(18, 120);
        System.out.println(count);
        Stream<Student> stream = studentRepository.findByAgeNot(21);
        stream.forEach(System.out::println);
    }
}
