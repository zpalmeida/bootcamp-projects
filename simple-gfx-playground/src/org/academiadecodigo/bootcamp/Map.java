package org.academiadecodigo.bootcamp;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;

public class Map {

    private static Rectangle wall;

    public static void map() {

        wall = new Rectangle(100, 100, 60, 20);
        wall.setColor(Color.GRAY);
        wall.fill();

    }

}
