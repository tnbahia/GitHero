package org.academiadecodigo.mainiacs.Screen;

import org.academiadecodigo.mainiacs.*;
import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;

public class Stage extends Screen {
    //private Music music;

    private Counter counter = new Counter();
    private int targetStartY = 800;
    private int targetEndY = 900;
    private NoteList noteList;

    public Stage(Player player, ScreenType stageType) {
        super(stageType,player);
    }

    public void start() throws InterruptedException {
        noteList = new NoteList();
        getPlayer().setStage(this);
        drawStage();
        while (true) {
            while (noteList.size() < 5) {
                getNewNote();
            }
            noteList.moveNotes();
            Thread.sleep(2);
        }
    }

    private void drawStage() {
        getScreenType().getBackground().draw();
        counter.draw();
        Column.draw();
        int screenWidth = getScreenType().getBackground().getWidth();
        Rectangle target = new Rectangle(20,targetStartY,screenWidth-40,targetEndY-targetStartY);
        target.setColor(Color.RED);
        target.fill();
    }

    private void getNewNote() {
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
