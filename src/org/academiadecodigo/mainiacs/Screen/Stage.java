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
        String link = "http://rndr.juniqe-production.juniqe.com/media/catalog/product/cache/x800/675/32/675-32-202X-Black.jpg";
        background = new Picture(10, 10, link);
    }

    public void start() throws InterruptedException {
        noteList = new LinkedList<>();
        target = new Target();
        drawStage();
        while (true) {
            getNewNote();
            for (Note note : noteList) {
                note.move();
            }
            noteList.removeIf(note -> note.reachedEnd());
            Thread.sleep(2);
        }
    }

    private void drawStage() {
        background.draw();
        counter.draw();
        Column.draw();
        target.draw();
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
        background.delete();
    }
}
