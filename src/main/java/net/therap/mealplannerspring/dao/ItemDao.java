package net.therap.mealplannerspring.dao;

import net.therap.mealplannerspring.domain.Item;
import org.springframework.stereotype.Repository;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;

/**
 * @author pranjal.chakraborty
 * @since 5/11/17
 */
@Repository
public class ItemDao {
    private static final String RETRIEVE_ITEM_QUERY = "SELECT i FROM Item i";

    @PersistenceContext
    private EntityManager em;

    @Transactional
    public void addItem(Item item) {
        em.persist(item);
    }

    @Transactional
    public List<Item> generateItems() {
        TypedQuery<Item> query = em.createQuery(RETRIEVE_ITEM_QUERY, Item.class);

        List<Item> items = query.getResultList();
        return items;
    }
}
