package com.example.itacademy.data.services.json;

import com.example.itacademy.data.services.DepartmentService;
import com.example.itacademy.data.services.FacultyService;
import com.example.itacademy.data.services.qualifiers.FacultyServiceDbQualifier;
import com.example.itacademy.data.services.qualifiers.FacultyServiceJsonQualifier;
import com.example.itacademy.models.Department;
import com.example.itacademy.models.Faculty;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Commit;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class FacultyServiceJsonTest {

    @Autowired
    private ArrayList<Faculty> facultyList;

    @Autowired
    private ArrayList<Department> departmentList;

    @Autowired
    @FacultyServiceDbQualifier
    private FacultyService facultyServiceDb;

    @Autowired
    @FacultyServiceJsonQualifier
    private FacultyService facultyServiceJson;

    @Autowired
    private DepartmentService departmentServiceDb;

    @Test
    @Order(1)
    public void saveFaculties() {
        List<Faculty> saved = facultyServiceDb.saveAll(facultyList);
        Assertions.assertIterableEquals(saved, facultyServiceDb.findAll());
    }

    @Test
    @Order(2)
    public void saveDepartments() {
        List<Department> saved = departmentServiceDb.saveAll(departmentList);
        Assertions.assertIterableEquals(saved, departmentServiceDb.findAll());
    }

    //Для режиму fetch = FetchType.LAZY
    @Transactional
    //Для збереження даних в базі після завершення тесту
    @Commit
    @Test
    @Order(3)
    public void updateDepartments() {
        List<Faculty> faculties = facultyServiceDb.findAll();
        List<Department> departments = departmentServiceDb.findAll();

        departments.get(0).setFaculty(faculties.get(0));
        departments.get(1).setFaculty(faculties.get(0));
        departments.get(2).setFaculty(faculties.get(1));

        List<Department> saved = departmentServiceDb.saveAll(departments);
        Assertions.assertIterableEquals(departments, saved);

        saved.forEach(department -> {
            System.err.println(department);
            System.err.println(department.getFaculty());
        });
    }

    @Transactional
    @Test
    @Order(4)
    public void toJson() {
        List<Faculty> faculties = facultyServiceDb.findAll();

        faculties.forEach(faculty -> {
            System.err.println(faculty);
            System.err.println(faculty.getDepartments());
            faculty.getDepartments().forEach(department -> {
                System.err.println(department.getFaculty());
                System.err.println();
            });
        });

        List<Faculty> saved = facultyServiceJson.saveAll(faculties);
        Assertions.assertIterableEquals(faculties, saved);
    }

    @Test
    @Order(5)
    public void fromJson() {
        List<Faculty> faculties = facultyServiceJson.findAll();
        System.err.println(faculties);
        System.err.println(faculties.getFirst().getDepartments());
    }
}
