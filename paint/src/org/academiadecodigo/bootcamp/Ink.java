package org.academiadecodigo.bootcamp;

import org.academiadecodigo.bootcamp.objects.Cursor;
import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;

public class Ink {

    private static Color COLOR = Color.MAGENTA;
    private static HashMap<Integer, Rectangle> PAINTED = new HashMap();

    public static void paint(Cursor cursor) {

        if (PAINTED.containsKey(coordinatesToInteger(cursor.getX(), cursor.getY()))) {

            PAINTED.get(coordinatesToInteger(cursor.getX(), cursor.getY())).delete();
            PAINTED.remove(coordinatesToInteger(cursor.getX(), cursor.getY()));
            return;
        }

        Rectangle paint = new Rectangle(cursor.getX(), cursor.getY(), Canvas.CELL_SIDE_LENGTH, Canvas.CELL_SIDE_LENGTH);
        paint.setColor(COLOR);
        paint.fill();

        PAINTED.put(coordinatesToInteger(cursor.getX(), cursor.getY()), paint);
    }

    public static void clear() {

        for (Integer key : PAINTED.keySet()) {

            PAINTED.get(key).delete();
        }

        PAINTED.clear();
    }

    private static Integer coordinatesToInteger(int x, int y) {

        int column = ((x - Canvas.PADDING) / Canvas.CELL_SIDE_LENGTH) + 1;
        int row = ((y - Canvas.PADDING) / Canvas.CELL_SIDE_LENGTH) + 1;

        return (row - 1) * Canvas.COLUMNS + column;
    }

    private static int integerToX(Integer integer) {

        while (integer > Canvas.COLUMNS) {
            integer -= Canvas.COLUMNS;
        }
        return integer * Canvas.CELL_SIDE_LENGTH + Canvas.PADDING;
    }

    private static int integerToY(Integer integer) {

        if (integer % Canvas.COLUMNS == 0) {
            return (integer / Canvas.COLUMNS) * Canvas.CELL_SIDE_LENGTH + Canvas.PADDING;
        }
        return (integer / Canvas.COLUMNS + 1) * Canvas.CELL_SIDE_LENGTH + Canvas.PADDING;
    }

    public static void save() {

        try {

            FileWriter writer = new FileWriter("saved-paintings/save.txt");
            BufferedWriter bufferedWriter = new BufferedWriter(writer);

            for (Integer key : PAINTED.keySet()) {
                bufferedWriter.write(key + " ");
            }
            bufferedWriter.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void load() {

        try {

            clear();

            FileReader reader = new FileReader("saved-paintings/save.txt");
            BufferedReader bufferedReader = new BufferedReader(reader);
            ArrayList<Integer> integers = new ArrayList();

            String intString;

            while ((intString = bufferedReader.readLine()) != null) {

                for (String integer : intString.split(" ")) {
                    integers.add(Integer.valueOf(integer));
                }
            }
            bufferedReader.close();

            for (Integer integer : integers) {

                Rectangle paint = new Rectangle(integerToX(integer), integerToY(integer), Canvas.CELL_SIDE_LENGTH, Canvas.CELL_SIDE_LENGTH);
                paint.setColor(COLOR);
                paint.fill();

                PAINTED.put(integer, paint);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
