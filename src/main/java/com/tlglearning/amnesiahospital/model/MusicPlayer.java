package com.tlglearning.amnesiahospital.model;

import java.io.BufferedInputStream;
import javax.sound.sampled.*;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

public class MusicPlayer {
  private Clip clip;
  private Boolean toMute = true;

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

  public void setVolume(float volume) {
    if (clip != null) {
      FloatControl gainControl = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
      gainControl.setValue(volume);
    }
  }

  public float getVolume() {
    if (clip != null) {
      FloatControl gainControl = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
      return gainControl.getValue();
    }
    return 0.0f;
  }

  public void mute(boolean mute) {
    if (clip != null) {
      BooleanControl muteControl = (BooleanControl) clip.getControl(BooleanControl.Type.MUTE);
      muteControl.setValue(mute);
    }
  }



  public void stop() {
    if (clip != null) {
      clip.stop();
      clip.close();
    }
  }

  public Boolean getToMute() {
    return toMute;
  }

  public void setToMute(Boolean toMute) {
    this.toMute = toMute;
  }
}
