package com.example.itacademy.security;

import com.example.itacademy.data.services.UserModelService;
import com.example.itacademy.models.UserModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserModelService userModelService;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<UserModel> optional = userModelService.findByLogin(username);
        if(optional.isPresent()){
            return new UserDetailsImpl(optional.get());
        } 
        System.err.println("User not found!");
        throw new UsernameNotFoundException("User not found");
    }
}
