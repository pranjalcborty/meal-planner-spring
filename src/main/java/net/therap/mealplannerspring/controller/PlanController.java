package net.therap.mealplannerspring.controller;

import net.therap.mealplannerspring.domain.Item;
import net.therap.mealplannerspring.domain.Meal;
import net.therap.mealplannerspring.enums.Day;
import net.therap.mealplannerspring.enums.Type;
import net.therap.mealplannerspring.helper.Constants;
import net.therap.mealplannerspring.service.Service;
import net.therap.mealplannerspring.web.editor.ItemEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * @author pranjal.chakraborty
 * @since 24-May-17
 */
@Controller
public class PlanController {

    private static final String PLAN_ADDED = "Plan added";

    @InitBinder
    public void initBinder(WebDataBinder dataBinder) {
        dataBinder.registerCustomEditor(Item.class, new ItemEditor());
    }

    @RequestMapping(value = Constants.ADD_PLAN_PATH, method = RequestMethod.POST)
    public String add(@ModelAttribute Meal meal, ModelMap model) {

        Service helper = new Service();

        helper.addPlan(meal);
        model.put(Constants.ADD_PLAN_NOTIFY, PLAN_ADDED);

        return "redirect:" + Constants.ADD_PLAN_PATH;
    }

    @RequestMapping(value = Constants.ADD_PLAN_PATH, method = RequestMethod.GET)
    public String view(ModelMap model) {
        Service helper = new Service();
        List<Item> items = helper.showItems();

        model.put(Constants.ITEM_LIST, items);

        model.put("meal", new Meal());
        model.put("days", Day.values());
        model.put("types", Type.values());

        return Constants.ABS_ADD_PLAN_PATH;
    }

    @RequestMapping(value = Constants.VIEW_PLANS_PATH, method = RequestMethod.GET)
    protected String mealList(ModelMap model) {
        Service helper = new Service();
        List<Meal> meals = helper.showMealPlans();

        model.put(Constants.MEAL_LIST, meals);
        return Constants.ABS_VIEW_PLANS_PATH;
    }
}
