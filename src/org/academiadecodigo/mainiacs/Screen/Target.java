package org.academiadecodigo.mainiacs.Screen;

import org.academiadecodigo.mainiacs.Note;
import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;

public class Target {

    private static final int BORDER = 15;
    private static final int BOTTOM_BORDER = 40;
    public static final int HEIGHT_TARGET = Note.WIDTH_OF_NOTE + BORDER;
    public static final int START_Y = Stage.getBackground().getHeight() - (HEIGHT_TARGET*2) - BOTTOM_BORDER;
    public static final int END_Y = START_Y + HEIGHT_TARGET;
    private Rectangle rectangle;

    public Target() {
        int targetWidth = Stage.getBackground().getWidth() - (BORDER*3);
        rectangle = new Rectangle((BORDER*2),START_Y,targetWidth,HEIGHT_TARGET);
        rectangle.setColor(Color.LIGHT_GRAY);
    }

    public void setColor(){

        int counter = (int) (Math.random() * 100);

        if(counter <= 10){
            rectangle.setColor(Color.GREEN);
            draw();
            return;
        }
        if(counter <= 40){
            rectangle.setColor(Color.BLUE);
            draw();
            return;
        }
        if(counter <= 70){
            rectangle.setColor(Color.MAGENTA);
            draw();
        }
        else {
            rectangle.setColor(Color.YELLOW);
            draw();
        }

    }

    public void draw() {
        rectangle.fill();
    }
}
