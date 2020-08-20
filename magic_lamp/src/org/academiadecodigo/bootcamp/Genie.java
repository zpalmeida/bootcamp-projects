package org.academiadecodigo.bootcamp;

public class Genie {

    private int wishesLeft = 3;

    public String[] names = {"Abbad", "Abdul", "Achmed", "Akeem", "Alif", "Amir", "Asim", "Bashir", "Bassam", "Fahim",
            "Fafid", "Farouk", "Fayez", "Fayyaad", "Fazil", "Hakim", "Halil", "Hamid", "Hazim", "Heydar", "Hussein",
            "Jabari", "Jafar", "Jahid", "Jamal", "Kalim", "Karim", "Kazim", "Khadim", "Khalid", "Mahmud", "Mansour",
            "Musharraf", "Mustafa", "Nadir", "Nazim", "Omar", "Qadir", "Qusay", "Rafiq", "Rakim", "Rashad", "Rauf",
            "Saladin", "Sami", "Samir", "Talib", "Tamir", "Tariq", "Yazid"};

    private String name = names[(int)(Math.random() * 50)];

    public String getName() {
        return name;
    }

    public int wishesLeft() {
        return wishesLeft;
    }

    public void setWishesLeft(int wishesLeft) {
        this.wishesLeft = wishesLeft;
    }

    public void wish(String wish) {

        if (this.wishesLeft == 0) {
            System.out.println("I have no more wishes to grant you.");
        } else {
            System.out.println("Your wish was granted!");
            this.wishesLeft--;
        }

    }
}
