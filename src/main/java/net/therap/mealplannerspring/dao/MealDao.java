package net.therap.mealplannerspring.dao;

import net.therap.mealplannerspring.domain.Meal;
import net.therap.mealplannerspring.helper.JpaHelper;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

/**
 * @author pranjal.chakraborty
 * @since 5/10/17
 */
public class MealDao {
    private static final String RETRIEVE_MEAL_QUERY = "SELECT m FROM Meal m";

    public List<Meal> getMeals() {
        EntityManager em = JpaHelper.getEntityManager();
        TypedQuery<Meal> query = em.createQuery(RETRIEVE_MEAL_QUERY, Meal.class);

        List<Meal> meals = query.getResultList();
        return meals;
    }

    public void addItemsToMeal(Meal meal) {
        EntityManager em = JpaHelper.getEntityManager();
        em.getTransaction().begin();
        em.persist(meal);
        em.getTransaction().commit();
        em.close();
    }
}
