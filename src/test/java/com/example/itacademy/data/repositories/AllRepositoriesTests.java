package com.example.itacademy.data.repositories;

import com.example.itacademy.models.*;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Date;
import java.time.LocalDate;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class AllRepositoriesTests {
    public static Faculty faculty = new Faculty(0, "a");
    public static Department department = new Department(0, "a", "a");
    public static Group group = new Group(0, "a", 1);
    public static Student student = new Student(0, "a", "a",1, "a", "a");
    public static Payment payment = new Payment(0, 1, Date.valueOf(LocalDate.now()), 1);

    @Autowired
    private FacultyRepository facultyRepository;

    @Autowired
    private DepartmentRepository departmentRepository;

    @Autowired
    private GroupRepository groupRepository;

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private PaymentRepository paymentRepository;

    @Test
    @Order(1)
    @Transactional
    public void save(){
        faculty = facultyRepository.save(faculty);
        Assertions.assertNotNull(faculty);
        Assertions.assertNotEquals(0, faculty.getId());

        department.setFaculty(faculty);
        department = departmentRepository.save(department);
        Assertions.assertNotNull(department);
        Assertions.assertNotEquals(0, department.getId());

        System.out.println(department.getFaculty());

        group.setDepartment(department);
        group = groupRepository.save(group);
        Assertions.assertNotNull(group);
        Assertions.assertNotEquals(0, group.getId());

        System.out.println(group.getDepartment());

        student.setGroup(group);
        student = studentRepository.save(student);
        Assertions.assertNotNull(student);
        Assertions.assertNotEquals(0, student.getId());

        System.out.println(student.getGroup());

        payment.setStudent(student);
        payment = paymentRepository.save(payment);
        Assertions.assertNotNull(payment);
        Assertions.assertNotEquals(0, payment.getId());

        System.out.println(payment.getStudent());
        System.out.println(payment);

    }
}
