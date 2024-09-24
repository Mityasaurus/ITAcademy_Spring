package com.example.itacademy.ui.controllers.mustache;

import com.example.itacademy.models.Department;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class MustacheTestController {
    @GetMapping("mustachetest")
    public String load(Model model){
        //variable
        model.addAttribute("variable", "Hello Var");
        model.addAttribute("variable", 123);
        //html_content
        model.addAttribute("html_content", "<strong>Hello World</strong>");
        //Section (if) and Inverted Section (if(!condition))
//        model.addAttribute("isAdmin", true);
        model.addAttribute("isAdmin");
        //Cycle (List)
//        String[] list = new String[]{"aaa", "bbb", "ccc"};
//        model.addAttribute("list", list);
        List<Department> departments = List.of(
                new Department(0, "a", "111"),
                new Department(1, "b", "222"),
                new Department(2, "c", "333"));
        model.addAttribute("list", departments);
        //
        return "mustache/mustacheTest";
    }
}
