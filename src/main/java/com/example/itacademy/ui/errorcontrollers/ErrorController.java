package com.example.itacademy.ui.errorcontrollers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
public class ErrorController {
    //For UI Pages
    @ExceptionHandler(Exception.class)
    public ModelAndView exception(Exception e){
        System.err.println("Exception");
        System.err.println(e.getMessage());
        return new ModelAndView(
                "error",
                new ModelMap("message", e.getMessage())
        );
    }

    @ExceptionHandler(ArithmeticException.class)
    public ModelAndView arithmeticException(Exception e){
        System.err.println("Arithmetic Exception");
        System.err.println(e.getMessage());
        return new ModelAndView(
                "error",
                new ModelMap("message", e.getMessage())
        );
    }

    //For REST APIs
    @ExceptionHandler(IllegalAccessException.class)
    public ResponseEntity<?> illegalAccessException(IllegalAccessException e){
        return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
    }
}
