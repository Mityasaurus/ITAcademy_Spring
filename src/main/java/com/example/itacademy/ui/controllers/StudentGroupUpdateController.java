package com.example.itacademy.ui.controllers;

import com.example.itacademy.data.services.GroupService;
import com.example.itacademy.models.Group;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;

@Controller
public class StudentGroupUpdateController {

    @Autowired
    private GroupService groupService;

    @GetMapping("studentgroupupdate")
    public String load(Model model, @RequestParam("groupId") Integer groupId){
        Optional<Group> optionalGroup = groupService.findById(groupId);
        optionalGroup.ifPresent(group -> model.addAttribute("group", group));
        return "groupUpdate";
    }

    @PostMapping("studentgroupupdateform")
    public String studentGroupUpdateForm(@ModelAttribute("Group") Group group){
        groupService.update(group);
        return "redirect:studentGroups";
    }
}
