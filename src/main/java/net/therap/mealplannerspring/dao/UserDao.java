package net.therap.mealplannerspring.dao;

import net.therap.mealplannerspring.domain.User;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;

/**
 * @author pranjal.chakraborty
 * @since 20-May-17
 */
@Repository
public class UserDao {

    private static final String RETRIEVE_USER_QUERY = "SELECT u FROM User u";

    @PersistenceContext
    private EntityManager em;

    @Transactional
    public void addUser(User user) {
        em.persist(user);
    }

    @Transactional
    public List<User> getUsers() {
        TypedQuery<User> query = em.createQuery(RETRIEVE_USER_QUERY, User.class);
        List<User> users = query.getResultList();

        return users;
    }

    @Transactional
    public boolean isAllowed(String uName, String pass) {
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
