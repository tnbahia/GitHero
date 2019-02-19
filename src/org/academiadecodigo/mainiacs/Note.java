package org.academiadecodigo.mainiacs;

import org.academiadecodigo.simplegraphics.graphics.Ellipse;

public class Note{

    //metodo move

    private Column column;
    private int y = 0; //fixo negativo sempre descer
    private boolean inTarget;
    private Ellipse ellipse;
    private static final int SIZE = 50;



    public Note() throws InterruptedException {
        column = Column.values()[ (int) (Math.random() * Column.values().length) ];
        ellipse = new Ellipse(column.getX() - (SIZE/2.0), y, SIZE,SIZE );
        ellipse.setColor(column.getColor());
        show();
        move();

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

    public void move () throws InterruptedException {
        int yPosicaoAtual=y;

        while ( yPosicaoAtual < Column.getColumnHeight()){

            Thread.sleep(12);
            ellipse.translate(0,1);
            yPosicaoAtual++;
        }
        hide();

    }


}


