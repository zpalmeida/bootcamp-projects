package org.academiadecodigo.bootcamp;

public class Barrel extends GameObject implements Destroyable {

    private BarrelType barrelType;
    private int currentDamage;
    private boolean destroyed = isDestroyed();
    private String message = "You spotted a barrel.";

    public Barrel() {
        int rand = (int) (Math.random() * 5);
        switch (rand) {
            case 0:
                barrelType = BarrelType.METAL;
                break;

            case 1:
                barrelType = BarrelType.PLASTIC;
                break;

            default:
                barrelType = BarrelType.WOOD;
        }
        currentDamage = barrelType.getMaxDamage();
    }

    public int getCurrentDamage() {
        return currentDamage;
    }

    @Override
    String getMessage() {
        return message;
    }

    public void hit(int damage) {
        currentDamage = currentDamage - damage;
    }

    public boolean isDestroyed() {

        if (currentDamage < 0) {
            System.out.println("You destroyed the barrel.");
            return true;
        }
        return false;
    }
}
