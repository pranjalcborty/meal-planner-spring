package net.therap.mealplannerspring.helper;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JpaHelper {

    private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa");

    public static EntityManager getEntityManager() {
        return emf.createEntityManager();
    }
}
