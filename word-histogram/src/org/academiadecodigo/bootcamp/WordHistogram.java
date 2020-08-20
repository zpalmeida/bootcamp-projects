package org.academiadecodigo.bootcamp;

import java.util.HashMap;
import java.util.Iterator;

public class WordHistogram extends HashMap<String, Integer> implements Iterable<String> {

    public WordHistogram (String string) {

        for (String word : string.split(" ")) {

            if(containsKey(word) == false) {
                put(word, 1);
                continue;
            }
            replace(word, get(word) + 1);
        }
    }

    @Override
    public Iterator iterator() {
        return keySet().iterator();
    }
}
