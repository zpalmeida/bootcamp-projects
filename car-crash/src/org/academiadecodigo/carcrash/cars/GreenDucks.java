package org.academiadecodigo.carcrash.cars;

import org.academiadecodigo.carcrash.field.Direction;
import org.academiadecodigo.carcrash.field.Position;

public class GreenDucks extends Car {

    public GreenDucks(Position initialPos, Direction facing) {
        super(initialPos, facing);
    }

    @Override

    public String toString() {
        return "G";
    }
}
