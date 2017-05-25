package net.therap.mealplannerspring.service;


import net.therap.mealplannerspring.dao.ItemDao;
import net.therap.mealplannerspring.dao.MealDao;
import net.therap.mealplannerspring.dao.UserDao;
import net.therap.mealplannerspring.domain.Item;
import net.therap.mealplannerspring.domain.Meal;
import net.therap.mealplannerspring.domain.User;
import net.therap.mealplannerspring.enums.Day;
import net.therap.mealplannerspring.enums.Type;

import javax.transaction.Transactional;
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

    public static Day getDay(int input) {
        return dayMap.get(input);
    }

    public static Type getType(int input) {
        return typeMap.get(input);
    }

    public Day daySelect(String day) {
        int daySelected = Integer.parseInt(day);

        return getDay(daySelected);
    }

    public Type typeSelect(String type) {
        int typeSelected = Integer.parseInt(type);

        return getType(typeSelected);
    }

    public List<Meal> showMealPlans() {
        List<Meal> meals = mealDao.getMeals();
        return meals;
    }

    @Transactional
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
