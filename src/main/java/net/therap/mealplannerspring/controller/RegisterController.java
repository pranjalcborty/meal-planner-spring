package net.therap.mealplannerspring.controller;

import net.therap.mealplannerspring.domain.User;
import net.therap.mealplannerspring.helper.Constants;
import net.therap.mealplannerspring.service.UserService;
import net.therap.mealplannerspring.web.validator.UserValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

/**
 * @author pranjal.chakraborty
 * @since 20-May-17
 */
@Controller
public class RegisterController {

    @Autowired
    private UserService service;
    @Autowired
    private UserValidator validator;

    @RequestMapping(value = Constants.REGISTER_PATH, method = RequestMethod.POST)
    public String postRegistration(@Valid @ModelAttribute User user, BindingResult errors, HttpSession session) {

        validator.validate(user, errors);

        if (errors.hasErrors()) {
            session.setAttribute(Constants.FAILURE_NOTIFY, Constants.REGISTRATION_ERROR);
            return Constants.REDIRECT_TAG + Constants.REGISTER_PATH;
        }

        service.addUser(user);
        return Constants.REDIRECT_TAG + Constants.LOGIN_PATH;
    }

    @RequestMapping(value = Constants.REGISTER_PATH, method = RequestMethod.GET)
    public String getRegistration(HttpSession session, ModelMap model) {

        if (session.getAttribute(Constants.FAILURE_NOTIFY) != null) {
            model.put(Constants.FAILURE_NOTIFY, session.getAttribute(Constants.FAILURE_NOTIFY));
            session.removeAttribute(Constants.FAILURE_NOTIFY);
        }

        if (session.getAttribute(Constants.USER_NAME) != null) {
            return Constants.REDIRECT_TAG + Constants.HOME_PATH;
        } else {
            return Constants.ABS_REGISTER_PATH;
        }
    }
}
