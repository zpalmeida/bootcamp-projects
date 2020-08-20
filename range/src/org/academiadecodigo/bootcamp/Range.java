package org.academiadecodigo.bootcamp;

import java.util.Iterator;

public class Range implements Iterable<Integer> {

    public Range(int min, int max, Direction direction) {
        
    }

    @Override
    public Iterator<Integer> iterator() {

        return new Iterator<Integer>() {
            @Override
            public boolean hasNext() {
                return false;
            }

            @Override
            public Integer next() {
                return null;
            }
        };
    }

    public enum Direction {
        ASCENDING,
        DESCENDING;
    }
}
