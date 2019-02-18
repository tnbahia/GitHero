package org.academiadecodigo.mainiacs;

import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;


public class Player implements KeyboardHandler {

    private Stage currentStage;

    Player(){
        Keyboard keyboard = new Keyboard(this);

        KeyboardEvent spaceBarEvent = new KeyboardEvent();
        spaceBarEvent.setKey(KeyboardEvent.KEY_SPACE);
        spaceBarEvent.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);


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

        keyboard.addEventListener(spaceBarEvent);
        keyboard.addEventListener(key1Event);
        keyboard.addEventListener(key2Event);
        keyboard.addEventListener(key3Event);
        keyboard.addEventListener(key4Event);


        //TODO: IMPLEMENT SHIFT KEY (NUM 16)
    }


    @Override
    public void keyPressed(KeyboardEvent keyboardEvent) {

        switch (keyboardEvent.getKey()) {

            case KeyboardEvent.KEY_1:
                //method stage
                //currentStage.keyPressed(1);
                break;

            case KeyboardEvent.KEY_2:
                //currentStage.keyPressed(2);
                break;

            case KeyboardEvent.KEY_3:
                //currentStage.keyPressed(3);
                break;

            case KeyboardEvent.KEY_4:
                //currentStage.keyPressed(4);
                break;

            case KeyboardEvent.KEY_SPACE:

                break;
        }

    }

    @Override
    public void keyReleased(KeyboardEvent keyboardEvent) {

    }
}
