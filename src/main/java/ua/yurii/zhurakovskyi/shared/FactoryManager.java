package ua.yurii.zhurakovskyi.shared;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class FactoryManager {

    private static EntityManagerFactory entityManagerFactory;
    private static EntityManager entityManager;

    private static EntityManagerFactory getEntityManagerFactory(){
        if (entityManagerFactory == null){
            entityManagerFactory = Persistence.createEntityManagerFactory("IShopPersistence");
        }
        return entityManagerFactory;
    }

    public static EntityManager getEntityManager(){
        if (entityManager == null){
            entityManager = getEntityManagerFactory().createEntityManager();
        }
        return entityManager;
    }
}
