package org.academiadecodigo.mainiacs;

import org.academiadecodigo.mainiacs.Screen.Stage;

import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;
import java.net.URL;

public class Music {
    public void startMusic(){
        String pathStr = "/resources/thunderstruck.wav";
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
            Clip clip = AudioSystem.getClip();
            clip.open(audioInputStream);
            clip.start();
            clip.loop(clip.LOOP_CONTINUOUSLY);
        } catch (LineUnavailableException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
