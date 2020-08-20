package org.academiadecodigo.bootcamp;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.RollbackException;

public class Main {

    public static void main(String[] args) {

        EntityManagerFactory managerFactory = Persistence.createEntityManagerFactory("unit");
        EntityManager entityManager = managerFactory.createEntityManager();

        Student student = new Student();
        student.setName("Godofredo");

        Address address = new Address();
        address.setCity("Reykjavik");
        address.setStreet("Tryggvagata");
        address.setzIPCode("101");

        student.setAddress(address);

        try {
            entityManager.getTransaction().begin();
            entityManager.persist(student);
            entityManager.getTransaction().commit();

        } catch (RollbackException ex) {
            entityManager.getTransaction().rollback();

        } finally {
            entityManager.close();
        }
    }
}
