package com.example.itacademy.security;

import com.example.itacademy.data.services.UserModelService;
import com.example.itacademy.models.UserModel;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootTest
public class UserModelTests {

    @Autowired
    BCryptPasswordEncoder encoder;

    @Autowired
    UserModelService userModelService;

    @Test
    public void save(){
        UserModel userModel = new UserModel(0, "a", encoder.encode("a"), "a@t.com");
        userModel.setStatus(UserModel.Status.ACTIVE);
        userModel.setRole(UserModel.Role.ROLE_ADMIN);
        userModelService.save(userModel);
    }
}
