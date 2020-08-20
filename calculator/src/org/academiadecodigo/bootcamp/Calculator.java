package org.academiadecodigo.bootcamp;

public class Calculator {

    private String brand = "Hazers";
    private String color;
    private Processor processor;
    private Display display;

    public Calculator(String color) {

        this.color = color;
        processor = new Processor();
        display = new Display();

    }

    public String getColor() {
        return color;
    }

    public String getBrand() {
        return brand;
    }

    public void upgradeProcessor() {
        this.processor = new ScientificProcessor();
    }

    public void execute(Operation operation, double number1, double number2) {

        double result = processor.calculate(operation, number1, number2);
        display.display(result);

    }
}
