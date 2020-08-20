package org.academiadecodigo.bootcamp;

import java.util.stream.Stream;

public class MapFilterReduce {

    private static String message = "I'll send an SOS to the garbage world, " +
            "I hope that someone garbage gets my message in a garbage bottle.";

    public static void main(String[] args) {

        String transformedMessage = Stream.of(message.split(" "))
                .filter(word -> !word.equals("garbage"))
                .map(word -> word.toUpperCase())
                .reduce("", (acc, word) -> acc + word + " ");

        System.out.println(transformedMessage);
    }
}
