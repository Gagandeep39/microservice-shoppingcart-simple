package com.gagan.microservice3frontendservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author Gagandeep
 * @date 28-04-2020
 * @time 20:23
 */

@Controller
public class HomeController {

    @Autowired
    private ModelAndView modelAndView;

    @GetMapping("/")
    public ModelAndView showHome(){
        modelAndView.setViewName("redirect:/ProductCtrl/products");
        return modelAndView;
    }
}
