package com.tlglearning.amnesiahospital.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Npc {

  private String name;
  private String location;
  private List<String> dialogue;
  private String description;

  @JsonCreator public Npc(@JsonProperty("name") String name,
      @JsonProperty("location") String location,
      @JsonProperty("dialogue") List<String> dialogue,
      @JsonProperty("description")String description) {
    this.name = name;
    this.location = location;
    this.dialogue = dialogue;
    this.description = description;
  }

  public Npc() {
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getLocation() {
    return location;
  }

  public void setLocation(String location) {
    this.location = location;
  }

  public List<String> getDialogue() {
    return dialogue;
  }

  public void setDialogue(List<String> dialogue) {
    this.dialogue = dialogue;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  @Override
  public String toString() {
    return "Npc{" +
        "name='" + name + '\'' +
        ", location='" + location + '\'' +
        ", dialogue='" + dialogue + '\'' +
        ", description='" + description + '\'' +
        '}';
  }
  private boolean healed;

  public boolean isHealed() {
    return healed;
  }

  public void setHealed(boolean healed) {
    this.healed = healed;
  }

}

