package net.therap.mealplannerspring.controller;

import net.therap.mealplannerspring.domain.Meal;
import net.therap.mealplannerspring.helper.Constants;
import net.therap.mealplannerspring.helper.MealHelper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * @author pranjal.chakraborty
 * @since 24-May-17
 */
@Controller
public class CurrentPlanController {

    @RequestMapping(value = Constants.VIEW_PLANS_PATH, method = RequestMethod.GET)
    protected String doGet(ModelMap model) {
        List<Meal> meals = new MealHelper().showMealPlans();

        model.put(Constants.MEAL_LIST, meals);
        return Constants.ABS_VIEW_PLANS_PATH;
    }
}
