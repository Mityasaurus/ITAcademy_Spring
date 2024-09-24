package com.example.itacademy.data.services.db;

import com.example.itacademy.data.repositories.GroupRepository;
import com.example.itacademy.data.services.GroupService;
import com.example.itacademy.models.Group;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GroupServiceDb implements GroupService {
    @Autowired
    private GroupRepository groupRepository;

    @Override
    public Group save(Group group) {
        return groupRepository.save(group);
    }

    @Override
    public Optional<Group> findById(@NonNull Integer id) {
        Optional<Group> optional = groupRepository.findById(id);
        if(optional.isEmpty()){
            System.err.println("Group Optional Empty");
        }
        return optional;
    }

    @Override
    public List<Group> findAll() {
        List<Group> groups = groupRepository.findAll();
        if(groups.isEmpty()){
            System.err.println("Group list empty");
        }
        return groups;
    }

    @Override
    public Group update(Group group) {
        Optional<Group> optional = findById(group.getId());
        if(optional.isEmpty()){
            System.err.println("Group not found");
        }
        return groupRepository.save(group);
    }

    @Override
    public void deleteById(@NonNull Integer id) {
        Optional<Group> optional = findById(id);
        if(optional.isEmpty()){
            System.err.println("Group not found");
        }
        groupRepository.deleteById(id);
    }

    @Override
    public void deleteAll() {
        groupRepository.deleteAll();
    }
}
