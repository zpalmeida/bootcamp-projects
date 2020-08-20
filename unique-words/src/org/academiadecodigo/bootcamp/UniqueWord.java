package org.academiadecodigo.bootcamp;

import java.util.HashSet;
import java.util.Iterator;

public class UniqueWord extends HashSet<String> implements Iterable<String> {

    private HashSet set;

    public UniqueWord(String string) {

        set = new HashSet();

        String[] words = string.split(" ");

        for (String word : words) {
            set.add(word);
        }
    }

    @Override
    public Iterator iterator() {
        return set.iterator();
    }
}
