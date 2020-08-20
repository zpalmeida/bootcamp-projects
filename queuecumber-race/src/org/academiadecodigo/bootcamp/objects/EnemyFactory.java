package org.academiadecodigo.bootcamp.objects;

import org.academiadecodigo.bootcamp.Theme;
import org.academiadecodigo.bootcamp.grids.EnemyDirection;
import org.academiadecodigo.bootcamp.grids.Grid;

public class EnemyFactory {

    private boolean uniqueness(int[] array, int value) {

        for (int i : array) {
            if (i == value) {
                return false;
            }
        }
        return true;
    }

    public int[] positions(int length, int max) {

        int[] cols = new int[length];
        int i = 0;

        while (i < length) {
            int value = 1 + (int) (Math.random() * max);

            if (uniqueness(cols, value)) {
                cols[i] = value;
                i++;
            }
        }
        return cols;
    }

    private int[] enemiesPerRow(Grid grid) {

        int[] enemiesPerRow = new int[grid.getRows() - 3];

        for (int i = 0; i < enemiesPerRow.length; i++) {
            int numberOfEnemies = 1 + (int) (Math.random() * (grid.getCols() - 2));

            enemiesPerRow[i] = numberOfEnemies;
        }
        return enemiesPerRow;
    }

    private int sum(int[] arr) {

        int r = 0;

        for (int i : arr) {
            r += i;
        }
        return r;
    }

    public Enemy[] createEnemies(Theme theme, Grid grid) {

        int[] enemiesPerRow = enemiesPerRow(grid);

        Enemy[] enemies = new Enemy[sum(enemiesPerRow)];
        int k = 0;

        for (int j = 1; j < grid.getRows() - 2; j++) {

            int[] positions;
            positions = positions(enemiesPerRow[j - 1], grid.getCols() - 1);

            EnemyDirection direction;

            if (j % 2 == 0) {
                direction = EnemyDirection.LEFT;
            } else {
                direction = EnemyDirection.RIGHT;
            }

            for (int i = 0; i < enemiesPerRow[j - 1]; i++) {

                enemies[k] = new Enemy(theme, grid, positions[i] - 1, j, direction);
                k++;
            }
        }
        return enemies;
    }
}
