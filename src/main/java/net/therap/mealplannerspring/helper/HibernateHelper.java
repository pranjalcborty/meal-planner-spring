package net.therap.mealplannerspring.helper;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author pranjal.chakraborty
 * @since 5/14/17
 */
public class HibernateHelper {
    private static SessionFactory sessionFactory;

    static {
        Logger.getLogger("org.hibernate").setLevel(Level.OFF);

        Configuration configuration = new Configuration().configure();
        StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder().
                applySettings(configuration.getProperties());
        sessionFactory = configuration.buildSessionFactory(builder.build());
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
}
