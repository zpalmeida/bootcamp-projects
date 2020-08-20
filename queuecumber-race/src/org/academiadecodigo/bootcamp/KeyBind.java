package org.academiadecodigo.bootcamp;

import org.academiadecodigo.bootcamp.grids.CharacterDirection;
import org.academiadecodigo.bootcamp.positions.CharacterPosition;
import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;

public class KeyBind implements KeyboardHandler {

    private Keyboard keyboard;
    private CharacterPosition character;

    public KeyBind(CharacterPosition character) {
        this.keyboard = new Keyboard(this);
        this.character = character;
    }

    public void init() {

        KeyboardEvent inputUp = new KeyboardEvent();
        inputUp.setKey(KeyboardEvent.KEY_UP);
        inputUp.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(inputUp);

        KeyboardEvent inputDown = new KeyboardEvent();
        inputDown.setKey(KeyboardEvent.KEY_DOWN);
        inputDown.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(inputDown);

        KeyboardEvent inputLeft = new KeyboardEvent();
        inputLeft.setKey(KeyboardEvent.KEY_LEFT);
        inputLeft.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(inputLeft);

        KeyboardEvent inputRight = new KeyboardEvent();
        inputRight.setKey(KeyboardEvent.KEY_RIGHT);
        inputRight.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(inputRight);

    }

    @Override
    public void keyPressed(KeyboardEvent keyboardEvent) {

        switch (keyboardEvent.getKey()) {
            case KeyboardEvent.KEY_UP:
                character.move(CharacterDirection.UP);
                break;

            case KeyboardEvent.KEY_DOWN:
                character.move(CharacterDirection.DOWN);
                break;

            case KeyboardEvent.KEY_LEFT:
                character.move(CharacterDirection.LEFT);
                break;

            case KeyboardEvent.KEY_RIGHT:
                character.move(CharacterDirection.RIGHT);
                break;
        }
    }

    @Override
    public void keyReleased(KeyboardEvent keyboardEvent) {

    }
}
