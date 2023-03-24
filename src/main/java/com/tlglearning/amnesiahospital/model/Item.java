package com.tlglearning.amnesiahospital.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Item {

  private String name;
  private String description;
  private int type;
  private int value;
  private int durability;
  private String[] mapArt;

  @JsonCreator
  public Item(@JsonProperty("name") String name,
      @JsonProperty("description") String description,
      @JsonProperty("type") int type,
      @JsonProperty("value") int value,
      @JsonProperty("mapArt") String[] mapArt,
      @JsonProperty("durability") int durability) {
    this.name = name;
    this.description = description;
    this.type = type;
    this.value = value;
    this.durability = durability;
    this.mapArt = mapArt;
  }

  public Item() {
  }

  public String getName() {
    return name;
  }

  public String getDescription() {
    return description;
  }

  public int getType() {
    return type;
  }

  public int getValue() {
    return value;
  }

  public int getDurability() {
    return durability;
  }

  public void setDurability(int durability) {
    this.durability = durability;
  }

  public String[] getMapArt() { // New getter method for the map art field
    return mapArt;
  }
}

