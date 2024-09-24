package com.example.itacademy.ui.controllers.mustache;

import com.example.itacademy.data.services.ProgramNewsService;
import com.example.itacademy.models.ProgramNews;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.time.LocalDateTime;
import java.util.List;

@Controller
public class ProgramNewsMustacheController {
    @Autowired
    ProgramNewsService programNewsService;

    @GetMapping("programnews")
    public String index(Model model){
        List<ProgramNews> list = programNewsService.findAll();
        model.addAttribute("programNews", list);
        return "mustache/programNews";
    }

    @PostMapping("programNewsForm")
    public String programNewsForm(@ModelAttribute("programNews") ProgramNews programNews){
        System.err.println(programNews);
        LocalDateTime now = LocalDateTime.now();
        programNews.setCreatedAt(now);
        programNews.setUpdatedAt(now);
        programNewsService.save(programNews);
        return "redirect:";
    }
}
