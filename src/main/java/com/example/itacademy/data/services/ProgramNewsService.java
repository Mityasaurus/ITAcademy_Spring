package com.example.itacademy.data.services;

import com.example.itacademy.models.ProgramNews;
import lombok.NonNull;

import java.util.List;
import java.util.Optional;

public interface ProgramNewsService {
    ProgramNews save(ProgramNews programNews);

    Optional<ProgramNews> findById(@NonNull Long id);

    List<ProgramNews> findAll();

    ProgramNews update(ProgramNews programNews);

    void deleteById(@NonNull Long id);

    void deleteAll();
}
