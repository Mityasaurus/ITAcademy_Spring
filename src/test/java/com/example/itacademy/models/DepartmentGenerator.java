package com.example.itacademy.models;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class DepartmentGenerator {
    @Bean
    public ArrayList<Department> departmentList(){
        return new ArrayList<>(List.of(
                new Department(0, "a", "111"),
                new Department(0, "b", "222"),
                new Department(0, "c", "333")
        ));
    }
}
