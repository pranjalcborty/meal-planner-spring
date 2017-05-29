package net.therap.mealplannerspring.service;


import net.therap.mealplannerspring.dao.ItemDao;
import net.therap.mealplannerspring.dao.MealDao;
import net.therap.mealplannerspring.dao.UserDao;
import net.therap.mealplannerspring.domain.Item;
import net.therap.mealplannerspring.domain.Meal;
import net.therap.mealplannerspring.domain.User;
import net.therap.mealplannerspring.enums.Day;
import net.therap.mealplannerspring.enums.Type;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author pranjal.chakraborty
 * @since 5/10/17
 */
@Service
public class SysService {

    @Autowired
    private MealDao mealDao;

    @Autowired
    private ItemDao itemDao;

    @Autowired
    private UserDao userDao;

    public List<Meal> showMealPlans() {
        List<Meal> meals = mealDao.getMeals();
        return meals;
    }

    public void addPlan(Meal meal) {
        mealDao.addItemsToMeal(meal);
    }

    public void addItem(Item item) {
        itemDao.addItem(item);
    }

    public List<Item> showItems() {
        List<Item> items = itemDao.generateItems();
        return items;
    }

    public boolean isAllowed(String uname, String pass) {
        return userDao.isAllowed(uname, pass);
    }

    public boolean contains(String uName) {
        return userDao.contains(uName);
    }

    public void addUser(User user) {
        userDao.addUser(user);
    }
}
