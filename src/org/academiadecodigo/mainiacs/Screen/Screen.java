package org.academiadecodigo.mainiacs.Screen;

public abstract class Screen {
    public static final double SCREEN_HEIGHT = 800;
    public static final double SCREEN_WIDTH = 750;

    private ScreenType screenType;
    //private Player player;

    public Screen(ScreenType screenType) {
        this.screenType = screenType;
        //this.player = player;
    }

    public abstract void start();

    public ScreenType getScreenType() {
        return screenType;
    }

    public void hide() {
        screenType.getBackground().delete();
    }

    public abstract void delete();

    /*public Player getPlayer() {
        return player;
    }*/
}
