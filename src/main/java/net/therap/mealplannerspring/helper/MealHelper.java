package net.therap.mealplannerspring.helper;

import net.therap.mealplannerspring.dao.ItemDao;
import net.therap.mealplannerspring.dao.MealDao;
import net.therap.mealplannerspring.dao.UserDao;
import net.therap.mealplannerspring.domain.Item;
import net.therap.mealplannerspring.domain.Meal;
import net.therap.mealplannerspring.enums.Day;
import net.therap.mealplannerspring.enums.Type;

import java.sql.SQLException;
import java.util.List;

/**
 * @author pranjal.chakraborty
 * @since 5/10/17
 */
public class MealHelper {

    private MealDao mealDao;
    private ItemDao itemDao;
    private UserDao userDao;

    public MealHelper() {
        this.mealDao = new MealDao();
        this.itemDao = new ItemDao();
        this.userDao = new UserDao();
    }

    public Day daySelect(String day) {
        int daySelected = Integer.parseInt(day);

        return Helper.getDay(daySelected);
    }

    public Type typeSelect(String type) {
        int typeSelected = Integer.parseInt(type);

        return Helper.getType(typeSelected);
    }

    public List<Meal> showMealPlans() {
        List<Meal> meals = mealDao.getMeals();
        return meals;
    }

    public void addPlan(String dayNum, String typeNum, List<String> itemsNum) {
        Day day = daySelect(dayNum);
        Type type = typeSelect(typeNum);
        List<Item> items = itemDao.getItems(itemsNum);

        mealDao.addItemsToMeal(day, type, items);
    }

    public void addItem(String itemName) throws SQLException {
        itemDao.addItem(itemName);
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

    public boolean addUser(String fullName, String uName, String pass) {
        return userDao.addUser(fullName, uName, pass);
    }
}
