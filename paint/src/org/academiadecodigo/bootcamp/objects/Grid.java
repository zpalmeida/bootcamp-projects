package org.academiadecodigo.bootcamp.objects;

import org.academiadecodigo.bootcamp.Canvas;
import org.academiadecodigo.simplegraphics.graphics.Line;

public class Grid {

    public Grid () {

        int x = 0;
        while (x <= Canvas.CELL_SIDE_LENGTH * Canvas.COLUMNS) {

            Line line = new Line(Canvas.PADDING + x, Canvas.PADDING, Canvas.PADDING + x,
                    Canvas.PADDING + Canvas.CELL_SIDE_LENGTH * Canvas.ROWS);
            line.draw();
            x += (Canvas.CELL_SIDE_LENGTH);
        }


        int y = 0;
        while (y <= Canvas.CELL_SIDE_LENGTH * Canvas.ROWS) {

            Line line = new Line(Canvas.PADDING, Canvas.PADDING + y,
                    Canvas.PADDING + Canvas.CELL_SIDE_LENGTH * Canvas.COLUMNS, Canvas.PADDING + y);
            line.draw();
            y += (Canvas.CELL_SIDE_LENGTH);
        }
    }
}
