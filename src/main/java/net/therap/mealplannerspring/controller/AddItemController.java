package net.therap.mealplannerspring.controller;

import net.therap.mealplannerspring.helper.Constants;
import net.therap.mealplannerspring.helper.MealHelper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author pranjal.chakraborty
 * @since 24-May-17
 */
@Controller
public class AddItemController {

    private static final String ITEM_ADDED = "Item added";

    private MealHelper mealHelper;

    public AddItemController() {
        super();
        this.mealHelper = new MealHelper();
    }

    @RequestMapping(value = Constants.ADD_ITEM_PATH, method = RequestMethod.POST)
    public String postItemView(@RequestParam(Constants.ITEM_NAME) String itemName, ModelMap model) {

        mealHelper.addItem(itemName);
        model.put(Constants.ADD_ITEM_NOTIFY, ITEM_ADDED);

        return "redirect:" + Constants.ADD_ITEM_PATH;
    }

    @RequestMapping(value = Constants.ADD_ITEM_PATH, method = RequestMethod.GET)
    public String getItemView() {
        return Constants.ABS_ADD_ITEM_PATH;
    }
}
