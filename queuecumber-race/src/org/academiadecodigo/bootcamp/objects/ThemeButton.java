package org.academiadecodigo.bootcamp.objects;

import org.academiadecodigo.bootcamp.Theme;
import org.academiadecodigo.bootcamp.grids.Grid;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class ThemeButton {

    private Picture themeButton;
    private Theme theme;

    public ThemeButton (Theme theme) {
        this.theme = theme;
        String picture;
        switch (theme) {
            case POKEMON:
                picture = "pokemon.png";
                break;

            case CATS:
                picture = "cat_button.png";
                break;

            case RICK_AND_MORTY:
                picture = "rick_morty.png";
                break;
            default:
                picture = "themestart.png";
        }
        themeButton = new Picture(75 + Grid.PADDING, 8.5 * 50 + Grid.PADDING, picture);
        themeButton.draw();
    }

    public Picture getThemeButton() {
        return themeButton;
    }
}
