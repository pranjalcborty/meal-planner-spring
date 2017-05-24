package net.therap.mealplannerspring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class WebController {

    @RequestMapping("/login")
    public ModelAndView logIn() {

        ModelAndView model = new ModelAndView("index");
        return model;
    }
}
