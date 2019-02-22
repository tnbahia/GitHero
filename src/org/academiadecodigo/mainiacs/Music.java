package org.academiadecodigo.mainiacs;

import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;
import java.net.URL;

public class Music {

    private static Clip clip;

    public void startMusic(){
        String pathStr = "/resources/sweet-child-o-mine.wav";
        URL soundURL;
        AudioInputStream audioInputStream = null;
        try{
            soundURL = Game.class.getResource(pathStr);
            if(soundURL == null){
                pathStr = pathStr.substring(1);
                File file = new File(pathStr);
                soundURL = file.toURI().toURL();
            }
            audioInputStream = AudioSystem.getAudioInputStream(soundURL);
        }catch (UnsupportedAudioFileException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            clip = AudioSystem.getClip();
            clip.open(audioInputStream);
            clip.start();
        } catch (LineUnavailableException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void stopMusic() {
        clip.close();
    }

}
