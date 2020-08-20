package org.academiadecodigo.bootcamp.objects;

import org.academiadecodigo.bootcamp.grids.Grid;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Score {

    private Picture score;
    private Grid grid;
    private int level;


    public Score (Grid grid, int level) {
        this.level = level;
        String picture;
        switch (level) {
            case 1:
                picture = "01.png";
                break;
            case 2:
                picture = "02.png";
                break;
            case 3:
                picture = "03.png";
                break;
            case 4:
                picture = "04.png";
                break;
            case 5:
                picture = "05.png";
                break;
            case 6:
                picture = "06.png";
                break;
            case 7:
                picture = "07.png";
                break;
            case 8:
                picture = "08.png";
                break;
            case 9:
                picture = "09.png";
                break;
            default:
                picture = "10.png";
        }

        score = new Picture(grid.getCellWidth() * (grid.getCols() - 1) + Grid.PADDING, Grid.PADDING, picture);
        score.draw();

    }



}
