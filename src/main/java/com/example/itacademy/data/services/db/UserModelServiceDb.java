package com.example.itacademy.data.services.db;

import com.example.itacademy.data.repositories.UserModelRepository;
import com.example.itacademy.data.services.UserModelService;
import com.example.itacademy.models.UserModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserModelServiceDb implements UserModelService {
    @Autowired
    private UserModelRepository userModelRepository;

    @Override
    public Optional<UserModel> findByLogin(String login){
        return userModelRepository.findByLogin(login);
    }

    @Override
    public UserModel save(UserModel userModel){
        return userModelRepository.save(userModel);
    }
}
