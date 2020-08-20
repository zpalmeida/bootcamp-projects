package org.academiadecodigo.bootcamp.positions;

import org.academiadecodigo.bootcamp.grids.EnemyDirection;
import org.academiadecodigo.bootcamp.grids.Grid;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public abstract class EnemyPosition {

    private Grid grid;
    private int col;
    private int row;
    private Picture picture;

    public EnemyPosition(Grid grid, int col, int row) {

        this.grid = grid;
        this.col = col;
        this.row = row;
    }

    public int getCol() {
        return col;
    }

    public int getRow () {
        return row;
    }

    protected int y() {
        return row * grid.getCellHeight() + Grid.PADDING;
    }

    protected void setPicture(Picture picture) {
        this.picture = picture;
    }

    private void moveRight() {
        if (col == grid.getCols() - 1) {
            picture.translate(- grid.getWidth() + grid.getCellWidth(), 0);
            col = 0;
            return;
        }
        picture.translate(grid.getCellWidth(), 0);
        col++;
    }

    private void moveLeft() {
        if (col == 0) {
            picture.translate(grid.getWidth() - grid.getCellWidth(), 0);
            col = grid.getCols() - 1;
            return;
        }
        picture.translate(- grid.getCellWidth(), 0);
        col--;
    }

    public void move(EnemyDirection direction){
        switch (direction) {
            case LEFT:
                moveLeft();
                break;
            case RIGHT:
                moveRight();
                break;
        }
    }
}
