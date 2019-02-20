package org.academiadecodigo.mainiacs.Screen;

import org.academiadecodigo.simplegraphics.pictures.Picture;

import java.awt.*;

public enum ScreenType {
    START_MENU("http://st2.depositphotos.com/1813786/7041/v/950/depositphotos_70414397-stock-illustration-vintage-label-rock-and-roll.jpg"),
    STAGE("http://st2.depositphotos.com/1813786/7041/v/950/depositphotos_70414397-stock-illustration-vintage-label-rock-and-roll.jpg");

    private Picture background;

    ScreenType(String backgroundLink) {
        background = new Picture(0, 0, backgroundLink);
    }

    public Picture getBackground() {
        return background;
    }
}
