package org.academiadecodigo.bootcamp;

public class ScientificCalculator extends Calculator {

    private ScientificProcessor processor;

    public ScientificCalculator(String color) {

        super(color);
        upgradeProcessor();

    }
}
