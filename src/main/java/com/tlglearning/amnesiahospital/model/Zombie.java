package com.tlglearning.amnesiahospital.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Random;

public class Zombie {

  private String name;
  private int health;
  private int hitPeak;
  private String location;

  @JsonCreator
  public Zombie(@JsonProperty("name") String name,
      @JsonProperty("health") int health,
      @JsonProperty("hitPeak") int hitPeak,
      @JsonProperty("location") String location) {
    this.name = name;
    this.health = health;
    this.hitPeak = hitPeak;
    this.location = location;
  }

  public String getName() {
    return name;
  }

  public int getHealth() {
    return health;
  }

  public void setHealth(int health) {
    this.health = health;
  }

  public int getHitPeak() {
    return hitPeak;
  }

  public void setHitPeak(int hitPeak) {
    this.hitPeak = hitPeak;
  }

  public String getLocation() {
    return location;
  }

  public void setLocation(String location) {
    this.location = location;
  }

  public void zombieAttack(Player player) {
    Random num = new Random();
    int getMissProbability = num.nextInt(30);

    if (getMissProbability < health) {
      System.out.println("The zombie hits you!");
      int zombieDamage = num.nextInt(getHitPeak());
      player.setHealth(player.getHealth()-zombieDamage);
      System.out.println("You take " + zombieDamage + " points of damage.");
    }
    else{
      System.out.println("the zombie swings at you but misses.");
    }
  }
}



