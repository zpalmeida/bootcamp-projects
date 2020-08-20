package org.academiadecodigo.bootcamp;

import org.academiadecodigo.bootcamp.grids.Background;
import org.academiadecodigo.bootcamp.objects.Character;
import org.academiadecodigo.bootcamp.objects.Enemy;
import org.academiadecodigo.bootcamp.objects.EnemyFactory;
import org.academiadecodigo.bootcamp.objects.Score;

public class Game {

    private Background grid;
    private Character player;
    private KeyBind keyboard;
    private Theme theme;
    private Score score;
    private MenuKeyBind menuKeyboard;
    private Menu menu;
    private EnemyFactory factory;
    private static int DELAY_INICIAL = 2000;
    private int delay = DELAY_INICIAL;
    private Enemy[] enemies;
    private boolean isCollided;
    private int level = 1;


    public void init() throws InterruptedException {
        menu = new Menu();
        menuKeyboard = new MenuKeyBind();
        menuKeyboard.initMenu();

        while (!menuKeyboard.isSpacePressed()) {
            Thread.sleep(50);
        }

        start();
    }

    public void start() throws InterruptedException {
        menuKeyboard.disable();
        theme = menuKeyboard.getTheme();
        grid = new Background(theme);
        player = new Character(theme, grid);
        player.setGame(this);
        keyboard = new KeyBind(player);
        factory = new EnemyFactory();
        enemies = factory.createEnemies(theme, grid);
        score = new Score(grid, level);
        isCollided = false;

        keyboard.init();

        while (!isCollided) {

            if (player.getRow() == 0) {
                level++;
                delay -= 100;
                start();
            }

            Thread.sleep(delay);
            moveEnemies();
            checkCollision();



        }
        level = 1;
        delay = DELAY_INICIAL;
        start();
    }

    private void moveEnemies() {

        for (Enemy enemy : enemies) {
            enemy.move(enemy.getDirection());
        }
    }

    public void checkCollision () {

        for (Enemy e : enemies) {
            if (e.getCol() == player.getCol() && e.getRow() == player.getRow()) {
                player.collide();
                isCollided = true;
            }
        }
    }

}
