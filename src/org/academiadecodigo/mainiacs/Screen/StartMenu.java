package org.academiadecodigo.mainiacs.Screen;

import org.academiadecodigo.simplegraphics.pictures.Picture;

public class StartMenu extends Screen {

    private Picture background;

    public StartMenu () {
        String link = "start-menu-background.jpg";
        background = new Picture();
        background.load(link);
    }

    @Override
    public void start() {
        background.draw();
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
