package org.academiadecodigo.bootcamp.positions;

import org.academiadecodigo.bootcamp.Game;
import org.academiadecodigo.bootcamp.grids.Grid;
import org.academiadecodigo.bootcamp.grids.CharacterDirection;
import org.academiadecodigo.simplegraphics.pictures.Picture;


public abstract class CharacterPosition {

    private Grid grid;
    private int initialRow;
    private int col;
    private int row;
    private Picture picture;
    private Game game;

    public CharacterPosition(Grid grid) {

        this.grid = grid;
        col = grid.getCols() / 2;
        initialRow = grid.getRows() - 1;
        row = initialRow;
    }

    public int getCol() {
        return col;
    }

    public int getRow() {
        return row;
    }

    protected int x() {
        return col * grid.getCellWidth() + Grid.PADDING;
    }

    protected int initialY() {
        return initialRow * grid.getCellHeight() + Grid.PADDING;
    }

    protected void setPicture(Picture picture) {
        this.picture = picture;
    }

    public void setGame(Game game) {
        this.game = game;
    }

    public void moveUp() {
        if (row < 1) {
            return;
        }
        picture.translate(0, - grid.getCellHeight());
        row--;
    }

    public void moveDown() {
        if (row > grid.getRows() - 2) {
            return;
        }
        picture.translate(0, grid.getCellHeight());
        row++;
    }

    public void moveLeft() {
        if (col < 1) {
            return;
        }
        picture.translate(- grid.getCellWidth(), 0);
        col--;
    }

    public void moveRight() {
        if (col > grid.getCols() - 2) {
            return;
        }
        picture.translate(grid.getCellWidth(), 0);
        col++;
    }

    public void move(CharacterDirection direction) {

        switch (direction) {
            case UP:
                moveUp();
                break;
            case DOWN:
                moveDown();
                break;
            case RIGHT:
                moveRight();
                break;
            case LEFT:
                moveLeft();
                break;
        }
        game.checkCollision();
    }

    public void collide() {
        picture.translate(0, grid.getHeight() - (row + 1) * grid.getCellHeight());
        row = grid.getRows();
        col = grid.getRows();
    }
}
