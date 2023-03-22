package com.tlglearning.amnesiahospital.model;
import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;

public class MusicPlayer {
  private Clip clip;

  public void play(URL filePath) {
    try {
      File musicFile = new File(filePath.toURI());
      AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(musicFile);
      AudioFormat format = audioInputStream.getFormat();
      DataLine.Info info = new DataLine.Info(Clip.class, format);
      clip = (Clip) AudioSystem.getLine(info);
      clip.open(audioInputStream);
      clip.loop(Clip.LOOP_CONTINUOUSLY);
      clip.start();
    } catch (UnsupportedAudioFileException | IOException | LineUnavailableException | URISyntaxException e) {
      e.printStackTrace();
    }
  }

  public void stop() {
    if (clip != null) {
      clip.stop();
      clip.close();
    }
  }
}