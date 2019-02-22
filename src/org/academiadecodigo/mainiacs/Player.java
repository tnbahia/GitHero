package org.academiadecodigo.mainiacs;

import org.academiadecodigo.mainiacs.Screen.ScreenType;
import org.academiadecodigo.mainiacs.Screen.Stage;
import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;


public class Player implements KeyboardHandler {

    private ScreenType currentScreen;
    private Stage stage;

    Player(){

        Keyboard keyboard = new Keyboard(this);

        /*KeyboardEvent spaceBarEvent = new KeyboardEvent();
        spaceBarEvent.setKey(KeyboardEvent.KEY_SPACE);
        spaceBarEvent.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);*/


        KeyboardEvent key1Event = new KeyboardEvent();
        key1Event.setKey(KeyboardEvent.KEY_1);
        key1Event.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);

        KeyboardEvent key2Event = new KeyboardEvent();
        key2Event.setKey(KeyboardEvent.KEY_2);
        key2Event.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);

        KeyboardEvent key3Event = new KeyboardEvent();
        key3Event.setKey(KeyboardEvent.KEY_3);
        key3Event.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);

        KeyboardEvent key4Event = new KeyboardEvent();
        key4Event.setKey(KeyboardEvent.KEY_4);
        key4Event.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);

        //keyboard.addEventListener(spaceBarEvent);
        keyboard.addEventListener(key1Event);
        keyboard.addEventListener(key2Event);
        keyboard.addEventListener(key3Event);
        keyboard.addEventListener(key4Event);

    }

    public void setCurrentScreen(ScreenType currentScreen) {
        this.currentScreen = currentScreen;
    }

    public void setStage(Stage stage) {
        this.stage = stage;
    }

    @Override
    public void keyPressed(KeyboardEvent keyboardEvent) {


        // Case main menu

        if (currentScreen == ScreenType.START_MENU ){

            switch (keyboardEvent.getKey()) {

                case KeyboardEvent.KEY_1:
                    Game.startStage(1);
                    break;
                case KeyboardEvent.KEY_2:
                    Game.startStage(2);
                    break;
                case KeyboardEvent.KEY_3:
                    Game.startStage(3);
                    break;
                default:
                    Game.startStage(2);
            }
        } else {


            // Case stage

            switch (keyboardEvent.getKey()) {

                case KeyboardEvent.KEY_1:
                    stage.keyPress(Column.COLUMN1);
                    break;

                case KeyboardEvent.KEY_2:
                    stage.keyPress(Column.COLUMN2);
                    break;

                case KeyboardEvent.KEY_3:
                    stage.keyPress(Column.COLUMN3);
                    break;

                case KeyboardEvent.KEY_4:
                    stage.keyPress(Column.COLUMN4);
                    break;
            }
        }
    }

    @Override
    public void keyReleased(KeyboardEvent keyboardEvent) {

    }

}
