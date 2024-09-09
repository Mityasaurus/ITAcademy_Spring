package com.example.itacademy.data.repositories;

import com.example.itacademy.models.Faculty;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class FacultyRepositoryTests {
    private static Faculty a = new Faculty(0, "a");
    private static Faculty b = new Faculty(0, "b");

    @Autowired
    private FacultyRepository facultyRepository;

//    @Test
    public void save() {
//        System.out.println(facultyRepository);
        Faculty saved_a = facultyRepository.save(a);
//        System.out.println(saved_a);
        a.setId(saved_a.getId());
        Assertions.assertEquals(a, saved_a);
    }

    @Test
    @Order(1)
    public void saveAll(){
        Faculty saved_a = facultyRepository.save(a);
        Faculty saved_b = facultyRepository.save(b);
        a.setId(saved_a.getId());
        b.setId(saved_b.getId());
        Assertions.assertEquals(a, saved_a);
        Assertions.assertEquals(b, saved_b);
    }

    @Test
    @Order(2)
    public void findById(){
        Optional<Faculty> container_find_a = facultyRepository.findById(a.getId());
        if (container_find_a.isPresent()) {
            Assertions.assertEquals(a, container_find_a.get());
        }
        else{
            Assertions.fail();
        }
    }

    @Test
    @Order(3)
    public void findAllByCount(){
        Assertions.assertEquals(2, facultyRepository.findAll().size());
    }

    @Test
    @Order(4)
    public void findAllByCollection(){
        List<Faculty> original = List.of(a, b);
        List<Faculty> saved = facultyRepository.findAll();
        Assertions.assertIterableEquals(original, saved);
    }

    @Test
    @Order(5)
    public void deleteAll(){
        facultyRepository.deleteAll();
        int size = facultyRepository.findAll().size();
        Assertions.assertEquals(0, size);
    }

    @Test
    @Order(6)
    public void findByNameTest(){
        Faculty saved_a = facultyRepository.save(a);
        Faculty actual = facultyRepository.findByName(saved_a.getName());
        System.out.println(actual);
        Assertions.assertEquals(saved_a, actual);
        Assertions.assertNotEquals(null, actual);
    }
}
