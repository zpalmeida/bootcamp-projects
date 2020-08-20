package org.academiadecodigo.bootcamp;

public class Game {

    private GameObject[] gameObjects;
    private SniperRifle rifle = new SniperRifle();
    private int shotsFired = 0;

    public Game (int numberOfObjects) {

        gameObjects = createObjects(numberOfObjects);
        GameObject newObject;

        for (int i = 0; i < gameObjects.length; i++) {

            int random = (int) (Math.random() * 6);
            switch (random) {
                case 0:
                    newObject = new Tree();
                    break;

                case 1:
                    newObject = new Barrel();
                    break;

                case 2:
                    newObject = new ArmoredEnemy();
                    break;

                default:
                    newObject = new SoldierEnemy();

            }

            gameObjects[i] = newObject;
        }
    }

    public GameObject[] createObjects(int numberOfObjects) {

        return new GameObject[numberOfObjects];
    }

    public void start() {

        for (int i = 0; i < gameObjects.length; i++) {

            System.out.println(gameObjects[i].getMessage());

            if(gameObjects[i] instanceof Tree) {
            } else {

                Destroyable target = (Destroyable) gameObjects[i];

                while (target.isDestroyed() == false) {
                    rifle.shoot(target);
                    shotsFired++;
                }
            }
        }

        System.out.println("You have defeated all enemies.");
        System.out.println("Total shots fired: " + shotsFired);
    }
}
