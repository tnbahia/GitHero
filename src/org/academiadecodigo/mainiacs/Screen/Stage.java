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
    private int distanceBetweenNotes = 200;
    private Text streakText = new Text(SCREEN_WIDTH/2,150,"STREAK!!!");

    public Stage() {
        String link = "resources/backgroundAl.jpg";
        background = new Picture(10, 10, link);
        double grow = Screen.SCREEN_HEIGHT - background.getHeight();
        background.grow(0, grow);
    }

    public void init() {
        drawStage();
        k = new Keyboard(this);
        KeyboardEvent spaceBarEvent = new KeyboardEvent();
        spaceBarEvent.setKey(KeyboardEvent.KEY_SPACE);
        spaceBarEvent.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        k.addEventListener(spaceBarEvent);

        noteList = new LinkedList<>();
        start();
    }

    public void start() {
        int sleepMillis = 4;
        int sleepNanos = 999900;

        while (true) {

            if (playing) {
                sleepNanos -= 100;
                if (sleepNanos <= 0) {
                    if (distanceBetweenNotes > 100) {
                        distanceBetweenNotes -= 20;
                        System.out.println(distanceBetweenNotes);
                        sleepNanos = 999900;
                    } else if (distanceBetweenNotes == 100){
                        sleepMillis --;
                        distanceBetweenNotes -= 1;
                    } else {
                        distanceBetweenNotes -= 10;
                    }

                }
                //System.out.println(sleepMillis);
                //System.out.println(sleepNanos);
                try {
                    Thread.sleep(sleepMillis);
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

                if (streak == 10 || streak == 20 || streak > 30) {
                    target.setColor();
                }

                if (streak > 30) {
                    streakText.draw();
                    streakText.setColor(target.getColor());
                } else {
                    streakText.delete();
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
        counter.grow(50, 20);
        streakText.grow(50,20);
        Text instructions = new Text(20,780,"PRESS SPACE TO END GAME");
        instructions.setColor(Color.BLACK);
        instructions.draw();
    }

    private void getNewNote() {
        Note last = noteList.peekLast();
        if (last == null) {
            noteList.add(new Note());
            return;
        }
        if (noteList.size() >= 10 || last.getY() < distanceBetweenNotes) {
            return;
        }
        Note next = new Note();
        next.setDistanceToNext(distanceBetweenNotes);
        noteList.add(next);
    }

    public void keyPress(Column col) {
        for (Note note : noteList) {
            if (note.getColumn() != col) {
                continue;
            }
            if (note.isInTarget()) {
                if (streak > 30) {
                    counter.increase();
                }
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
        playing = !playing;
        if (!playing) {
            Picture finalScore = new Picture((background.getWidth() - 400) / 2.0, background.getHeight() / 2.0 - 200, "resources/score.png");
            finalScore.draw();
            Text score = new Text(450, 330, counter.toString());
            score.grow(10, 10);
            score.setColor(Color.WHITE);
            score.draw();
            music.stopMusic();
        } else {
            start();
        }

    }

    @Override
    public void keyReleased(KeyboardEvent keyboardEvent) {

    }
}
