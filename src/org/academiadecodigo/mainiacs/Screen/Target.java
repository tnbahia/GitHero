package org.academiadecodigo.mainiacs.Screen;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;

public class Target {
    public static final int START_Y = 750;
    public static final int END_Y = 900;
    private Rectangle rectangle;

    public Target() {
        int screenWidth = ScreenType.STAGE.getBackground().getWidth();
        int rectHeight = END_Y - START_Y;
        rectangle = new Rectangle(20,START_Y,screenWidth-40,rectHeight);
        rectangle.setColor(Color.RED);
    }

    public void draw() {
        rectangle.fill();
    }
}
