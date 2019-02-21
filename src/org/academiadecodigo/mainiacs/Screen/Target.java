package org.academiadecodigo.mainiacs.Screen;

import org.academiadecodigo.mainiacs.Note;
import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;

public class Target {
    public static int START_Y;
    public static int END_Y;
    private static final int BORDER = 25;
    private static final int BOTTOM_BORDER = 40;
    public static final int HEIGHT_TARGET = Note.SIZE_OF_NOTE + BORDER;

    //public static final int

    private Rectangle rectangle;

    public Target() {
        int screenWidth = ScreenType.STAGE.getBackground().getWidth();
        int screenHeight = ScreenType.STAGE.getBackground().getHeight();

        START_Y = screenHeight - (HEIGHT_TARGET*2) - BOTTOM_BORDER;
        END_Y = START_Y + HEIGHT_TARGET;

        //int rectHeight = END_Y - START_Y;
        rectangle = new Rectangle((BORDER*2),screenHeight - (HEIGHT_TARGET*2) - BOTTOM_BORDER,screenWidth - (BORDER*3),HEIGHT_TARGET);


    }

    public void setColor() throws InterruptedException{

        int counter = 0;
        while(true){
            counter = (int) (Math.random() * 100);
            if(counter <= 10){
                rectangle.setColor(Color.GREEN);
                Thread.sleep(300);
                draw();
                continue;
            }
            if(counter <= 40){
                rectangle.setColor(Color.BLUE);
                Thread.sleep(300);
                draw();
                continue;
            }
            if(counter <= 70){
                rectangle.setColor(Color.MAGENTA);
                Thread.sleep(300);
                draw();
            }
            else {
                rectangle.setColor(Color.YELLOW);
                Thread.sleep(300);
                draw();

            }
        }

    }

    public void draw() {

        rectangle.fill();
    }
}
