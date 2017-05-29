package net.therap.mealplannerspring.controller;

import net.therap.mealplannerspring.domain.Item;
import net.therap.mealplannerspring.helper.Constants;
import net.therap.mealplannerspring.service.SysService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * @author pranjal.chakraborty
 * @since 24-May-17
 */
@Controller
public class ItemController {

    private static final String ITEM_ADDED = "Item added";

    @Autowired
    private SysService helper;

    @RequestMapping(value = Constants.ADD_ITEM_PATH, method = RequestMethod.POST)
    public String add(@ModelAttribute Item item, ModelMap model) {

        helper.addItem(item);
        model.put(Constants.ADD_ITEM_NOTIFY, ITEM_ADDED);

        return Constants.REDIRECT_TAG + Constants.ADD_ITEM_PATH;
    }

    @RequestMapping(value = Constants.ADD_ITEM_PATH, method = RequestMethod.GET)
    public String view() {
        return Constants.ABS_ADD_ITEM_PATH;
    }

    @RequestMapping(value = Constants.VIEW_ITEMS_PATH, method = RequestMethod.GET)
    public String itemList(ModelMap model) {
        List<Item> items = helper.showItems();

        model.put(Constants.ITEM_LIST, items);
        return Constants.ABS_VIEW_ITEMS_PATH;
    }
}