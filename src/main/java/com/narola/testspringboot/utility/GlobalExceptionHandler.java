package com.narola.testspringboot.utility;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Map;

@ControllerAdvice
public class GlobalExceptionHandler  extends ResponseEntityExceptionHandler {

    @ExceptionHandler(ApplicationException.class)
    public ModelAndView validation(ApplicationException e) {
        ModelAndView modelAndView = new ModelAndView();
        if (e.getViewName() == null) {
            modelAndView.setViewName("error");
            modelAndView.addObject("errormsg",e.getMessage());
        } else {
            modelAndView.setViewName(e.getViewName());
            for (Map.Entry<String, String> entry : e.getErrorList().entrySet()) {
                modelAndView.addObject(entry.getKey(), entry.getValue());
            }
        }
        return modelAndView;
    }

    @ExceptionHandler(Exception.class)
    public ModelAndView genericException(Exception e) {
        ModelAndView modelAndView = new ModelAndView("error");
        e.getStackTrace();
        modelAndView.addObject("errormsg", e.getMessage());
        return modelAndView;
    }
}