package org.academiadecodigo.bootcamp.objects;

import org.academiadecodigo.bootcamp.Theme;
import org.academiadecodigo.bootcamp.grids.EnemyDirection;
import org.academiadecodigo.bootcamp.grids.Grid;
import org.academiadecodigo.bootcamp.positions.EnemyPosition;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Enemy extends EnemyPosition {

    private EnemyDirection direction;

    public Enemy(Theme theme, Grid grid, int col, int row, EnemyDirection direction) {

        super(grid, col, row);
        this.direction = direction;
        Picture enemy;
        String picture;

        switch (theme) {
            case POKEMON:
                if (direction == EnemyDirection.RIGHT) {
                    picture = "balldir.png";
                    break;
                }
                picture = "ballesq.png";
                break;

            case CATS:
                if (direction == EnemyDirection.RIGHT) {
                    picture = "gato.png";
                    break;
                }
                picture = "gato_left.png";
                break;

            case RICK_AND_MORTY:
                if (direction == EnemyDirection.RIGHT) {
                    picture = "ratdir.png";
                    break;
                }
                picture = "ratesq.png";
                break;

            default:
                if (direction == EnemyDirection.RIGHT) {
                    picture = "cart.png";
                    break;
                }
                picture = "cartesq.png";
        }


        enemy = new Picture(grid.getCellWidth() * col + Grid.PADDING, super.y(), picture);

        super.setPicture(enemy);
        enemy.draw();
    }

    public EnemyDirection getDirection() {
        return direction;
    }
}
