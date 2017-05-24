package net.therap.mealplannerspring.dao;

import net.therap.mealplannerspring.domain.Item;
import net.therap.mealplannerspring.domain.Meal;
import net.therap.mealplannerspring.enums.Day;
import net.therap.mealplannerspring.enums.Type;
import net.therap.mealplannerspring.helper.HibernateHelper;
import org.hibernate.Query;
import org.hibernate.Session;

import java.util.List;

/**
 * @author pranjal.chakraborty
 * @since 5/10/17
 */
public class MealDao {

    public List<Meal> getMeals() {
        Session session = HibernateHelper.getSessionFactory().openSession();
        Query query = session.createQuery("FROM Meal");

        List<Meal> meals = query.list();
        session.close();
        return meals;
    }

    public void addItemsToMeal(Day day, Type type, List<Item> items) {
        Meal meal = new Meal();
        meal.setDay(day);
        meal.setType(type);
        meal.setItems(items);

        Session session = HibernateHelper.getSessionFactory().openSession();
        session.beginTransaction();
        session.save(meal);
        session.getTransaction().commit();
        session.close();
    }
}
