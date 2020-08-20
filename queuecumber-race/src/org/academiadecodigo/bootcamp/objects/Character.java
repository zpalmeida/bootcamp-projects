package org.academiadecodigo.bootcamp.objects;

import org.academiadecodigo.bootcamp.Theme;
import org.academiadecodigo.bootcamp.grids.Grid;
import org.academiadecodigo.bootcamp.positions.CharacterPosition;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Character extends CharacterPosition {

    public Character(Theme theme, Grid grid) {

        super(grid);
        Picture character;
        String picture;

        switch (theme) {
            case POKEMON:
                picture = "pikachu.png";
                break;

            case CATS:
                picture = "mouse.png";
                break;

            case RICK_AND_MORTY:
                picture = "rick.png";
                break;

            default:
                picture = "pepino.png";
        }

        character = new Picture(super.x(), super.initialY(), picture);

        super.setPicture(character);
        character.draw();
    }
}

