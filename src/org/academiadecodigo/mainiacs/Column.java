package org.academiadecodigo.mainiacs;

import org.academiadecodigo.simplegraphics.graphics.Color;

public enum Column {

    COLUMN1(Color.BLUE, 150),
    COLUMN2(Color.GREEN, 300),
    COLUMN3(Color.ORANGE, 450),
    COLUMN4(Color.RED, 600);

    private Color color;
    private int x;
    public static final int COLUMN_HEIGHT = 600;


    private Column(Color color, int x) {
        this.color = color;
        this.x = x;

    }

    public int getX() {
        return x;
    }

    public Color getColor() {
        return color;
    }

    public static int getColumnHeight() {
        return COLUMN_HEIGHT;
    }






}
