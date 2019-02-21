package org.academiadecodigo.mainiacs;

import org.academiadecodigo.mainiacs.Screen.Screen;
import org.academiadecodigo.mainiacs.Screen.Target;
import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Line;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public enum Column {

    COLUMN1(Color.BLUE, "botRegBlue.png"),
    COLUMN2(Color.GREEN, "botRegGreen.png"),
    COLUMN3(Color.YELLOW, "botRegYellow.png"),
    COLUMN4(Color.RED, "botRegRed.png");

    private Color color;
    private double x;
    private String notePic;
    private String[] buttons = new String[3];



    Column(Color color, String picLink) {
        this.color = color;
        this.x = Screen.SCREEN_WIDTH/5 * (this.ordinal()+1);
        notePic = picLink;
    }

    public double getX() {
        return x;
    }

    public String[] getButtons() {
        return buttons;
    }

    public Color getColor() {
        return color;
    }

    public String getNotePic() {
        return notePic;
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

        Picture pic1 = new Picture(Column.COLUMN1.getX()- 90, Target.START_Y-22, "botBarBlue.png");
        pic1.grow(Note.WIDTH_OF_NOTE-pic1.getWidth(),Note.HEIGHT_OF_NOTE-pic1.getHeight());

        Picture pic2 = new Picture(Column.COLUMN2.getX()- 90, Target.START_Y-22, "botBarGreen.png");
        pic2.grow(Note.WIDTH_OF_NOTE-pic2.getWidth(),Note.HEIGHT_OF_NOTE-pic2.getHeight());

        Picture pic3 = new Picture(Column.COLUMN3.getX()- 90, Target.START_Y-22, "botBarYellow.png");
        pic3.grow(Note.WIDTH_OF_NOTE-pic3.getWidth(),Note.HEIGHT_OF_NOTE-pic3.getHeight());

        Picture pic4 = new Picture(Column.COLUMN4.getX()- 90, Target.START_Y-22, "botBarRed.png");
        pic4.grow(Note.WIDTH_OF_NOTE-pic4.getWidth(),Note.HEIGHT_OF_NOTE-pic4.getHeight());

        pic1.draw();
        pic2.draw();
        pic3.draw();
        pic4.draw();

    }

}
