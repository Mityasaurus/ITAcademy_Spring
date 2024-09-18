package com.example.itacademy.data.services.db;

import com.example.itacademy.data.services.DepartmentService;
import com.example.itacademy.models.Department;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class DepartmentServiceDbTests {
    private static Department a = new Department(0, "a", "a");
    private static Department b = new Department(0, "b", "b");

    @Autowired
    DepartmentService departmentService;

    @Test
    @Order(1)
    public void save(){
        Department saved_a = departmentService.save(a);
        a.setId(saved_a.getId());
        Department saved_b = departmentService.save(b);
        b.setId(saved_b.getId());
        Assertions.assertEquals(a, saved_a);
        Assertions.assertEquals(b, saved_b);
    }

    @Test
    @Order(2)
    public void findById(){
        Optional<Department> optional = departmentService.findById(a.getId());
        optional.ifPresentOrElse(Department -> {
            Assertions.assertEquals(a, Department);
        }, () -> Assertions.fail("Found no Department with Id: " + a.getId()));
    }

    @Test
    @Order(3)
    public void findAll(){
        List<Department> faculties = departmentService.findAll();
        Assertions.assertEquals(2, faculties.size());
        Assertions.assertIterableEquals(List.of(a, b), faculties);
    }

    @Test
    @Order(4)
    public void update(){
        a.setName("new a");
        a.setPhone("new a");
        Department updated = departmentService.update(a);
        Assertions.assertEquals(a, updated);
    }

    @Test
    @Order(5)
    public void deleteById(){
        departmentService.deleteById(a.getId());
        List<Department> faculties = departmentService.findAll();
        Assertions.assertEquals(1, faculties.size());
        Assertions.assertEquals(b, faculties.getFirst());
    }

    @Test
    @Order(6)
    public void deleteAll(){
        departmentService.deleteAll();
        List<Department> faculties = departmentService.findAll();
        Assertions.assertEquals(0, faculties.size());
    }
}
