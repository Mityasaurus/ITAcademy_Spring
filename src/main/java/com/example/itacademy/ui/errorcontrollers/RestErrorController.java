package com.example.itacademy.ui.errorcontrollers;

import jakarta.servlet.http.HttpServletResponse;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class RestErrorController implements ErrorController {
    @RequestMapping("/error")
    public ModelAndView errorHandler(HttpServletResponse response){
        System.err.println("RestErrorController");
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName(HttpStatus.valueOf(response.getStatus()).name());
        modelAndView.addObject("message", HttpStatus.valueOf(response.getStatus()).name());
        return modelAndView;
    }
}
