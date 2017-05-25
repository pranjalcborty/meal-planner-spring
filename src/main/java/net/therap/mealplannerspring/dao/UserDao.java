package net.therap.mealplannerspring.dao;

import net.therap.mealplannerspring.domain.User;
import net.therap.mealplannerspring.helper.HibernateHelper;
import org.hibernate.Query;
import org.hibernate.Session;

import java.util.List;

/**
 * @author pranjal.chakraborty
 * @since 20-May-17
 */
public class UserDao {

    public boolean addUser(String fullName, String uName, String pass) {
        if (!contains(uName)) {
            User user = new User();
            user.setFullName(fullName);
            user.setUname(uName);
            user.setPass(pass);

            Session session = HibernateHelper.getSessionFactory().openSession();
            session.beginTransaction();
            session.save(user);
            session.getTransaction().commit();
            session.close();

            return true;
        }

        return false;
    }

    public boolean contains(String uName) {
        Session session = HibernateHelper.getSessionFactory().openSession();
        Query query = session.createQuery("FROM User");

        List<User> users = query.list();

        for (User user : users) {
            if (user.getUname().equals(uName)) {
                return true;
            }
        }

        return false;
    }

    public boolean isAllowed(String uName, String pass) {
        Session session = HibernateHelper.getSessionFactory().openSession();
        Query query = session.createQuery("FROM User");

        List<User> users = query.list();

        for (User user : users) {
            if (user.getUname().equals(uName) && user.getPass().equals(pass)) {
                return true;
            }
        }

        return false;
    }
}
