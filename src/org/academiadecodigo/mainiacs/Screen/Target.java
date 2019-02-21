package org.academiadecodigo.mainiacs.Screen;

import org.academiadecodigo.mainiacs.Note;
import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;

public class Target {
    public static final int START_Y = 600;
    public static final int END_Y = 750;
    private static final int BORDER = 15;
    private static final int BOTTOM_BORDER = 40;
    public static final int HEIGHT_TARGET = Note.SIZE_OF_NOTE + BORDER;

    private Rectangle rectangle;

    public Target() {
        int screenWidth = ScreenType.STAGE.getBackground().getWidth();
        int screenHeight = ScreenType.STAGE.getBackground().getHeight();


        int rectHeight = END_Y - START_Y;
        rectangle = new Rectangle((BORDER*2),screenHeight - (HEIGHT_TARGET*2) - BOTTOM_BORDER,screenWidth - (BORDER*3),HEIGHT_TARGET);
        rectangle.setColor(Color.LIGHT_GRAY);
    }

    public void draw() {
        rectangle.fill();
    }
}
