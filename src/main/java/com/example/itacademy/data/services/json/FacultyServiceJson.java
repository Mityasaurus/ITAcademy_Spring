package com.example.itacademy.data.services.json;

import com.example.itacademy.data.services.FacultyService;
import com.example.itacademy.models.Faculty;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import lombok.NonNull;
import org.apache.commons.io.FileUtils;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.List;
import java.util.Optional;

@Service
public class FacultyServiceJson implements FacultyService {
    private final String filename = this.getClass().getSimpleName() + ".json";
    private final String charset = "utf8";
    private final Gson gson = new GsonBuilder()
            .setPrettyPrinting()
            .create();

    @Override
    public Faculty save(Faculty faculty) {
        return null;
    }

    @Override
    public Optional<Faculty> findById(@NonNull Integer id) {
        return Optional.empty();
    }

    @Override
    public List<Faculty> findAll() {
        String json;
        try {
            json = FileUtils.readFileToString(new File(filename), charset);
        } catch (IOException e) {
            e.printStackTrace();
            return List.of();
        }

        Type facultyListType = new TypeToken<List<Faculty>>() {}.getType();
        return gson.fromJson(json, facultyListType);
    }

    @Override
    public Faculty update(Faculty faculty) {
        return null;
    }

    @Override
    public void deleteById(@NonNull Integer id) {

    }

    @Override
    public void deleteAll() {

    }

    @Override
    public List<Faculty> saveAll(List<Faculty> faculties){
        String json = gson.toJson(faculties);
        try {
            FileUtils.write(new File(filename), json, charset);
        } catch (IOException e) {
            System.err.println(e);
        }
        return faculties;
    }
}
