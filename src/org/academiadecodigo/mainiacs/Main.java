package org.academiadecodigo.mainiacs;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Note note = new Note();
        int i = 100;
        while (i > 0) {
            note.ellipse.draw();

            Thread.sleep(24);

            note.ellipse.grow(1, 1);

            i--;
        }

        Counter counter = new Counter();
        counter.getText();
    }
}
