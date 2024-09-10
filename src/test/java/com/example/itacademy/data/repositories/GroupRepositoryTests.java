package com.example.itacademy.data.repositories;

import com.example.itacademy.models.Group;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class GroupRepositoryTests {
    public static Group a = new Group(0, "a", 1);
    public static Group b = new Group(0, "b", 2);

    @Autowired
    private GroupRepository groupRepository;

    @Test
    @Order(1)
    public void save() {
        Group saved_a = groupRepository.save(a);
        Group saved_b = groupRepository.save(b);

        a.setId(saved_a.getId());
        b.setId(saved_b.getId());

        Assertions.assertEquals(a, saved_a);
        Assertions.assertEquals(b, saved_b);
    }

    @Test
    @Order(2)
    public void findById() {
        Optional<Group> find_a = groupRepository.findById(a.getId());
        if (find_a.isPresent()) {
            Assertions.assertEquals(a, find_a.get());
        } else {
            Assertions.fail();
        }
    }

    @Test
    @Order(3)
    public void getAll(){
        List<Group> all = groupRepository.findAll();
        Assertions.assertEquals(2, all.size());
        Assertions.assertIterableEquals(List.of(a, b), all);
    }

    @Test
    @Order(4)
    public void update(){
        a.setName("new a");
        a.setCurrentYear(4);
        Group saved = groupRepository.save(a);
        Assertions.assertEquals(a, saved);
    }

    @Test
    @Order(5)
    public void deleteById(){
        groupRepository.deleteById(b.getId());
        List<Group> all = groupRepository.findAll();
        Assertions.assertEquals(1, all.size());
        Assertions.assertEquals(a, all.getFirst());
    }

    @Test
    @Order(6)
    public void deleteAll(){
        groupRepository.deleteAll();
        List<Group> all = groupRepository.findAll();
        Assertions.assertEquals(0, all.size());
    }
}
