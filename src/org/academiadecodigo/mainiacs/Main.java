package org.academiadecodigo.mainiacs;

import org.academiadecodigo.mainiacs.Screen.Stage;
import org.academiadecodigo.mainiacs.Screen.ScreenType;

public class Main {
    public static void main(String[] args) throws InterruptedException {

        Note note = new Note();
        int i = 100;

        Player player = new Player();


        Stage stage = new Stage(player, ScreenType.START_MENU);
        stage.start();
    }
}
