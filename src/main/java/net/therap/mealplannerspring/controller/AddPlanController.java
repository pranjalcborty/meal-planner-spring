package net.therap.mealplannerspring.controller;

import net.therap.mealplannerspring.domain.Item;
import net.therap.mealplannerspring.helper.Constants;
import net.therap.mealplannerspring.helper.Helper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Arrays;
import java.util.List;

/**
 * @author pranjal.chakraborty
 * @since 24-May-17
 */
@Controller
public class AddPlanController {

    private static final String DAY = "day";
    private static final String TYPE = "type";
    private static final String ITEMS = "items";
    private static final String PLAN_ADDED = "Plan added";

    @RequestMapping(value = Constants.ADD_PLAN_PATH, method = RequestMethod.POST)
    public String postNewMeal(@RequestParam(ITEMS) String[] items, @RequestParam(TYPE) String type,
                              @RequestParam(DAY) String day, ModelMap model) {

        Helper helper = new Helper();

        helper.addPlan(day, type, Arrays.asList(items));
        model.put(Constants.ADD_PLAN_NOTIFY, PLAN_ADDED);

        return "redirect:" + Constants.ADD_PLAN_PATH;
    }

    @RequestMapping(value = Constants.ADD_PLAN_PATH, method = RequestMethod.GET)
    public String getNewMeal(ModelMap model) {
        Helper helper = new Helper();
        List<Item> items = helper.showItems();
        model.put(Constants.ITEM_LIST, items);
        return Constants.ABS_ADD_PLAN_PATH;
    }
}
