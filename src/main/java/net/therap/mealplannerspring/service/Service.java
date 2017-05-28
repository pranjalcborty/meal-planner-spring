package net.therap.mealplannerspring.service;


import net.therap.mealplannerspring.dao.ItemDao;
import net.therap.mealplannerspring.dao.MealDao;
import net.therap.mealplannerspring.dao.UserDao;
import net.therap.mealplannerspring.domain.Item;
import net.therap.mealplannerspring.domain.Meal;
import net.therap.mealplannerspring.domain.User;
import net.therap.mealplannerspring.enums.Day;
import net.therap.mealplannerspring.enums.Type;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author pranjal.chakraborty
 * @since 5/10/17
 */
public class Service {

    private static final Map<Integer, Day> dayMap = new HashMap<>();
    private static final Map<Integer, Type> typeMap = new HashMap<>();
    private MealDao mealDao;
    private ItemDao itemDao;
    private UserDao userDao;

    static {
        dayMap.put(1, Day.SUN);
        dayMap.put(2, Day.MON);
        dayMap.put(3, Day.TUE);
        dayMap.put(4, Day.WED);
        dayMap.put(5, Day.THU);

        typeMap.put(1, Type.BREAKFAST);
        typeMap.put(2, Type.LUNCH);
    }

    public Service() {
        this.mealDao = new MealDao();
        this.itemDao = new ItemDao();
        this.userDao = new UserDao();
    }

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
