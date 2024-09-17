package com.example.itacademy.data.services.db;

import com.example.itacademy.data.services.FacultyService;
import com.example.itacademy.models.Faculty;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class FacultyServiceDbTests {
    private static Faculty a = new Faculty(0, "a");
    private static Faculty b = new Faculty(0, "b");

    @Autowired
    FacultyService facultyService;

    @Test
    @Order(1)
    public void save(){
        Faculty saved_a = facultyService.save(a);
        a.setId(saved_a.getId());
        Assertions.assertEquals(a, saved_a);
//        a = saved_a;
    }

    @Test
    @Order(2)
    public void findById(){
        Optional<Faculty> optional = facultyService.findById(a.getId());
        optional.ifPresentOrElse(faculty -> {
            Assertions.assertEquals(a, faculty);
        }, () -> Assertions.fail("Found no Faculty with Id: " + a.getId()));
    }
}
