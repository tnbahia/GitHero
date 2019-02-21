package org.academiadecodigo.mainiacs.Screen;

import org.academiadecodigo.mainiacs.*;
import org.academiadecodigo.simplegraphics.pictures.Picture;

import java.util.LinkedList;

public class Stage extends Screen {

    private Counter counter = new Counter();
    private Target target;
    private LinkedList<Note> noteList;
    private Picture background;

    public Stage(ScreenType screenType) {
        super(screenType);
        String link = "http://st2.depositphotos.com/1813786/7041/v/950/depositphotos_70414397-stock-illustration-vintage-label-rock-and-roll.jpg";
        background = new Picture(10, 10, link);
        double grow = Screen.SCREEN_HEIGHT - background.getHeight();
        background.grow(0,grow);
    }

    public void start() /*throws InterruptedException */{
        noteList = new LinkedList<>();
        target = new Target();
        drawStage();
        /*while (true) {
            Thread.sleep(2);
            getNewNote();
            for (Note note : noteList) {
                note.move();
            }
            noteList.removeIf(note -> note.reachedEnd());
        }*/
    }

    private void drawStage() {
        background.draw();
        counter.draw();
        Column.draw();
        target.draw();
        counter.grow(20,20);
    }

    private void getNewNote() {
        Note last = noteList.peekLast();
        if (last == null) {
            noteList.add(new Note());
            return;
        }
        int distanceToLast = (int) (Math.random() * 700 + 150);
        if (noteList.size() >= 5 || last.getY() < distanceToLast) {
            return;
        }
        noteList.add(new Note());
    }

    public void keyPressed(Column col) {
        for (Note note : noteList) {
            if (note.getColumn() != col) {
                continue;
            }
            if (note.isInTarget()) {
                counter.increase();
                note.hide();
                return;
            }
            counter.decrease();
        }
    }

    @Override
    public void delete() {
        //background.delete();
    }

    @Override
    public String toString() {
        return "Stage";
    }
}
