package net.therap.mealplannerspring.service;

import net.therap.mealplannerspring.dao.MealDao;
import net.therap.mealplannerspring.domain.Meal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MealService {

    @Autowired
    private MealDao mealDao;

    public List<Meal> showMealPlans() {
        List<Meal> meals = mealDao.getMeals();
        return meals;
    }

    public void addPlan(Meal meal) {
        mealDao.addItemsToMeal(meal);
    }

    public boolean contains(Meal mealFetch) {
        List<Meal> meals = showMealPlans();

        for (Meal meal : meals) {
            if (meal.getType().equals(mealFetch.getType()) && meal.getDay().equals(mealFetch.getDay())) {
                return true;
            }
        }

        return false;
    }
}
