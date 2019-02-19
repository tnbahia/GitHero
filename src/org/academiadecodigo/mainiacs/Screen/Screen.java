package org.academiadecodigo.mainiacs.Screen;

import org.academiadecodigo.mainiacs.Player;

public abstract class Screen {
    private ScreenType screenType;
    private Player player;

    public Screen(ScreenType screenType, Player player) {
        this.screenType = screenType;
        this.player = player;
    }

    public abstract void start();

    public ScreenType getScreenType() {
        return screenType;
    }
}
