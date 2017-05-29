package net.therap.mealplannerspring.dao;

import net.therap.mealplannerspring.domain.Meal;
import org.springframework.stereotype.Repository;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;

/**
 * @author pranjal.chakraborty
 * @since 5/10/17
 */
@Repository
public class MealDao {

    private static final String RETRIEVE_MEAL_QUERY = "SELECT m FROM Meal m";

    @PersistenceContext
    private EntityManager em;

    @Transactional
    public List<Meal> getMeals() {
        TypedQuery<Meal> query = em.createQuery(RETRIEVE_MEAL_QUERY, Meal.class);

        List<Meal> meals = query.getResultList();
        return meals;
    }

    @Transactional
    public void addItemsToMeal(Meal meal) {
        em.persist(meal);
    }
}
