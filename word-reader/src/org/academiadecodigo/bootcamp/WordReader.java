package org.academiadecodigo.bootcamp;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;
import java.util.LinkedList;

public class WordReader implements Iterable<String>  {

    private LinkedList<String> words;
    private String word;
    private FileReader reader;

    public WordReader(String path) {

        try {

            words = new LinkedList();
            reader = new FileReader(path);
            BufferedReader bReader = new BufferedReader(reader);

            String line;

            while ((line = bReader.readLine()) != null) {

                for (String word : line.split(" ")) {
                    words.add(word);
                }
            }
            bReader.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Iterator<String> iterator() {

        return new Iterator<String>() {

            @Override
            public boolean hasNext() {
                return word != null;
            }

            @Override
            public String next() {
                return word;
            }
        };
    }
}
