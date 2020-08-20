package org.academiadecodigo.bootcamp;

public class Processor {

    public double calculate(Operation operation, double number1, double number2) {

        switch (operation) {

            case SUBTRACT:
                return number1 - number2;

            case MULTIPLY:
                return number1 * number2;

            case DIVIDE:
                return number1 / number2;

            default: //ADD
                return number1 + number2;

        }
    }
}
