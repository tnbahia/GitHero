package org.academiadecodigo.mainiacs;

import org.academiadecodigo.mainiacs.Screen.Screen;
import org.academiadecodigo.mainiacs.Screen.ScreenType;
import org.academiadecodigo.mainiacs.Screen.Stage;
import org.academiadecodigo.mainiacs.Screen.StartMenu;

public class Game {

    public static Player player;
    private static Screen[] screens = new Screen[4];

    public static void main(String[] args) throws InterruptedException {
        screens[0] = new StartMenu();
        for (int i = 1; i < screens.length; i++) {
            screens[i] = new Stage(ScreenType.STAGE);
        }
        player = new Player();
        init();
    }


    public static void init() throws InterruptedException{

        player.setCurrentScreen(ScreenType.STAGE);
        player.setStage((Stage) screens[1]);
        screens[1].start();

    }

    public static void startStage(int stageNumber) {
        screens[0].delete();
        player.setCurrentScreen(ScreenType.STAGE);
        try {
            screens[stageNumber].start();
        } catch (InterruptedException ignore) {}
    }
}
