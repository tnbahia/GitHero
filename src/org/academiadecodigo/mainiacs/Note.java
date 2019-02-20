package org.academiadecodigo.mainiacs;

import org.academiadecodigo.mainiacs.Screen.Target;
import org.academiadecodigo.simplegraphics.graphics.Ellipse;

public class Note {

    //metodo move

    private Column column;
    private int y = 0; //fixo negativo sempre descer
    private boolean inTarget;
    private boolean reachedEnd;
    private Ellipse ellipse;
    private static final int SIZE = 100;


    public Note() {
        column = Column.values()[(int) (Math.random() * Column.values().length)];
        ellipse = new Ellipse(column.getX() - (SIZE / 2.0), y, SIZE, SIZE);
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
        if (y == Column.COLUMN_HEIGHT) {
            reachedEnd = true;
            hide();
        }
        if (y + SIZE + 1 > Target.START_Y) {
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


