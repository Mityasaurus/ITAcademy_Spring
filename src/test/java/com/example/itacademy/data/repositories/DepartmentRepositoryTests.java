package com.example.itacademy.data.repositories;

import com.example.itacademy.models.Department;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class DepartmentRepositoryTests {
    public static Department a = new Department(0, "a", "a");
    public static Department b = new Department(0, "b", "b");

    @Autowired
    private DepartmentRepository departmentRepository;

    @Test
    @Order(1)
    public void save() {
        Department saved_a = departmentRepository.save(a);
        Department saved_b = departmentRepository.save(b);

        a.setId(saved_a.getId());
        b.setId(saved_b.getId());

        Assertions.assertEquals(a, saved_a);
        Assertions.assertEquals(b, saved_b);
    }

    @Test
    @Order(2)
    public void findById() {
        Optional<Department> find_a = departmentRepository.findById(a.getId());
        if (find_a.isPresent()) {
            Assertions.assertEquals(a, find_a.get());
        } else {
            Assertions.fail();
        }
    }

    @Test
    @Order(3)
    public void getAll(){
        List<Department> all = departmentRepository.findAll();
        Assertions.assertEquals(2, all.size());
        Assertions.assertIterableEquals(List.of(a, b), all);
    }

    @Test
    @Order(4)
    public void update(){
        a.setName("new a");
        a.setPhone("new a");
        Department saved = departmentRepository.save(a);
        Assertions.assertEquals(a, saved);
    }

    @Test
    @Order(5)
    public void deleteById(){
        departmentRepository.deleteById(b.getId());
        List<Department> all = departmentRepository.findAll();
        Assertions.assertEquals(1, all.size());
        Assertions.assertEquals(a, all.getFirst());
    }

    @Test
    @Order(6)
    public void deleteAll(){
        departmentRepository.deleteAll();
        List<Department> all = departmentRepository.findAll();
        Assertions.assertEquals(0, all.size());
    }
}
