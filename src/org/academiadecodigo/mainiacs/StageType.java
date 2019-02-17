package org.academiadecodigo.mainiacs;

import org.academiadecodigo.simplegraphics.pictures.Picture;

public enum StageType {
    START_MENU(""),
    STAGE1(""),
    STAGE2(""),
    STAGE3("");

    private Picture background;
    public static final int SCREEN_HEIGHT = 500;
    public static final int SCREEN_WIDTH = 300;

    private StageType(String backgroundLink) {
        background = new Picture(SCREEN_HEIGHT,SCREEN_WIDTH,backgroundLink);
    }

    public Picture getBackground() {
        return background;
    }
}
