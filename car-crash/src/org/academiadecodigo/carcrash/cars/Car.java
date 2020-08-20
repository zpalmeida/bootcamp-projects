package org.academiadecodigo.carcrash.cars;

import org.academiadecodigo.carcrash.field.Direction;
import org.academiadecodigo.carcrash.field.Position;

abstract public class Car {

    /** The position of the car on the grid */
    private Position pos;
    private Direction facing;
    private boolean crashed = false;

    public Car(Position initialPos, Direction initialFacing) {
        this.pos = initialPos;
        this.facing = initialFacing;
    }

    public Position getPos() {
        return pos;
    }

    public Direction getFacing() {
        return facing;
    }

    public void setFacing(Direction facing) {
        this.facing = facing;
    }

    public void setCrashed() {
        this.pos.bounce(this);
        this.crashed = true;
    }

    public void turnLeftOrRight() {
        int rand = (int) (Math.random() * 2);
        if (rand == 0) {
            pos.moveRight(pos.getCol(), this);
        } else {
            pos.moveLeft(pos.getCol(), this);
        }
    }

    public void turnUpOrDown() {
        int rand = (int) (Math.random() * 2);
        if (rand == 0) {
            pos.moveUP(pos.getRow(), this);
        } else {
            pos.moveDown(pos.getRow(), this);
        }
    }

    public void move() {

        if (this.crashed == true) {
        } else {

            int rand = (int) (Math.random() * 3);
            if (rand == 0 || rand == 1) {
                switch (this.facing) {
                    case UP:
                        pos.moveUP(pos.getRow(), this);
                        break;

                    case DOWN:
                        pos.moveDown(pos.getRow(), this);
                        break;

                    case LEFT:
                        pos.moveLeft(pos.getCol(), this);
                        break;

                    default: //Right
                        pos.moveRight(pos.getCol(), this);
                }

            } else {
                switch (facing) {
                    case UP:
                    case DOWN:
                        turnLeftOrRight();
                        break;

                    default: //Left and Right
                        turnUpOrDown();
                }
            }
        }
    }

    public boolean isCrashed() {
        if (this.crashed == true) {
            return true;
        } else {
            return false;
        }
    }
}
