package org.academiadecodigo.bootcamp;

public class GrumpyGenie extends Genie {

    @Override
    public void wish(String wish) {

        if (wishesLeft() == 3) {
            System.out.println("Your wish was granted!");
            setWishesLeft(2);

        } else {
            System.out.println("I don't feel like granting you more wishes.");
        }

    }
}
