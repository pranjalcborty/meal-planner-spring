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

/**
 * @author pranjal.chakraborty
 * @since 20-May-17
 */
@Controller
public class RegisterController {
    private static final String USERNAME_EXISTS = "Username exists";
    private static final String BLANK_ERROR = "Name, username or password cannot be blank";

    @RequestMapping(value = Constants.REGISTER_PATH, method = RequestMethod.POST)
    public String postRegistration(@RequestParam(Constants.FULL_NAME) String fullName,
                                    @RequestParam(Constants.USER_NAME) String uName,
                                    @RequestParam(Constants.PASSWORD) String password, ModelMap model) {

        MealHelper helper = new MealHelper();

        if (helper.contains(uName)) {
            model.put(Constants.FAILURE_NOTIFY, USERNAME_EXISTS);
            return "redirect:"+Constants.REGISTER_PATH;
        } else if (uName.length() == 0 || password.length() == 0 || fullName.length() == 0) {
            model.put(Constants.FAILURE_NOTIFY, BLANK_ERROR);
            return "redirect:"+Constants.REGISTER_PATH;
        } else {
            helper.addUser(fullName, uName, password);
            return "redirect:"+Constants.LOGIN_PATH;
        }
    }

    @RequestMapping(value = Constants.REGISTER_PATH, method = RequestMethod.GET)
    public String getRegistration(HttpSession session) {
        if (session.getAttribute(Constants.USER_NAME) != null) {
            return "redirect:"+Constants.HOME_PATH;
        } else {
            return Constants.ABS_REGISTER_PATH;
        }
    }
}
