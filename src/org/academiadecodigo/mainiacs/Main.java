package org.academiadecodigo.mainiacs;

import org.academiadecodigo.mainiacs.Screen.Stage;
import org.academiadecodigo.mainiacs.Screen.ScreenType;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Note note = new Note();
        int i = 100;
        /*while (i > 0) {
            note.ellipse.draw();

            Thread.sleep(24);

            note.ellipse.grow(1, 1);

            i--;
        }*/
        Player player = new Player();

        Stage stage = new Stage(player, ScreenType.START_MENU);
        stage.start();
    }
}
