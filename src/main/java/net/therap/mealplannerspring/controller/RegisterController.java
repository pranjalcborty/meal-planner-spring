package net.therap.mealplannerspring.controller;

import net.therap.mealplannerspring.domain.User;
import net.therap.mealplannerspring.helper.Constants;
import net.therap.mealplannerspring.service.Service;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;

/**
 * @author pranjal.chakraborty
 * @since 20-May-17
 */
@Controller
public class RegisterController {

    private static final String USERNAME_EXISTS = "Username exists";
    private static final String BLANK_ERROR = "Name, username or password cannot be blank";

    @RequestMapping(value = Constants.REGISTER_PATH, method = RequestMethod.POST)
    public String postRegistration(@ModelAttribute User user, ModelMap model) {

        Service helper = new Service();

        if (helper.contains(user.getUname())) {
            model.put(Constants.FAILURE_NOTIFY, USERNAME_EXISTS);
            return "redirect:" + Constants.REGISTER_PATH;
        } else if (user.getUname().length() == 0 || user.getPass().length() == 0 || user.getFullName().length() == 0) {
            model.put(Constants.FAILURE_NOTIFY, BLANK_ERROR);
            return "redirect:" + Constants.REGISTER_PATH;
        } else {
            helper.addUser(user);
            return "redirect:" + Constants.LOGIN_PATH;
        }
    }

    @RequestMapping(value = Constants.REGISTER_PATH, method = RequestMethod.GET)
    public String getRegistration(HttpSession session) {

        if (session.getAttribute(Constants.USER_NAME) != null) {
            return "redirect:" + Constants.HOME_PATH;
        } else {
            return Constants.ABS_REGISTER_PATH;
        }
    }
}
