package org.academiadecodigo.mainiacs;

import org.academiadecodigo.simplegraphics.pictures.Picture;

public enum StageType {
    START_MENU(new Picture(500,300,"")),
    STAGE(new Picture( 500,300,""));

    private Picture background;
    public static final int SCREEN_HEIGHT = 500;
    public static final int SCREEN_WIDTH = 300;

    private StageType(Picture background) {
        this.background = background;
    }
}
