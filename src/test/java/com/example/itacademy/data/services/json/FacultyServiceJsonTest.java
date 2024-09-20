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
    public void saveFaculties(){
        List<Faculty> savedList = facultyServiceDb.saveAll(facultyList);
        Assertions.assertIterableEquals(savedList, facultyServiceDb.findAll());
        facultyList = new ArrayList<>(savedList);
    }

    @Test
    @Order(2)
    public void saveDepartments(){
        List<Department> savedList = departmentServiceDb.saveAll(departmentList);
        Assertions.assertIterableEquals(savedList, departmentServiceDb.findAll());
        departmentList = new ArrayList<>(savedList);
    }

    @Test
    @Order(3)
    @Transactional
    public void updateFaculties(){
        facultyList = new ArrayList<>(facultyServiceDb.findAll());
        departmentList = new ArrayList<>(departmentServiceDb.findAll());

        facultyList.getFirst().setDepartments(new ArrayList<>(List.of(
                departmentList.getFirst(),
                departmentList.get(1)
        )));
        facultyList.get(1).setDepartments(new ArrayList<>(List.of(
                departmentList.get(2)
        )));

        facultyServiceDb.saveAll(facultyList);
        facultyList = new ArrayList<>(facultyServiceDb.findAll());

        facultyServiceJson.saveAll(facultyList);
    }

//    @Test
//    @Order(4)
//    @Transactional
//    public void exportJson(){
//        facultyList = new ArrayList<>(facultyServiceDb.findAll());
//
//        facultyList.forEach(faculty -> faculty.getDepartments().size());
//
//        facultyServiceJson.saveAll(facultyList);
//    }

    @Test
    @Order(5)
    public void fromJson(){
        List<Faculty> faculties = facultyServiceJson.findAll();
        System.err.println(faculties);
        System.err.println(faculties.getFirst().getDepartments());
    }
}
