package org.academiadecodigo.bootcamp;

public class Demon extends Genie {

    private boolean recycled = false;

    public boolean isRecycled() {
        return recycled;
    }

    public void setRecycled(boolean recycled) {
        this.recycled = recycled;
    }

    @Override
    public void wish(String wish) {

        if (this.isRecycled() == true) {
            System.out.println("That demon was already recycled.");

        } else {
            System.out.println("Your wish was granted... For a price. Mwahahaha!");
        }
    }
}
