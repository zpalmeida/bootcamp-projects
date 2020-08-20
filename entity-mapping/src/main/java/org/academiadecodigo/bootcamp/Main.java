package org.academiadecodigo.bootcamp;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.RollbackException;

public class Main {

    public static void main(String[] args) {

        EntityManagerFactory managerFactory = Persistence.createEntityManagerFactory("unit");
        EntityManager entityManager = managerFactory.createEntityManager();

        EntityClass first = new EntityClass();
        first.setName("first");

        EntityClass second = new EntityClass();
        second.setName("second");

        EntityClass third = new EntityClass();
        third.setName("third");

        try {
            entityManager.getTransaction().begin();
            entityManager.persist(first);
            entityManager.persist(second);
            entityManager.persist(third);
            entityManager.getTransaction().commit();

        } catch (RollbackException ex) {
            entityManager.getTransaction().rollback();

        } finally {
            entityManager.close();
        }
    }
}
