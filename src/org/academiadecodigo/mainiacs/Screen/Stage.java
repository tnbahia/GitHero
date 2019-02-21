package org.academiadecodigo.mainiacs.Screen;

import org.academiadecodigo.mainiacs.*;
import org.academiadecodigo.simplegraphics.pictures.Picture;

import java.util.LinkedList;

public class Stage extends Screen {

    private Counter counter = new Counter();
    private Target target;
    private LinkedList<Note> noteList;
    private Picture background;
    private static Music music = new Music();


    public Stage(ScreenType screenType) {
        super(screenType);
        String link = "stage-background.jpg";
        background = new Picture(10, 10, link);
        double grow = Screen.SCREEN_HEIGHT - background.getHeight();
        background.grow(0, grow);
    }

    public void start() throws InterruptedException {
        noteList = new LinkedList<>();
        target = new Target();
        drawStage();
        while (true) {
            //int sleep = counter.getPoints() > 1500 ? 1 : counter.getPoints() > 1000 ? 2 : counter.getPoints() > 500 ? 3 : 4;
            Thread.sleep(counter.getPoints() > 1500 ? 1 : counter.getPoints() > 1000 ? 2 : counter.getPoints() > 500 ? 3 : 4);
            getNewNote();
            for (Note note : noteList) {
                note.move();
            }
            noteList.removeIf(note -> note.reachedEnd());
        }
    }

    private void drawStage() throws InterruptedException{
        background.draw();
        music.startMusic();
        counter.draw();
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
}
