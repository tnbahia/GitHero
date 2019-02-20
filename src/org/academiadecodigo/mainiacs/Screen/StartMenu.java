package org.academiadecodigo.mainiacs.Screen;

import org.academiadecodigo.simplegraphics.pictures.Picture;

public class StartMenu extends Screen {

    private Picture background;

    public StartMenu () {
        super(ScreenType.START_MENU);
        String link = "http://st2.depositphotos.com/1813786/7041/v/950/depositphotos_70414397-stock-illustration-vintage-label-rock-and-roll.jpg";
        background = new Picture(10, 0, link);
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
}
