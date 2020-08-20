package org.academiadecodigo.bootcamp;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class HelloWorld {

    public static void main(String[] args) {

        EntityManagerFactory eMF = Persistence.createEntityManagerFactory("test");

        EntityManager eM = eMF.createEntityManager();

        System.out.println("Result: " + eM.createNativeQuery("SELECT 1+1").getSingleResult());

        eM.close();
        eMF.close();
    }
}
