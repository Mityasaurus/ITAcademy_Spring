package com.example.itacademy.data.services;

import com.example.itacademy.models.Group;
import lombok.NonNull;

import java.util.List;
import java.util.Optional;

public interface GroupService {
    Group save(Group group);

    Optional<Group> findById(@NonNull Integer id);

    List<Group> findAll();

    Group update(Group group);

    void deleteById(@NonNull Integer id);

    void deleteAll();
}
