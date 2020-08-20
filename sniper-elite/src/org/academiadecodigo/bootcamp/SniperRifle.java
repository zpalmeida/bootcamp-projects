package org.academiadecodigo.bootcamp;

public class SniperRifle {

    private int bulletDamage = 50;

    public void shoot(Destroyable target) {

        if (target instanceof Barrel) {
            target.hit(bulletDamage);
            System.out.println("You hit the barrel.");
            return;

        } else if (target instanceof ArmoredEnemy) {
            ArmoredEnemy armoredEnemy = (ArmoredEnemy) target;

            if (armoredEnemy.getArmor() > 0) {
                target.hit(bulletDamage);
                System.out.println("You hit the enemy's armor!");
                return;
            }
        }

        int random = (int) (Math.random() * 7);
        switch (random) {
            case 0:
                target.hit(bulletDamage * 2);
                System.out.println("Headshot!");
                break;

            case 1:
                target.hit(bulletDamage / 2);
                System.out.println("You hit the enemy in the arm!");
                break;

            case 2:
                target.hit(bulletDamage / 2);
                System.out.println("You hit the enemy in the leg!");
                break;

            default:
                target.hit(bulletDamage);
                System.out.println("You hit the enemy!");
        }
    }
}
