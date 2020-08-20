package org.academiadecodigo.bootcamp.grids;

public abstract class Grid {

    public static final int PADDING = 10;
    private int width;
    private int height;
    private int cellWidth;
    private int cellHeight;

    public Grid(int cols, int rows, int cellWidth, int cellHeight) {
        this.cellWidth = cellWidth;
        this.cellHeight = cellHeight;
        this.width = cols * cellWidth;
        this.height = rows * cellHeight;
    }

    public int getWidth() {
        return this.width;
    }

    public int getHeight() {
        return this.height;
    }

    public int getCols() {
        return width / cellWidth;
    }

    public int getRows() {
        return height / cellHeight;
    }

    public int getCellWidth() {
        return this.cellWidth;
    }

    public int getCellHeight() {
        return this.cellHeight;
    }

}
