package net.therap.mealplannerspring.controller;

import net.therap.mealplannerspring.helper.Constants;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author pranjal.chakraborty
 * @since 24-May-17
 */
@Controller
public class HomeController {

    @RequestMapping(value = Constants.HOME_PATH, method = RequestMethod.GET)
    public String getHomeView(ModelMap model) {
        return Constants.ABS_HOME_PATH;
    }
}
