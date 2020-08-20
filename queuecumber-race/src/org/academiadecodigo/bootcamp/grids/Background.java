package org.academiadecodigo.bootcamp.grids;

import org.academiadecodigo.bootcamp.Theme;
import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Background extends Grid {

    private Picture background;
    private String picture;
    public static final int COLS = 5;
    public static final int ROWS = 13;
    public static final int CELL_WIDTH = 75;
    public static final int CELL_HEIGHT = 50;

    public Background(Theme theme) {
        super(COLS, ROWS, CELL_WIDTH, CELL_HEIGHT);

        switch (theme) {
            case POKEMON:
                picture = "backgroundpikachu.png";
                break;

            case CATS:
                picture = "background_cats.png";
                break;

            case RICK_AND_MORTY:
                picture = "backgroundrick.png";
                break;

            default:
                picture = "background.png";
        }

        background = new Picture(super.PADDING, super.PADDING, picture);
        background.draw();
    }
}
