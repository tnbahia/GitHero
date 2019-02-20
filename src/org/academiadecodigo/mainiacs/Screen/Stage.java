package org.academiadecodigo.mainiacs.Screen;

import org.academiadecodigo.mainiacs.*;
import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;

public class Stage extends Screen {
    //private Music music;

    private Counter counter = new Counter();
    private Target target;
    private NoteList noteList;

    public Stage(Player player, ScreenType stageType) {
        super(stageType,player);
    }

    public void start() throws InterruptedException {
        noteList = new NoteList();

        target = new Target();
        getPlayer().setStage(this);
        drawStage();
        while (true) {
            getNewNote();
            noteList.moveNotes();
            Thread.sleep(3);
        }
    }

    private void drawStage() {
        getScreenType().getBackground().draw();
        counter.draw();
        Column.draw();
        target.draw();
    }

    private void getNewNote() {
        Note last = noteList.getLastAdded();
        if (last == null) {
            noteList.add(new Note());
            return;
        }
        if (noteList.size() > 5 || last.getY() < 150) {
            return;
        }
        noteList.add(new Note());
    }

    public void keyPressed(Column col) {
        if (noteList.noteInRange(col)) {

            counter.increase();
        } else {
            //counter.decrease();
        }
    }
}
