package com.tlglearning.amnesiahospital.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.net.MalformedURLException;
import java.net.URL;

public class AudioConfig {
  @JsonProperty("background_music")
  private String backgroundMusicString;
  private URL backgroundMusic;

  public AudioConfig() {
  }

  public URL getBackgroundMusic() {
    if (backgroundMusic == null) {
      try {
        backgroundMusic = new URL(backgroundMusicString);
      } catch (MalformedURLException e) {
        e.printStackTrace();
      }
    }
    return backgroundMusic;
  }
}
