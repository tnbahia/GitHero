package org.academiadecodigo.mainiacs;

import org.academiadecodigo.mainiacs.Screen.Screen;
import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Line;

public enum Column {

    COLUMN1(Color.BLUE, 150),
    COLUMN2(Color.GREEN, 300),
    COLUMN3(Color.ORANGE, 450),
    COLUMN4(Color.RED, 600);

    private Color color;
    private int x;


    Column(Color color, int x) {
        this.color = color;
        this.x = x;

    }

    public int getX() {
        return x;
    }

    public Color getColor() {
        return color;
    }

    public static void draw() {
        Line col1 = new Line(Column.COLUMN1.getX(),0,Column.COLUMN1.getX(),Screen.SCREEN_HEIGHT);
        Line col2 = new Line(Column.COLUMN2.getX(),0,Column.COLUMN2.getX(),Screen.SCREEN_HEIGHT);
        Line col3 = new Line(Column.COLUMN3.getX(),0,Column.COLUMN3.getX(),Screen.SCREEN_HEIGHT);
        Line col4 = new Line(Column.COLUMN4.getX(),0,Column.COLUMN4.getX(),Screen.SCREEN_HEIGHT);

        col1.setColor(COLUMN1.getColor());
        col2.setColor(COLUMN2.getColor());
        col3.setColor(COLUMN3.getColor());
        col4.setColor(COLUMN4.getColor());

        col1.draw();
        col2.draw();
        col3.draw();
        col4.draw();

    }

}
