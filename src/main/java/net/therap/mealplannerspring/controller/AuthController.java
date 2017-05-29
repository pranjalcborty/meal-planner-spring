package net.therap.mealplannerspring.controller;


import net.therap.mealplannerspring.helper.Constants;
import net.therap.mealplannerspring.service.SysService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;

import static net.therap.mealplannerspring.helper.Constants.*;

/**
 * @author pranjal.chakraborty
 * @since 24-May-17
 */
@Controller
public class AuthController {

    private final static String MATCH_ERROR = "ID/Pass don't match";

    @Autowired
    private SysService helper;

    @RequestMapping(value = Constants.LOGIN_PATH, method = RequestMethod.GET)
    public String getAuth(HttpSession session) {
        if (session.getAttribute(USER_NAME) != null) {
            return Constants.ABS_HOME_PATH;
        }
        else {
            return Constants.ABS_LOGIN_PATH;
        }
    }

    @RequestMapping(value = Constants.LOGIN_PATH, method = RequestMethod.POST)
    public String postAuth(@RequestParam(Constants.USER_NAME) String userName,
                           @RequestParam(Constants.PASSWORD) String password, HttpSession session) {

        if (helper.isAllowed(userName, password)) {
            session.setAttribute(USER_NAME, userName);
            session.setMaxInactiveInterval(10 * 60);

            return Constants.REDIRECT_TAG + HOME_PATH;
        }
        else {
            session.setAttribute(FAILURE_NOTIFY, MATCH_ERROR);
            return Constants.REDIRECT_TAG + LOGIN_PATH;
        }
    }

    @RequestMapping("/logout")
    protected String logout(HttpSession session) {
        session.invalidate();
        return Constants.REDIRECT_TAG + Constants.LOGIN_PATH;
    }
}
