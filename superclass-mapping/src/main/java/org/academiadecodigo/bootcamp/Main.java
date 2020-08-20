package org.academiadecodigo.bootcamp;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.RollbackException;

public class Main {

    public static void main(String[] args) {

        EntityManagerFactory managerFactory = Persistence.createEntityManagerFactory("unit");
        EntityManager entityManager = managerFactory.createEntityManager();

        Customer customer = new Customer();
        customer.setName("Alceste");

        Account account = new Account();
        account.setBalance(420d);

        try {
            entityManager.getTransaction().begin();
            entityManager.persist(customer);
            entityManager.persist(account);
            entityManager.getTransaction().commit();

        } catch (RollbackException ex) {
            entityManager.getTransaction().rollback();

        } finally {
            entityManager.close();
        }
    }
}
