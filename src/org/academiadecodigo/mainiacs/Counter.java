package org.academiadecodigo.mainiacs;

import org.academiadecodigo.simplegraphics.graphics.Text;

public class Counter extends Text {
    private int pointsNumber = 0;

    public Counter(){
        super(700,50,"0");
    }

    public String getPoints() {
        String points = ((Integer)pointsNumber).toString();
        return points;
    }

    public void increase() {
        pointsNumber += 100;
        setText();
    }

    public void decrease() {
        if (pointsNumber == 0) {
            return;
        } else {
            pointsNumber -= 20;
            setText();
        }
    }

    public void setText() {
        super.setText((getPoints()));
    }



}
