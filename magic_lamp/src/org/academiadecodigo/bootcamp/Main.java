package org.academiadecodigo.bootcamp;

public class Main {

    public static void main(String[] args) {

        MagicLamp lamp = new MagicLamp(3);

        System.out.println(lamp.geniesInLamp());

        Genie genie = lamp.rub();
        genie.wish("I want a helmet.");
        genie.wish("I want a motorcycle.");

        lamp.rub();
        lamp.rub();

        Genie demon = lamp.rub();
        demon.wish("I want infinite wishes.");

        lamp.recycleDemon(demon);

        System.out.println(lamp.checkTimesRecharged());
        System.out.println(lamp.geniesInLamp());

        MagicLamp anotherLamp = new MagicLamp(3);

        lamp.compare(anotherLamp);

    }
}
