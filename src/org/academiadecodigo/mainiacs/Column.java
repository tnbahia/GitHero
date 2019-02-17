package org.academiadecodigo.mainiacs;

import org.academiadecodigo.simplegraphics.graphics.Color;

public enum Column {
    COLUMN1(Color.BLUE, 100),
    COLUMN2(Color.GREEN, 200),
    COLUMN3(Color.ORANGE, 300),
    COLUMN4(Color.RED, 400);

    private Color color;
    private int x;
    public static final int COLUMN_HEIGHT = 800;


    private Column(Color color, int x) {
        this.color = color;
        this.x = x;
    }
}
