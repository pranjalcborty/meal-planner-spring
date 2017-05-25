package net.therap.mealplannerspring.controller;

import net.therap.mealplannerspring.domain.Item;
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
public class CurrentItemsController {

    @RequestMapping(value = Constants.VIEW_ITEMS_PATH, method = RequestMethod.GET)
    public String getCurrentItems(ModelMap model) {
        List<Item> items = new MealHelper().showItems();

        model.put(Constants.ITEM_LIST, items);
        return Constants.ABS_VIEW_ITEMS_PATH;
    }
}
