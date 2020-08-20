package org.academiadecodigo.bootcamp;

public class ScientificProcessor extends Processor {

    @Override
    public double calculate(Operation operation, double number1, double number2) {

        if (operation == Operation.ADD ||
                operation == Operation.SUBTRACT ||
                operation == Operation.MULTIPLY ||
                operation == Operation.DIVIDE) {

            return super.calculate(operation, number1, number2);
        }

        switch (operation) {

            case EXPONENTIATE:
                return Math.pow(number1, number2);

            default: //LOGARITHM
                return Math.log(number1) / Math.log(number2);
        }
    }

    public double trigonometry(Trigonometric function, double number) {

        switch (function) {

            case SINE:
                return Math.sin(number);

            case COSINE:
                return Math.cos(number);

            default: //TANGENT
                return Math.tan(number);

        }
    }
}
