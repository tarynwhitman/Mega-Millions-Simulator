package com.example.megaMillions.web.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class HomeController {

    @GetMapping("/")
    public ModelAndView index(){
        ModelAndView mav = new ModelAndView("home");
        mav.addObject("hello", "Hello World");
       return mav;
    }
}
