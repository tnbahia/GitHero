package org.academiadecodigo.mainiacs;

import org.academiadecodigo.simplegraphics.graphics.Text;

public class Counter extends Text {
    private int pointsNumber = 0;

    public Counter(){
        super(80,50,"0");
    }

    public void increase() {
        pointsNumber += 20;
        setText();
    }

    public void decrease() {
        if (pointsNumber !=  0) {
            pointsNumber -= 10;
            setText();
        }
    }

    public void setText() {
        super.setText((((Integer)pointsNumber).toString()));
    }

    @Override
    public String toString() {
        return (((Integer)pointsNumber).toString());
    }
}
