package org.academiadecodigo.mainiacs;

import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.graphics.Text;

public class Counter {
    private Rectangle box;
    private Integer pointsNumber = 0;
    public Text text = new Text(10,10,"0");

    public Text getText() {
        text.setText(pointsNumber.toString());
        return text;
    }
}
