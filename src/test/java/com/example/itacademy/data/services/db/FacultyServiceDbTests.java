package com.example.itacademy.data.services.db;

import com.example.itacademy.data.services.FacultyService;
import com.example.itacademy.data.services.qualifiers.FacultyServiceDbQualifier;
import com.example.itacademy.models.Faculty;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class FacultyServiceDbTests {
//    private static Faculty a = new Faculty(0, "a");
    @Autowired
    private Faculty a;
    private static Faculty b = new Faculty(0, "b");

    @Autowired
    //@Qualifier("clientServiceDb")
    //@FacultyServiceQualifier
    @FacultyServiceDbQualifier
    FacultyService facultyService;

    @Test
    @Order(1)
    public void save(){
        Faculty saved_a = facultyService.save(a);
        a.setId(saved_a.getId());
        Faculty saved_b = facultyService.save(b);
        b.setId(saved_b.getId());
        Assertions.assertEquals(a, saved_a);
        Assertions.assertEquals(b, saved_b);
    }

    @Test
    @Order(2)
    public void findById(){
        Optional<Faculty> optional = facultyService.findById(a.getId());
        optional.ifPresentOrElse(faculty -> {
            Assertions.assertEquals(a, faculty);
        }, () -> Assertions.fail("Found no Faculty with Id: " + a.getId()));
    }

    @Test
    @Order(3)
    public void findAll(){
        List<Faculty> faculties = facultyService.findAll();
        Assertions.assertEquals(2, faculties.size());
        Assertions.assertIterableEquals(List.of(a, b), faculties);
    }

    @Test
    @Order(4)
    public void update(){
        a.setName("new a");
        Faculty updated = facultyService.update(a);
        Assertions.assertEquals(a, updated);
    }

    @Test
    @Order(5)
    public void deleteById(){
        facultyService.deleteById(a.getId());
        List<Faculty> faculties = facultyService.findAll();
        Assertions.assertEquals(1, faculties.size());
        Assertions.assertEquals(b, faculties.getFirst());
    }

    @Test
    @Order(6)
    public void deleteAll(){
        facultyService.deleteAll();
        List<Faculty> faculties = facultyService.findAll();
        Assertions.assertEquals(0, faculties.size());
    }
}
