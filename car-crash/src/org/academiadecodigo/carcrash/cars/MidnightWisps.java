package org.academiadecodigo.carcrash.cars;

import org.academiadecodigo.carcrash.field.Direction;
import org.academiadecodigo.carcrash.field.Position;

public class MidnightWisps extends Car {

    public MidnightWisps(Position initialPos, Direction facing) {
        super(initialPos, facing);
    }

    @Override

    public void move() {
        super.move();
        super.move();
        super.move();
    }

    public String toString() {
        return "M";
    }

}
