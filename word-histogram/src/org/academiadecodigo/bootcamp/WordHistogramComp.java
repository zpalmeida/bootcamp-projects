package org.academiadecodigo.bootcamp;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class WordHistogramComp implements Iterable<String> {

    private Map<String, Integer> map;

    public WordHistogramComp (String string) {

        map = new HashMap();

        for (String word : string.split(" ")) {

            if(map.containsKey(word) == false) {
                map.put(word, 1);
                continue;
            }
            map.replace(word, map.get(word) + 1);
        }
    }

    public int size() {
        return map.size();
    }

    public Integer get(Object key) {
        return map.get(key);
    }

    @Override
    public Iterator iterator() {
        return map.keySet().iterator();
    }
}
