package org.academiadecodigo.bootcamp;

abstract class Enemy extends GameObject implements Destroyable {

    private String message = "You spotted something. It's an enemy!";
    private int health = 100;
    private boolean dead = isDead();

    public boolean isDead() {
        if (health < 0) {
            System.out.println("You killed the enemy.");
            return true;
        }
        return false;
    }

    @Override
    public void hit(int damage) {
        health = health - damage;
    }

    public String getMessage() {
        return message;
    }

    public boolean isDestroyed() {
        return isDead();
    }
}
