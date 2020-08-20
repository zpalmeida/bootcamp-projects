package org.academiadecodigo.bootcamp.gfx.simplegfx;

import org.academiadecodigo.bootcamp.grid.GridColor;
import org.academiadecodigo.bootcamp.grid.GridDirection;
import org.academiadecodigo.bootcamp.grid.position.AbstractGridPosition;
import org.academiadecodigo.bootcamp.grid.position.GridPosition;
import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;

/**
 * Simple graphics position
 */
public class SimpleGfxGridPosition extends AbstractGridPosition {

    private Rectangle rectangle;
    private SimpleGfxGrid simpleGfxGrid;

    /**
     * Simple graphics position constructor
     * @param grid Simple graphics grid
     */
    public SimpleGfxGridPosition(SimpleGfxGrid grid){
        super((int) (Math.random() * grid.getCols()), (int) (Math.random() * grid.getRows()), grid);
        simpleGfxGrid = grid;
        rectangle = new Rectangle(simpleGfxGrid.columnToX(super.getCol()) + SimpleGfxGrid.PADDING, simpleGfxGrid.rowToY(super.getRow()) + SimpleGfxGrid.PADDING, simpleGfxGrid.getCellSize(), simpleGfxGrid.getCellSize());
        show();
    }

    /**
     * Simple graphics position constructor
     * @param col position column
     * @param row position row
     * @param grid Simple graphics grid
     */
    public SimpleGfxGridPosition(int col, int row, SimpleGfxGrid grid){
        super(col, row, grid);
        simpleGfxGrid = grid;
        rectangle = new Rectangle(simpleGfxGrid.columnToX(col) + SimpleGfxGrid.PADDING, simpleGfxGrid.rowToY(row) + SimpleGfxGrid.PADDING, simpleGfxGrid.getCellSize(), simpleGfxGrid.getCellSize());
        show();
    }

    /**
     * @see GridPosition#show()
     */
    @Override
    public void show() {
        rectangle.fill();
    }

    /**
     * @see GridPosition#hide()
     */
    @Override
    public void hide() {
        rectangle.delete();
    }

    /**
     * @see GridPosition#moveInDirection(GridDirection, int)
     */
    @Override
    public void moveInDirection(GridDirection direction, int distance) {

        int x = super.getCol();
        int y = super.getRow();

        super.moveInDirection(direction, distance);

        rectangle.translate(simpleGfxGrid.columnToX(super.getCol() - x), simpleGfxGrid.rowToY(super.getRow() - y));

    }

    /**
     * @see AbstractGridPosition#setColor(GridColor)
     */
    @Override
    public void setColor(GridColor color) {

        super.setColor(color);
        rectangle.setColor(SimpleGfxColorMapper.getColor(color));
    }
}
