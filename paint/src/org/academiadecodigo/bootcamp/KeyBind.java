package org.academiadecodigo.bootcamp;

import org.academiadecodigo.bootcamp.objects.Cursor;
import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;

public class KeyBind implements KeyboardHandler {

    private Keyboard keyboard;
    private Cursor cursor;

    public KeyBind(Cursor cursor) {
        this.keyboard = new Keyboard(this);
        this.cursor = cursor;
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

        KeyboardEvent inputSpace = new KeyboardEvent();
        inputSpace.setKey(KeyboardEvent.KEY_SPACE);
        inputSpace.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(inputSpace);

        KeyboardEvent inputC = new KeyboardEvent();
        inputC.setKey(KeyboardEvent.KEY_C);
        inputC.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(inputC);

        KeyboardEvent inputS = new KeyboardEvent();
        inputS.setKey(KeyboardEvent.KEY_S);
        inputS.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(inputS);

        KeyboardEvent inputL = new KeyboardEvent();
        inputL.setKey(KeyboardEvent.KEY_L);
        inputL.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(inputL);
    }

    @Override
    public void keyPressed(KeyboardEvent keyboardEvent) {

        switch (keyboardEvent.getKey()) {
            case KeyboardEvent.KEY_UP:
                cursor.move(Cursor.Direction.UP);
                break;

            case KeyboardEvent.KEY_DOWN:
                cursor.move(Cursor.Direction.DOWN);
                break;

            case KeyboardEvent.KEY_LEFT:
                cursor.move(Cursor.Direction.LEFT);
                break;

            case KeyboardEvent.KEY_RIGHT:
                cursor.move(Cursor.Direction.RIGHT);
                break;

            case KeyboardEvent.KEY_SPACE:
                Ink.paint(cursor);
                cursor.getCursor().delete();
                cursor.getCursor().fill();
                break;

            case KeyboardEvent.KEY_C:
                Ink.clear();
                cursor.getCursor().fill();
                break;

            case KeyboardEvent.KEY_S:
                Ink.save();
                break;

            case KeyboardEvent.KEY_L:
                Ink.load();
                break;
        }
    }

    @Override
    public void keyReleased(KeyboardEvent keyboardEvent) {

    }
}
