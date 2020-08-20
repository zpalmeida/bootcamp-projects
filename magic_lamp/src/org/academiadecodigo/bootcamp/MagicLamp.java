package org.academiadecodigo.bootcamp;

public class MagicLamp {

    private int lampCapacity;
    private int geniesInLamp;
    private int timesRecharged = 0;

    public MagicLamp(int capacity) {
        this.lampCapacity = capacity;
        this.geniesInLamp = (int)(1 + Math.random() * this.lampCapacity);
    }

    public int geniesInLamp() {
        return geniesInLamp;
    }

    public int checkCapacity() {
        return lampCapacity;
    }

    public int checkTimesRecharged() {
        return timesRecharged;
    }

    public Genie rub() {

        if (geniesInLamp == 0) {

            System.out.println("A demon has emerged from the lamp!");
            return new Demon();

        } else {

            int grumpy = (int) (Math.random() * 2);
            System.out.println("A genie has emerged from the lamp!");
            this.geniesInLamp--;

            switch (grumpy) {

                case 0:
                    return new GrumpyGenie();

                default:
                    return new Genie();

            }
        }
    }

    public void recycleDemon(Genie genie) {

        if (genie.getClass() == Demon.class) {

            this.geniesInLamp = this.lampCapacity;
            this.timesRecharged++;
            Demon demon = (Demon) genie;
            demon.setRecycled(true);
            System.out.println(genie.getName() + " was sucked back into the lamp. The lamp was recharged.");

        } else {
            System.out.println("Dude! I'm a jinn! You cannot recycle me! Do I look like a demon to you?!");
        }
    }

    public void compare(MagicLamp lampToCompareWith) {

        if (this.lampCapacity == lampToCompareWith.lampCapacity) {
            System.out.println("These lamps have the same genie capacity.");
        } else {
            System.out.println("These lamps have different capacities.");
        }

        if (this.geniesInLamp == lampToCompareWith.geniesInLamp) {
            System.out.println("These lamps have the same amount of genies.");
        } else {
            System.out.println("These lamps have a different amount of genies.");
        }

        if (this.timesRecharged == lampToCompareWith.timesRecharged) {
            System.out.println("These lamps were recycled the same amount of times.");
        } else {
            System.out.println("These lamps were recycled a different number of times.");
        }
    }
}
