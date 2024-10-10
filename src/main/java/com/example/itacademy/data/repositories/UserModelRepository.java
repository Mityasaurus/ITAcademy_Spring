package com.example.itacademy.data.repositories;

import com.example.itacademy.models.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserModelRepository extends JpaRepository<UserModel, Integer> {

    Optional<UserModel> findByLogin(String login);
}