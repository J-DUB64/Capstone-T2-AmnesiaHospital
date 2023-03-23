package com.tlglearning.amnesiahospital.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Item {
  private String name;
  private String description;
  private int type;
  private int value;
  private int durability;

  @JsonCreator
  public Item(@JsonProperty("name") String name,
      @JsonProperty("description") String description,
      @JsonProperty("type") int type,
      @JsonProperty("value") int value,
      @JsonProperty("durability") int durability) {
    this.name = name;
    this.description = description;
    this.type = type;
    this.value = value;
    this.durability=durability;
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

  //  public void use(Player player) {
//    switch (type.toLowerCase()) {
//      case "health_serum":
//        player.heal(value);
//        System.out.println("You used " + name + " and healed " + value + " health points.");
//        break;
//      // Add more cases for different item types here
//      default:
//        System.out.println("This item cannot be used.");
//        break;
//    }
  }
//}
