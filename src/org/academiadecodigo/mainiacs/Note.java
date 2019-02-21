package org.academiadecodigo.mainiacs;

import org.academiadecodigo.mainiacs.Screen.Screen;
import org.academiadecodigo.mainiacs.Screen.Target;
import org.academiadecodigo.simplegraphics.graphics.Ellipse;

public class Note {

    private Column column;
    private int y = 0; //fixo negativo sempre descer
    private boolean inTarget;
    private boolean reachedEnd;
    private Ellipse ellipse;
    public static final int SIZE_OF_NOTE = 70;


    public Note() {
        column = Column.values()[(int) (Math.random() * Column.values().length)];
        ellipse = new Ellipse(column.getX() - (SIZE_OF_NOTE / 2.0), y, SIZE_OF_NOTE, SIZE_OF_NOTE);
        ellipse.setColor(column.getColor());
        show();
    }

    public Column getColumn() {
        return column;
    }

    public int getY() {
        return y;
    }


    public boolean isInTarget() {
        return inTarget;
    }

    public Ellipse getEllipse() {
        return ellipse;
    }


    public void show() {
        ellipse.fill();

    }

    public void hide() {
        ellipse.delete();

    }

    public void move() {
        ellipse.translate(0, 1);
        y++;
        if (y + SIZE_OF_NOTE == Screen.SCREEN_HEIGHT) {
            reachedEnd = true;
            hide();
        }
        if (y + SIZE_OF_NOTE + 1 > Target.START_Y) {
            inTarget = true;
        }
        if (y > Target.END_Y) {
            inTarget = false;
        }
    }

    public boolean reachedEnd() {
        return reachedEnd;
    }
}


