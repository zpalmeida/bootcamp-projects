package org.academiadecodigo.carcrash.field;

import org.academiadecodigo.carcrash.cars.Car;

public class Position {

    private int col;
    private int row;

    public int getCol() {
        return col;
    }

    public int getRow() {
        return row;
    }

    public void setCol(int col) {
        this.col = col;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public void moveUP(int row, Car car) {
        car.setFacing(Direction.UP);
        if (row == 0) {
            bounce(car);
        } else {
            this.row--;
        }
    }

    public void moveDown(int row, Car car) {
        car.setFacing(Direction.DOWN);
        if (row == Field.getHeight() - 1) {
            bounce(car);
        } else {
            this.row++;
        }
    }

    public void moveLeft(int col, Car car) {
        car.setFacing(Direction.LEFT);
        if (col == 0) {
            bounce(car);
        } else {
            this.col--;
        }
    }

    public void moveRight(int col, Car car) {
        car.setFacing(Direction.RIGHT);
        if (col == Field.getWidth() - 1) {
            bounce(car);
        } else {
            this.col++;
        }
    }

    public void bounce(Car car) {
        switch (car.getFacing()) {
            case UP:
                moveDown(this.row, car);
                break;

            case DOWN:
                moveUP(this.row, car);
                break;

            case LEFT:
                moveRight(this.col, car);
                break;

            default: //RIGHT
                moveLeft(this.col, car);
        }
    }

    public boolean comparePosition(Position position) {
        if (this.col == position.getCol() && this.row == position.getRow()) {
            return true;
        } else {
            return false;
        }
    }
}
