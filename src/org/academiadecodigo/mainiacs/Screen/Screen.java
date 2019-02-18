package org.academiadecodigo.mainiacs.Screen;

import org.academiadecodigo.mainiacs.Player;

public abstract class Screen {
    private ScreenType stageType;
    private Player player;

    public Screen(ScreenType stageType, Player player) {
        this.stageType = stageType;
        this.player = player;
    }

    public abstract void start();
}
