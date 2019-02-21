package org.academiadecodigo.mainiacs.Screen;

import org.academiadecodigo.mainiacs.Note;
import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;

public class Target {
    private static final int BORDER = 15;
    private static final int BOTTOM_BORDER = 40;
    public static final int HEIGHT_TARGET = Note.WIDTH_OF_NOTE + BORDER;
    public static int START_Y = Stage.getBackground().getWidth() - (HEIGHT_TARGET*2) - BOTTOM_BORDER;
    public static int END_Y = START_Y + HEIGHT_TARGET;
    //public static final int

    private Rectangle rectangle;

    public Target() {

        //int rectHeight = END_Y - START_Y;
        rectangle = new Rectangle((BORDER*2),Stage.getBackground().getHeight() - (HEIGHT_TARGET*2) - BOTTOM_BORDER,Stage.getBackground().getWidth() - (BORDER*3),HEIGHT_TARGET);
        rectangle.setColor(Color.LIGHT_GRAY);
    }

    public void draw() {
        rectangle.fill();
    }
}
