package org.academiadecodigo.bootcamp;

import org.academiadecodigo.bootcamp.objects.ThemeButton;
import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;

public class MenuKeyBind implements KeyboardHandler {

    private Keyboard keyboard;
    private boolean isSpacePressed = false;
    private Theme theme = Theme.values()[0];
    private KeyboardEvent inputSpace;
    private KeyboardEvent inputLeft;
    private KeyboardEvent inputRight;
    private ThemeButton button;
    private int buttonPosition = 0;

    public MenuKeyBind() {
        button = new ThemeButton(Theme.CUCUMBER);
        keyboard = new Keyboard(this);
    }

    public boolean isSpacePressed() {
        return isSpacePressed;
    }

    public void initMenu() {

        inputSpace = new KeyboardEvent();
        inputSpace.setKey(KeyboardEvent.KEY_SPACE);
        inputSpace.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(inputSpace);


        inputLeft = new KeyboardEvent();
        inputLeft.setKey(KeyboardEvent.KEY_LEFT);
        inputLeft.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(inputLeft);

        inputRight = new KeyboardEvent();
        inputRight.setKey(KeyboardEvent.KEY_RIGHT);
        inputRight.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(inputRight);
    }

    public void disable() {

        keyboard.removeEventListener(inputSpace);
        keyboard.removeEventListener(inputLeft);
        keyboard.removeEventListener(inputRight);
    }

    @Override
    public void keyPressed(KeyboardEvent keyboardEvent) {

        switch (keyboardEvent.getKey()) {
            case KeyboardEvent.KEY_SPACE:
                isSpacePressed = true;
                break;

            case KeyboardEvent.KEY_LEFT:

                if (buttonPosition < 1) return;

                buttonPosition--;
                button.getThemeButton().delete();
                theme = Theme.values()[buttonPosition];
                button = new ThemeButton(theme);
                break;

            case KeyboardEvent.KEY_RIGHT:
                if (buttonPosition >= Theme.values().length - 1) return;

                buttonPosition++;
                button.getThemeButton().delete();
                theme = Theme.values()[buttonPosition];
                button = new ThemeButton(theme);
                break;
        }
    }

    public Theme getTheme() {
        return theme;
    }

    @Override
    public void keyReleased(KeyboardEvent keyboardEvent) {

    }

}
