package org.academiadecodigo.bootcamp;

public class Main {

    public static void main(String[] args) {

        ScientificCalculator calculator = new ScientificCalculator("Murrey");
        Calculator c = new Calculator("Sepia");

        calculator.execute(Operation.LOGARITHM, 2, 3);
        c.execute(Operation.ADD, 2, 3);
        System.out.println(calculator.getBrand());

    }

}
