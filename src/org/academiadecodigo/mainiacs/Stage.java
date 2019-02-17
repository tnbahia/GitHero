package org.academiadecodigo.mainiacs;

import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Stage {
    //private Music music;
    private StageType stageType;
    private Player player;
    private Counter counter;

    public Stage(Player player, StageType stageType) {
        this.player = player;
        this.stageType = stageType;
        counter = new Counter();
    }

    public void start() {
        drawStage();
    }

    private void drawStage(){
        stageType.getBackground().draw();
    }
}
