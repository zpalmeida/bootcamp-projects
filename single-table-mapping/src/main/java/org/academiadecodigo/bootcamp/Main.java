package org.academiadecodigo.bootcamp;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.RollbackException;

public class Main {

    public static void main(String[] args) {

        EntityManagerFactory managerFactory = Persistence.createEntityManagerFactory("unit");
        EntityManager entityManager = managerFactory.createEntityManager();

        Boat boat = new Boat();
        boat.setEngines(4);
        boat.setMaxSpeed(510);

        Car car = new Car();
        car.setGears(6);
        car.setMaxSpeed(420);

        try {
            entityManager.getTransaction().begin();
            entityManager.persist(boat);
            entityManager.persist(car);
            entityManager.getTransaction().commit();

        } catch (RollbackException ex) {
            entityManager.getTransaction().rollback();

        } finally {
            entityManager.close();
        }
    }
}
