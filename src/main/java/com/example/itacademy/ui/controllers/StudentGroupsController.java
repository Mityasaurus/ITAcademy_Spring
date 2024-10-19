package com.example.itacademy.ui.controllers;

import com.example.itacademy.data.services.GroupService;
import com.example.itacademy.models.Group;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class StudentGroupsController {

    @Autowired
    private GroupService groupService;

    @GetMapping("/studentGroups")
    public String load(Model model){
        List<Group> groups = groupService.findAll();
        model.addAttribute("groupList", groups);
        return "groups";
    }

    @PostMapping("addStudentGroupForm")
    public String addGroupForm(@ModelAttribute("Group") Group group){
        groupService.save(group);
        return "redirect:studentGroups";
    }

    @PostMapping("studentGroupUpdateRedirect")
    public ModelAndView studentGroupUpdateRedirect(@RequestParam("groupId") Integer groupId){
        return new ModelAndView(
                "redirect:studentgroupupdate",
                new ModelMap("groupId", groupId)
        );
    }
}
