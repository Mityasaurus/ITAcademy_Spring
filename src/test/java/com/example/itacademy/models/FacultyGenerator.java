package com.example.itacademy.models;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class FacultyGenerator {
    @Bean
    public Faculty faculty(){
        return new Faculty(0, "a");
    }

    @Bean
    public ArrayList<Faculty> facultyList(){
        return new ArrayList<>(List.of(
                new Faculty(0, "a"),
                new Faculty(0, "b")
        ));
    }
}
