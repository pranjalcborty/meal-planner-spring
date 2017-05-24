package net.therap.mealplannerspring.dao;

import net.therap.mealplannerspring.domain.Item;
import net.therap.mealplannerspring.helper.HibernateHelper;
import org.hibernate.Query;
import org.hibernate.Session;

import java.util.ArrayList;
import java.util.List;

/**
 * @author pranjal.chakraborty
 * @since 5/11/17
 */
public class ItemDao {

    public void addItem(String itemName) {
        Item item = new Item();
        item.setName(itemName);

        Session session = HibernateHelper.getSessionFactory().openSession();
        session.beginTransaction();
        session.save(item);
        session.getTransaction().commit();
        session.close();
    }

    public List<Item> generateItems() {
        Session session = HibernateHelper.getSessionFactory().openSession();
        Query query = session.createQuery("FROM Item");

        List<Item> items = query.list();
        session.close();
        return items;
    }

    public List<Item> getItems(List<String> tokens) {
        List<Item> items = new ArrayList<>();

        for (String token : tokens) {
            Session session = HibernateHelper.getSessionFactory().openSession();
            items.add((Item) session.get(Item.class, Long.parseLong(token)));
        }
        return items;
    }
}
