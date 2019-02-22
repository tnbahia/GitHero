package org.academiadecodigo.mainiacs.Screen;

import org.academiadecodigo.simplegraphics.pictures.Picture;

public enum ScreenType {
    START_MENU("http://st2.depositphotos.com/1813786/7041/v/950/depositphotos_70414397-stock-illustration-vintage-label-rock-and-roll.jpg"),
    STAGE("http://rndr.juniqe-production.juniqe.com/media/catalog/product/cache/x800/675/32/675-32-202X-Black.jpg");

    ScreenType(String backgroundLink) {
        Picture background = new Picture(10, 0, backgroundLink);
        double dif = Screen.SCREEN_HEIGHT - background.getHeight();
        background.grow(dif,dif);
    }
}
