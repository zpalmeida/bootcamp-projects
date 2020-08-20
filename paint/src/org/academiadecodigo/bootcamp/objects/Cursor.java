package org.academiadecodigo.bootcamp.objects;

import org.academiadecodigo.bootcamp.Canvas;
import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;

public class Cursor {

    private Rectangle cursor;
    private final Color color = Color.GREEN;
    private int x = Canvas.PADDING;
    private int y = Canvas.PADDING;

    public Cursor () {

        cursor = new Rectangle(x, y, Canvas.CELL_SIDE_LENGTH, Canvas.CELL_SIDE_LENGTH);
        cursor.setColor(color);
        cursor.fill();
    }

    public Rectangle getCursor() {
        return cursor;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    private void moveUp() {
        if (y <= Canvas.PADDING) {
            return;
        }
        cursor.translate(0, - Canvas.CELL_SIDE_LENGTH);
        y -= Canvas.CELL_SIDE_LENGTH;
    }

    private void moveDown() {
        if (y >= Canvas.PADDING + Canvas.CELL_SIDE_LENGTH * (Canvas.ROWS - 1)) {
            return;
        }
        cursor.translate(0, Canvas.CELL_SIDE_LENGTH);
        y += Canvas.CELL_SIDE_LENGTH;
    }

    private void moveLeft() {
        if (x <= Canvas.PADDING) {
            return;
        }
        cursor.translate(- Canvas.CELL_SIDE_LENGTH, 0);
        x -= Canvas.CELL_SIDE_LENGTH;
    }

    private void moveRight() {
        if (x >= Canvas.PADDING + Canvas.CELL_SIDE_LENGTH * (Canvas.COLUMNS - 1)) {
            return;
        }
        cursor.translate(Canvas.CELL_SIDE_LENGTH, 0);
        x += Canvas.CELL_SIDE_LENGTH;
    }

    public void move(Direction direction) {

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
    }

    public enum Direction {

        UP,
        DOWN,
        LEFT,
        RIGHT;
    }
}
