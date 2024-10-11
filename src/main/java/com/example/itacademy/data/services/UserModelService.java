package com.example.itacademy.data.services;

import com.example.itacademy.models.UserModel;

import java.util.List;
import java.util.Optional;

public interface UserModelService {
    Optional<UserModel> findByLogin(String login);

    UserModel save(UserModel userModel);

    List<UserModel> findAll();
}
