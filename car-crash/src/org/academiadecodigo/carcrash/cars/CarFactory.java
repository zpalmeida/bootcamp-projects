package org.academiadecodigo.carcrash.cars;

import org.academiadecodigo.carcrash.field.Direction;
import org.academiadecodigo.carcrash.field.Field;
import org.academiadecodigo.carcrash.field.Position;

public class CarFactory {

    public static Car getNewCar() {

        int rand = (int) (Math.random() * Field.getHeight());
        int rand2 = (int) (Math.random() * Field.getWidth());
        int rand3 = (int) (Math.random() * 4);
        int rand4 = (int) (Math.random() * 6);

        Position initialPos = new Position();
        initialPos.setRow(rand);
        initialPos.setCol(rand2);

        Direction initialFacing;
        switch (rand3) {
            case 0:
                initialFacing = Direction.UP;
                break;
            case 1:
                initialFacing = Direction.DOWN;
                break;
            case 2:
                initialFacing = Direction.LEFT;
                break;
            default: //3
                initialFacing = Direction.RIGHT;
        }

        switch (Team.values()[rand4]) {
            case GREEN_DUCKS:
                return new GreenDucks(initialPos, initialFacing);

            case MELLOW_YELLOW:
                return new MellowYellow(initialPos, initialFacing);

            case MIDNIGHT_WISPS:
                return new MidnightWisps(initialPos, initialFacing);

            case RASPBERRY_RACERS:
                return  new RaspberryRacers(initialPos, initialFacing);

            case O_RANGERS:
                return new ORangers(initialPos, initialFacing);

            default: //HAZERS
                return new Hazers(initialPos, initialFacing);
        }
    }
}
