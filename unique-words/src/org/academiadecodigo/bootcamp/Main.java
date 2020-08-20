package org.academiadecodigo.bootcamp;

public class Main {

    public static void main(String[] args) {

        String words = "rui rui rui campelo campelo campelo test abc";
        UniqueWord wc = new UniqueWord(words);

        for (String word : wc) {
            System.out.println(word);
        }
    }
}
