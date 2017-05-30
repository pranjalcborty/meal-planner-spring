package net.therap.mealplannerspring.controller;

import net.therap.mealplannerspring.domain.Item;
import net.therap.mealplannerspring.helper.Constants;
import net.therap.mealplannerspring.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
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
public class ItemController {

    private static final String ITEM_ADDED = "Item added";
    private static final String ITEM_NOT_ADDED = "Item not added";

    @Autowired
    private ItemService service;

    @RequestMapping(value = Constants.ADD_ITEM_PATH, method = RequestMethod.POST)
    public String add(@Valid @ModelAttribute Item item, BindingResult result, HttpSession session) {

        if (result.hasErrors()) {
            session.setAttribute(Constants.ADD_ITEM_NOTIFY, ITEM_NOT_ADDED);
            return Constants.REDIRECT_TAG + Constants.ADD_ITEM_PATH;
        }
        service.addItem(item);
        session.setAttribute(Constants.ADD_ITEM_NOTIFY, ITEM_ADDED);

        return Constants.REDIRECT_TAG + Constants.ADD_ITEM_PATH;
    }

    @RequestMapping(value = Constants.ADD_ITEM_PATH, method = RequestMethod.GET)
    public String view(ModelMap model, HttpSession session) {

        if (session.getAttribute(Constants.ADD_ITEM_NOTIFY) != null) {
            model.put(Constants.ADD_ITEM_NOTIFY, session.getAttribute(Constants.ADD_ITEM_NOTIFY));
            session.removeAttribute(Constants.ADD_ITEM_NOTIFY);
        }
        return Constants.ABS_ADD_ITEM_PATH;
    }

    @RequestMapping(value = Constants.VIEW_ITEMS_PATH, method = RequestMethod.GET)
    public String itemList(ModelMap model) {
        List<Item> items = service.showItems();

        model.put(Constants.ITEM_LIST, items);
        return Constants.ABS_VIEW_ITEMS_PATH;
    }
}