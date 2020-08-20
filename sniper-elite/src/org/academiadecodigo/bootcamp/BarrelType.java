package org.academiadecodigo.bootcamp;

public enum BarrelType {

    PLASTIC(150),
    WOOD(50),
    METAL(100);

    private int maxDamage;

    BarrelType(int maxDamage) {
        this.maxDamage = maxDamage;
    }

    public int getMaxDamage() {
        return maxDamage;
    }
}
