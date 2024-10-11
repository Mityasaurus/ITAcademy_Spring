package com.example.itacademy.ui.controllers;

import com.example.itacademy.data.services.UserModelService;
import com.example.itacademy.models.UserModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class UsersController {
    
    @Autowired
    private UserModelService userModelService;

    @Autowired
    @Lazy
    private PasswordEncoder encoder;

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @GetMapping("users")
    public String load(Model model){
        List<UserModel> users = userModelService.findAll();
        model.addAttribute("usersList", users);
        return "users";
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @PostMapping("addUserForm")
    public String addUserForm(@ModelAttribute("UserModel") UserModel user){
        user.setStatus(UserModel.Status.ACTIVE);
        user.setPassword(encoder.encode(user.getPassword()));
        userModelService.save(user);
        return "redirect:users";
    }
}
