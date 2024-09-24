package com.example.itacademy.data.services.db;

import com.example.itacademy.data.repositories.ProgramNewsRepository;
import com.example.itacademy.data.services.ProgramNewsService;
import com.example.itacademy.models.ProgramNews;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProgramNewsServiceDb implements ProgramNewsService {
    @Autowired
    private ProgramNewsRepository programNewsRepository;

    @Override
    public ProgramNews save(ProgramNews programNews) {
        return programNewsRepository.save(programNews);
    }

    @Override
    public Optional<ProgramNews> findById(@NonNull Long id) {
        Optional<ProgramNews> optional = programNewsRepository.findById(id);
        if(optional.isEmpty()){
            System.err.println("Program News Optional Empty");
        }
        return optional;
    }

    @Override
    public List<ProgramNews> findAll() {
        List<ProgramNews> programNews = programNewsRepository.findAll();
        if(programNews.isEmpty()){
            System.err.println("Program News list empty");
        }
        return programNews;
    }

    @Override
    public ProgramNews update(ProgramNews programNews) {
        Optional<ProgramNews> optional = findById(programNews.getId());
        if(optional.isEmpty()){
            System.err.println("Program News not found");
        }
        return programNewsRepository.save(programNews);
    }

    @Override
    public void deleteById(@NonNull Long id) {
        Optional<ProgramNews> optional = findById(id);
        if(optional.isEmpty()){
            System.err.println("Program News not found");
        }
        programNewsRepository.deleteById(id);
    }

    @Override
    public void deleteAll() {
        programNewsRepository.deleteAll();
    }
}
