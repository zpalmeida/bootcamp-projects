package org.academiadecodigo.bootcamp;

import org.academiadecodigo.bootcamp.grids.Grid;
import org.academiadecodigo.bootcamp.objects.ThemeButton;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Menu extends Grid {

    private Picture menu;
    private Game game;
    private Theme theme;
    private KeyBind keyboard;
    private ThemeButton themeButton;
    public static final int COLS = 5;
    public static final int ROWS = 13;
    public static final int CELL_WIDTH = 75;
    public static final int CELL_HEIGHT = 50;

    public Menu() {
        super(COLS, ROWS, CELL_WIDTH, CELL_HEIGHT);
        menu = new Picture(super.PADDING, super.PADDING, "start.png");
        menu.draw();

    }
}
