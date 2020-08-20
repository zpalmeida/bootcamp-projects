package org.academiadecodigo.bootcamp;

import org.academiadecodigo.bootcamp.objects.Cursor;
import org.academiadecodigo.bootcamp.objects.Grid;

public class Main {

    public static void main(String[] args) {

        Grid grid = new Grid();
        Cursor cursor = new Cursor();
        KeyBind keyBind = new KeyBind(cursor);
        keyBind.init();
    }
}
