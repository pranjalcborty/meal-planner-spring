package net.therap.mealplannerspring.controller;


import net.therap.mealplannerspring.helper.Constants;
import net.therap.mealplannerspring.helper.MealHelper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

import static net.therap.mealplannerspring.helper.Constants.*;

@Controller
public class AuthController {
    private final static String MATCH_ERROR = "ID/Pass don't match";

    @RequestMapping(value = Constants.LOGIN_PATH, method = RequestMethod.GET)
    public String getAuth(HttpSession session) {
        if (session.getAttribute(USER_NAME) != null) {
            return Constants.ABS_HOME_PATH;
        } else {
            return Constants.ABS_LOGIN_PATH;
        }
    }

    @RequestMapping(value = Constants.LOGIN_PATH, method = RequestMethod.POST)
    public String postAuth(@RequestParam(Constants.USER_NAME) String userName,
                            @RequestParam(Constants.PASSWORD) String password, HttpSession session) {

        MealHelper helper = new MealHelper();

        if (helper.isAllowed(userName, password)) {
            session.setAttribute(USER_NAME, userName);
            session.setMaxInactiveInterval(10 * 60);

            return "redirect:"+HOME_PATH;
        } else {
            session.setAttribute(FAILURE_NOTIFY, MATCH_ERROR);
            return "redirect:"+LOGIN_PATH;
        }
    }
}
