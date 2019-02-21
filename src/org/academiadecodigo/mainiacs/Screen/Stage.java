package org.academiadecodigo.mainiacs.Screen;

import org.academiadecodigo.mainiacs.*;
import org.academiadecodigo.simplegraphics.pictures.Picture;

import java.util.Iterator;
import java.util.LinkedList;

public class Stage extends Screen {

    private Counter counter = new Counter();
    private Target target;
    private LinkedList<Note> noteList;
    private Picture background;
    private int noteCount;

    public Stage(ScreenType screenType) {
        super(screenType);
        String link = "stage-background.jpg";
        background = new Picture(10, 10, link);
        double grow = Screen.SCREEN_HEIGHT - background.getHeight();
        background.grow(0, grow);
    }

    public void start() {
        noteList = new LinkedList<>();
        target = new Target();
        drawStage();
        int sleepMillis = 3;
        int sleepNanos = 999999;

        while (true) {
            //int sleepNanos = 10000 - counter.getPoints();
            //int sleepMillis = counter.getPoints() > 2000 ? 1 : counter.getPoints() > 1000 ? 2 : counter.getPoints() > 500 ? 3 : 4;
            //int sleepNanos = 999999 - counter.getPoints()*100;
            sleepNanos -= 100;
            if (sleepNanos <= 0) {
                sleepNanos = 999999;
                if (sleepMillis > 1) {
                    sleepMillis--;
                }
            }

            //System.out.println(sleepNanos);
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

            //for (Note note : noteList) {
            //    note.move();
            //}
            //noteList.removeIf(note -> note.reachedEnd());
        }
    }

    private void drawStage() {
        background.draw();
        counter.draw();
        Column.draw();
        target.draw();
        counter.grow(20, 20);
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
}
