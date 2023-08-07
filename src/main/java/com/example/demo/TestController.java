package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class TestController {
    @GetMapping(value = "/test")
    public ModelAndView getTest(){
        ModelAndView result = new ModelAndView("test");// Вказуємо назву шаблону без розширення
        result.addObject("test", "Hello from TestController"); // Додаємо дані в модель
        return result;
    }
}
