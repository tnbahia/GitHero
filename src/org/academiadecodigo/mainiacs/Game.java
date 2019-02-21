package org.academiadecodigo.mainiacs;

import org.academiadecodigo.mainiacs.Screen.Screen;
import org.academiadecodigo.mainiacs.Screen.ScreenType;
import org.academiadecodigo.mainiacs.Screen.Stage;
import org.academiadecodigo.mainiacs.Screen.StartMenu;

public class Game {

    public static Player player;
    private static Screen[] screens = new Screen[4];

    public static void main(String[] args) {

        screens[0] = new StartMenu();
        for (int i = 1; i < screens.length; i++) {
            screens[i] = new Stage(ScreenType.STAGE);
        }
        player = new Player();
        init();

    }


    public static void init() {

        player.setCurrentScreen(ScreenType.STAGE);
        player.setStage((Stage) screens[1]);
        screens[1].start();

    }

    public static void startStage(int stageNumber) {
        StartMenu menu = (StartMenu) screens[0];
        menu.delete();
        player.setCurrentScreen(ScreenType.STAGE);

        //screens[stageNumber].start();
    }
}
