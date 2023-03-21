package com.tlglearning.amnesiahospital.model;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;
import java.util.List;

public class Npc {

  private String name;
  private String location;
  private String dialogue;
  private String description;

  public Npc() {
  }

  public static List<Npc> fromJsonFile(String jsonFilePath) {
    ObjectMapper objectMapper = new ObjectMapper();
    try {
      return objectMapper.readValue(new File(jsonFilePath),
          new TypeReference<List<Npc>>() {
          });
    } catch (IOException e) {
      throw new RuntimeException("Failed to read JSON file: " + jsonFilePath,
          e);
    }
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

  public String getDialogue() {
    return dialogue;
  }

  public void setDialogue(String dialogue) {
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
}