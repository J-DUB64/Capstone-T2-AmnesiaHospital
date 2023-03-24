package com.tlglearning.amnesiahospital.model;

import java.io.BufferedInputStream;
import javax.sound.sampled.*;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

public class MusicPlayer {
  private Clip clip;

  public void play(URL fileURL) {
    try {
      URLConnection connection = fileURL.openConnection();
      InputStream inputStream = connection.getInputStream();
      BufferedInputStream bufferedInputStream = new BufferedInputStream(inputStream);
      AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(bufferedInputStream);
      AudioFormat format = audioInputStream.getFormat();
      DataLine.Info info = new DataLine.Info(Clip.class, format);
      clip = (Clip) AudioSystem.getLine(info);
      clip.open(audioInputStream);
      clip.loop(Clip.LOOP_CONTINUOUSLY);
      clip.start();
    } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
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
