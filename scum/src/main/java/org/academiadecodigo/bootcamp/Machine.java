package org.academiadecodigo.bootcamp;

public class Machine {

    public int calculate(int value, MonoOperation<Integer> operation) {

        return operation.transform(value);
    }

    public int calculate(int a, int b, BiOperation<Integer> operation) {

        return operation.transform(a, b);
    }

    public String editText(String string, MonoOperation<String> operation) {

        return operation.transform(string);
    }

    public String editText(String string1, String string2, BiOperation<String> operation) {

        return operation.transform(string1, string2);
    }
}
