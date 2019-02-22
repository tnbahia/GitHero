package org.academiadecodigo.mainiacs.Screen;

import org.academiadecodigo.simplegraphics.graphics.Canvas;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class StartMenu extends Screen {

    private Picture background;

    public StartMenu () {
        super(ScreenType.START_MENU);
        String link = "resources/start-menu-background.jpg";
        background = new Picture();
        background.load(link);
    }

    @Override
    public void start() {
        background.draw();
    }

    public Picture getBackground() {
        return background;
    }

    @Override
    public void delete() {
        background.delete();
    }

    @Override
    public String toString() {
        return "Start Menu";
    }
}
