package org.academiadecodigo.mainiacs.Screen;

import org.academiadecodigo.mainiacs.*;

public class Stage extends Screen {
    //private Music music;

    private Counter counter = new Counter();
    private int targetStartY = 300;
    private int targetEndY = 400;
    private NoteList noteList;

    public Stage(Player player, ScreenType stageType) {
        super(stageType,player);
    }

    public void start() {
        player.setStage(this);
        drawStage();
        while (true) {
            while (noteList.size() < stageType.getDifficulty() * 2) {
                getNewNote();
            }
            noteList.moveNotes();
        }
    }

    private void drawStage() {
        stageType.getBackground().draw();
        counter.draw();
    }

    private void getNewNote() {
        noteList.add(new Note());
    }

    public void keyPressed(Column col) {
        if (noteList.noteInRange(col)) {
            counter.increase();
        } else {
            counter.decrease();
        }
    }
}
