package org.academiadecodigo.bootcamp;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Ellipse;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;

public class Playground implements KeyboardHandler {

    private Keyboard keyboard;
    private Rectangle background;
    private Ellipse cucumber;

    public Playground() {
        keyboard = new Keyboard(this);

    }

    public void init() {
        background = new Rectangle(10, 10, 700, 700);
        background.setColor(Color.LIGHT_GRAY);
        background.fill();

        cucumber = new Ellipse(50, 50, 10, 10);
        cucumber.setColor(Color.MAGENTA);
        cucumber.fill();

        Map.map();

        KeyboardEvent inputLeft = new KeyboardEvent();
        inputLeft.setKey(KeyboardEvent.KEY_A);
        inputLeft.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(inputLeft);

        KeyboardEvent inputRight = new KeyboardEvent();
        inputRight.setKey(KeyboardEvent.KEY_D);
        inputRight.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(inputRight);

        KeyboardEvent inputUp = new KeyboardEvent();
        inputUp.setKey(KeyboardEvent.KEY_W);
        inputUp.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(inputUp);

        KeyboardEvent inputDown = new KeyboardEvent();
        inputDown.setKey(KeyboardEvent.KEY_S);
        inputDown.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(inputDown);
    }

    public static void main(String[] args) {
        Playground playground = new Playground();
        playground.init();
    }

    @Override
    public void keyPressed(KeyboardEvent keyboardEvent) {

        switch (keyboardEvent.getKey()) {
            case KeyboardEvent.KEY_A:
                cucumber.translate(-10, 0);
                break;
            case KeyboardEvent.KEY_D:
                cucumber.translate(10, 0);
                break;
            case KeyboardEvent.KEY_W:
                cucumber.translate(0, -10);
                break;
            case KeyboardEvent.KEY_S:
                cucumber.translate(0, 10);
                break;

        }
    }

    public void keyReleased(KeyboardEvent keyboardEvent) {

    }
}
