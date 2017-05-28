package net.therap.mealplannerspring.dao;

import net.therap.mealplannerspring.domain.User;
import net.therap.mealplannerspring.helper.JpaHelper;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

/**
 * @author pranjal.chakraborty
 * @since 20-May-17
 */
public class UserDao {
    private static final String RETRIEVE_USER_QUERY = "SELECT u FROM User u";

    public void addUser(User user) {
        EntityManager em = JpaHelper.getEntityManager();
        em.getTransaction().begin();
        em.merge(user);
        em.getTransaction().commit();
        em.close();
    }

    public boolean contains(String uName) {
        EntityManager em = JpaHelper.getEntityManager();
        TypedQuery<User> query = em.createQuery(RETRIEVE_USER_QUERY, User.class);

        List<User> users = query.getResultList();

        for (User user : users) {
            if (user.getUname().equals(uName)) {
                return true;
            }
        }

        return false;
    }

    public boolean isAllowed(String uName, String pass) {
        EntityManager em = JpaHelper.getEntityManager();
        TypedQuery<User> query = em.createQuery(RETRIEVE_USER_QUERY, User.class);

        List<User> users = query.getResultList();

        for (User user : users) {
            if (user.getUname().equals(uName) && user.getPass().equals(pass)) {
                return true;
            }
        }

        return false;
    }
}
