package org.academiadecodigo.mainiacs.Screen;

import org.academiadecodigo.simplegraphics.pictures.Picture;

public enum ScreenType {
    START_MENU("http://st2.depositphotos.com/1813786/7041/v/950/depositphotos_70414397-stock-illustration-vintage-label-rock-and-roll.jpg", 0),
    STAGE("", 1);

    private Picture background;
    public static final int SCREEN_HEIGHT = 500;
    public static final int SCREEN_WIDTH = 300;

    private ScreenType(String backgroundLink, int difficulty) {
        background = new Picture(0, 0, backgroundLink);
        this.difficulty = difficulty;
    }

    public Picture getBackground() {
        return background;
    }

    public int getDifficulty() {
        return difficulty;
    }
}
