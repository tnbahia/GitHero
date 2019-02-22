package org.academiadecodigo.mainiacs.Screen;

import org.academiadecodigo.mainiacs.*;
import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Text;
import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;
import org.academiadecodigo.simplegraphics.pictures.Picture;

import java.util.LinkedList;

public class Stage extends Screen implements KeyboardHandler {

    private Counter counter = new Counter();
    private Target target;
    private LinkedList<Note> noteList;
    private static Picture background;
    private static Music music = new Music();
    private int streak;
    private boolean playing = true;
    private Keyboard k;

    public Stage() {
        String link = "backgroundAl.jpg";
        background = new Picture(10, 10, link);
        double grow = Screen.SCREEN_HEIGHT - background.getHeight();
        background.grow(0, grow);
    }

    public void start() {
        k = new Keyboard(this);
        KeyboardEvent spaceBarEvent = new KeyboardEvent();
        spaceBarEvent.setKey(KeyboardEvent.KEY_SPACE);
        spaceBarEvent.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        k.addEventListener(spaceBarEvent);

        noteList = new LinkedList<>();

        drawStage();
        int sleepMillis = 4;
        int sleepNanos = 999900;

        while (true) {
            if (playing) {
                sleepNanos -= (sleepMillis>3)?200:(sleepMillis>2)?150:10;
                if (sleepNanos <= 0) {
                    sleepNanos = 999900;
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

                for (Note note : noteList) {
                    note.move();
                }

                noteList.removeIf(note -> (note.isHit() && !note.isInTarget()));

                if(noteList.removeIf(note -> note.reachedEnd())) {
                    counter.decrease();
                    streak = 0;
                }

                if (streak == 10 || streak == 15 || streak >= 20) {
                    target.setColor();
                }
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

    public void keyPress(Column col) {
        for (Note note : noteList) {
            if (note.getColumn() != col) {
                continue;
            }
            if (note.isInTarget()) {
                counter.increase();
                streak++;
                note.hit();
                return;
            }
        }
        streak = 0;
        counter.decrease();
    }

    @Override
    public void delete() {
        background.delete();
    }

    @Override
    public String toString() {
        return "Stage";
    }

    public static Picture getBackground() {
        return background;
    }

    @Override
    public void keyPressed(KeyboardEvent keyboardEvent) {
        playing = false;
        Picture finalScore = new Picture((background.getWidth()-400)/2.0,background.getHeight()/2.0 - 200,"score.png");
        finalScore.draw();
        Text score = new Text(450,330,counter.toString());
        score.grow(10,10);
        score.setColor(Color.WHITE);
        score.draw();
        music.stopMusic();
    }

    @Override
    public void keyReleased(KeyboardEvent keyboardEvent) {

    }
}
