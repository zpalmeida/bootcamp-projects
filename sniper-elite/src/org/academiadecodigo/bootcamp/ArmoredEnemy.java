package org.academiadecodigo.bootcamp;

public class ArmoredEnemy extends Enemy {

    private int armor = 200;

    public int getArmor() {
        return armor;
    }

    @Override
    public void hit (int damage) {

        if (armor > 0) {
            armor = armor - damage;
            return;
        }

        super.hit(damage);

    }
}
