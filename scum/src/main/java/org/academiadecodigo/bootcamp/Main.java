package org.academiadecodigo.bootcamp;

public class Main {

    public static void main(String[] args) {

        Machine machine = new Machine();

        int result1 = machine.calculate(3, 5, (a, b) -> a + b);

        int result2 = machine.calculate(6, value -> value ^ 2);

        String string1 = machine.editText("Some string.", String::toUpperCase);

        String string2 = machine.editText("Zé", "Pedro", (s1, s2) -> s1 + " " + s2);

        System.out.println(result1);
        System.out.println(result2);
        System.out.println(string1);
        System.out.println(string2);

    }
}
