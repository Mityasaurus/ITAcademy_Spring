package com.example.itacademy.data.services.db;

import com.example.itacademy.data.services.GroupService;
import com.example.itacademy.models.Group;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class GroupServiceDbTests {
    private static Group a = new Group(0, "a", 1);
    private static Group b = new Group(0, "b", 1);

    @Autowired
    GroupService groupService;

    @Test
    @Order(1)
    public void save(){
        Group saved_a = groupService.save(a);
        a.setId(saved_a.getId());
        Group saved_b = groupService.save(b);
        b.setId(saved_b.getId());
        Assertions.assertEquals(a, saved_a);
        Assertions.assertEquals(b, saved_b);
    }

    @Test
    @Order(2)
    public void findById(){
        Optional<Group> optional = groupService.findById(a.getId());
        optional.ifPresentOrElse(Group -> {
            Assertions.assertEquals(a, Group);
        }, () -> Assertions.fail("Found no Group with Id: " + a.getId()));
    }

    @Test
    @Order(3)
    public void findAll(){
        List<Group> groups = groupService.findAll();
        Assertions.assertEquals(2, groups.size());
        Assertions.assertIterableEquals(List.of(a, b), groups);
    }

    @Test
    @Order(4)
    public void update(){
        a.setName("new a");
        a.setCurrentYear(2);
        Group updated = groupService.update(a);
        Assertions.assertEquals(a, updated);
    }

    @Test
    @Order(5)
    public void deleteById(){
        groupService.deleteById(a.getId());
        List<Group> groups = groupService.findAll();
        Assertions.assertEquals(1, groups.size());
        Assertions.assertEquals(b, groups.getFirst());
    }

    @Test
    @Order(6)
    public void deleteAll(){
        groupService.deleteAll();
        List<Group> groups = groupService.findAll();
        Assertions.assertEquals(0, groups.size());
    }
}
