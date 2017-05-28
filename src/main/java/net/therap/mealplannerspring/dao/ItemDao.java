package net.therap.mealplannerspring.dao;

import net.therap.mealplannerspring.domain.Item;
import net.therap.mealplannerspring.helper.JpaHelper;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

/**
 * @author pranjal.chakraborty
 * @since 5/11/17
 */
public class ItemDao {
    private static final String RETRIEVE_ITEM_QUERY = "SELECT i FROM Item i";

    public void addItem(Item item) {
        EntityManager em = JpaHelper.getEntityManager();
        em.getTransaction().begin();
        em.merge(item);
        em.getTransaction().commit();
        em.close();
    }

    public List<Item> generateItems() {
        EntityManager em = JpaHelper.getEntityManager();
        TypedQuery<Item> query = em.createQuery(RETRIEVE_ITEM_QUERY, Item.class);

        List<Item> items = query.getResultList();
        return items;
    }
}
