package net.therap.mealplannerspring.controller;

import net.therap.mealplannerspring.domain.Item;
import net.therap.mealplannerspring.domain.Meal;
import net.therap.mealplannerspring.enums.Day;
import net.therap.mealplannerspring.enums.Type;
import net.therap.mealplannerspring.helper.Constants;
import net.therap.mealplannerspring.service.ItemService;
import net.therap.mealplannerspring.service.MealService;
import net.therap.mealplannerspring.web.editor.ItemEditor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.List;

/**
 * @author pranjal.chakraborty
 * @since 24-May-17
 */
@Controller
public class PlanController {

    private static final String PLAN_ADDED = "Plan added";
    private static final String PLAN_NOT_ADDED = "Plan not added";
    private static final String MEAL_TAG = "meal";
    private static final String DAYS_TAG = "days";
    private static final String TYPES_TAG = "types";

    @Autowired
    private MealService mealService;

    @Autowired
    private ItemService itemService;

    @InitBinder
    public void initBinder(WebDataBinder dataBinder) {
        dataBinder.registerCustomEditor(Item.class, new ItemEditor());
    }

    @RequestMapping(value = Constants.ADD_PLAN_PATH, method = RequestMethod.POST)
    public String add(@Valid @ModelAttribute Meal meal, BindingResult result, HttpSession session) {

        if (result.hasErrors()) {
            session.setAttribute(Constants.ADD_PLAN_NOTIFY, PLAN_NOT_ADDED);
            return Constants.REDIRECT_TAG + Constants.ADD_PLAN_PATH;
        }
        mealService.addPlan(meal);
        session.setAttribute(Constants.ADD_PLAN_NOTIFY, PLAN_ADDED);

        return Constants.REDIRECT_TAG + Constants.ADD_PLAN_PATH;
    }

    @RequestMapping(value = Constants.ADD_PLAN_PATH, method = RequestMethod.GET)
    public String view(ModelMap model, HttpSession session) {

        if (session.getAttribute(Constants.ADD_PLAN_NOTIFY) != null) {
            model.put(Constants.ADD_PLAN_NOTIFY, session.getAttribute(Constants.ADD_PLAN_NOTIFY));
            session.removeAttribute(Constants.ADD_PLAN_NOTIFY);
        }

        List<Item> items = itemService.showItems();

        model.put(Constants.ITEM_LIST, items);

        model.put(MEAL_TAG, new Meal());
        model.put(DAYS_TAG, Day.values());
        model.put(TYPES_TAG, Type.values());

        return Constants.ABS_ADD_PLAN_PATH;
    }

    @RequestMapping(value = Constants.VIEW_PLANS_PATH, method = RequestMethod.GET)
    protected String mealList(ModelMap model) {

        List<Meal> meals = mealService.showMealPlans();

        model.put(Constants.MEAL_LIST, meals);
        return Constants.ABS_VIEW_PLANS_PATH;
    }
}
