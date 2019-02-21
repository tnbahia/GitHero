package org.academiadecodigo.mainiacs.Screen;

import org.academiadecodigo.mainiacs.*;
import org.academiadecodigo.simplegraphics.pictures.Picture;

import java.util.Iterator;
import java.util.LinkedList;

public class Stage extends Screen {

    private Counter counter = new Counter();
    private Target target;
    private LinkedList<Note> noteList;

    private static Picture background;

    private static Music music = new Music();

    public Stage(ScreenType screenType) {
        super(screenType);
        String link = "backgroundAl.jpg";
        background = new Picture(10, 10, link);
        double grow = Screen.SCREEN_HEIGHT - background.getHeight();
        background.grow(0, grow);
    }

    public void start() {
        noteList = new LinkedList<>();

        drawStage();
        int sleepMillis = 3;
        int sleepNanos = 999999;

        while (true) {

            sleepNanos -= 100;
            if (sleepNanos <= 0) {
                sleepNanos = 999999;
                if (sleepMillis > 1) {
                    sleepMillis--;
                }
            }

            try {
                Thread.sleep(sleepMillis, sleepNanos);
            } catch (InterruptedException e) {
                System.out.println("IN START EXCEPTION");
            }

            getNewNote();

            Iterator<Note> it = noteList.listIterator();

            while (it.hasNext()) {
                Note n = it.next();

                n.move();

                if (n.reachedEnd()) {
                    it.remove();
                }
            }

            if (counter.getPoints() != 0 && counter.getPoints()%50 == 0) {
                target.setColor();
            }

        }
    }

    private void drawStage() {
        background.draw();
        music.startMusic();
        counter.draw();
        target = new Target();
        target.draw();
        Column.draw();
        counter.grow(20, 20);
        target.setColor();

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
        }
        counter.decrease();
    }

    @Override
    public void delete() {
        //background.delete();
    }

    @Override
    public String toString() {
        return "Stage";
    }

    public static Picture getBackground(){
        return background;
    }
}
