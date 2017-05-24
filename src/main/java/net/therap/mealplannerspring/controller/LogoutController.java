package net.therap.mealplannerspring.controller;

import net.therap.mealplannerspring.helper.Constants;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
public class LogoutController {

    @RequestMapping("/logout")
    protected String logout(HttpSession session) {

        session.invalidate();
        return "redirect:" + Constants.LOGIN_PATH;
    }
}
