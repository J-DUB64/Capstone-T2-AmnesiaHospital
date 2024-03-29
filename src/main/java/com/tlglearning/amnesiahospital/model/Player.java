package com.tlglearning.amnesiahospital.model;

import java.sql.SQLOutput;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Player {

  private String name;
  private int health;
  private Room currentRoom;
  private Inventory inventory;
  private boolean foundPilot;


  public Player(String name, Room startingRoom) {
    this.name = name;
    this.health = 100;
    this.currentRoom = startingRoom;
    this.inventory = new Inventory();
    this.foundPilot = false;
  }

  public void move(String direction, List<Room> rooms) {
    if (currentRoom.getExits().containsKey(direction)) {
      for (Room room : rooms) {
        if (room.getCoordinate().equals(currentRoom.getExits().get(direction))) {
          currentRoom = room;
          if (currentRoom.getNPC().isEmpty()) {
            break;
          } else {
            System.out.println("You see someone standing in the corner");
          }
          break;
        }
      }
    } else{
    System.out.println("You cannot go that way.");
  }
}

  public void use(String itemName) {
    Item item = new Item();
    for (Item inventoryItem : inventory) {
      if (inventoryItem.getName().equals(itemName)) {
        item = inventoryItem;
      }
    }
    if (inventory.contains(item)) {
      if (item.getType() == 1) {
        health = health + item.getValue();
        inventory.remove(item);
      } else if (item.getType() == 2 && currentRoom.getCoordinate().equals("north5")) {
        currentRoom.getExits().put("north", "north6");
        System.out.println("You have opened the door with the key. You can now go north.");
        int cutLock = currentRoom.getDescription().length()-29;
        currentRoom.setDescription(currentRoom.getDescription().substring(0,cutLock));
      } else if (item.getName().equals("map")) {
        String[] mapArt = item.getMapArt();
        System.out.println("You are currently in " + currentRoom.getName() + " at coordinates " + currentRoom.getCoordinate());
        for (String line : mapArt) {
          System.out.println(line);
        }
      } else {
        System.out.println("You use the " + item.getName() + ". It has no effect.");
      }
    }
  }

  public void pickUpItem(String item, List<Item> items){
    if(currentRoom.getItems().contains(item)){
      for(Item gameItem : items){
        if(gameItem.getName().equals(item)){
          System.out.println("You picked up the " + gameItem.getName());
          inventory.add(gameItem);
          currentRoom.getItems().remove(gameItem.getName());
          break;
        }
      }
    } else {
      System.out.println("That item is not in this room.");
    }
  }

  public void dropItem(String item){
    Item dropItem = new Item();
    for(Item iterItem : inventory){
      if(iterItem.getName().equals(item)){
        dropItem=iterItem;
      }
    }
    if(inventory.contains(dropItem)){
      for(Item inventoryItem : inventory){
        if(inventoryItem.equals(dropItem)){
          System.out.println("You dropped the " + inventoryItem.getName());
          inventory.remove(inventoryItem);
          currentRoom.getItems().add(inventoryItem.getName());
          break;
        }
      }
    } else {
      System.out.println("That item is not in your inventory.");
    }
  }

  public Room getCurrentRoom() {
    return currentRoom;
  }

  public void showInventory() {
    if (inventory.isEmpty()) {
      System.out.println("Your inventory is empty.");
    } else {
      System.out.println("Your inventory contains:");
      for (Item item : inventory) {
        System.out.println("- " + item.getName());
      }
    }
  }

  public void printInventory(){
    if(inventory == null || inventory.isEmpty()){
      System.out.println("[]");
    }
    else {
      System.out.print("[ ");
      for (Item item : inventory) {
        System.out.print(item.getName() + ", ");
      }
      System.out.println("]");
    }
  }

  public int getHealth() {
    return health;
  }

  public void setHealth(int health) {
    this.health = health;
  }

  public void playerAttack(Zombie zombie, Item item) {
    Random num = new Random();
    int getMissProbability = num.nextInt(100);

    if (getMissProbability < health) {
      System.out.println("You hit the zombie with the " + item.getName());
      int playerDamage = num.nextInt(item.getValue());
      zombie.setHealth(zombie.getHealth() - playerDamage);
      System.out.println("You deal " + playerDamage + " points of damage.");
      item.setDurability(item.getDurability()-1);
      if(item.getDurability()==0){
        System.out.println("The " + item.getName() + " breaks in your hand!");
        inventory.remove(item);
      }
    } else {
      System.out.println("You attack the zombie but miss!");
    }
  }

  public void showWeapons() {
    Item check = null;
    System.out.println("Weapons in your inventory: ");
    for(Item weapon : inventory){
      if(weapon.getType()==4){
        check = weapon;
        System.out.println("- " + weapon.getName());
      }
    }
    if(check == null){
      System.out.println("You have no weapons in your inventory.");
    }
  }

  public Inventory getInventory() {
    return inventory;
  }

  public boolean isFoundPilot() {
    return foundPilot;
  }

  public void giveHealingSerum(List<Npc> npcs) {
    boolean found = false;
    for (Npc npc : npcs) {
      if (currentRoom.getNPC().contains(npc.getName())) {
        found = true;
        Item serum = null;
        for (Item item : inventory) {
          if (item.getName().equalsIgnoreCase("health serum")) {
            serum = item;
            inventory.remove(serum);
            npc.setHealed(true);
            System.out.println("You give the health serum to " + npc.getName() + ".");
            if (npc.getName().equals("Steve Perez")) {
              System.out.println("Thank you! Now, let's get to that helicopter on the roof!");
              List<String> healed = List.of(
                  "Thank you! Now, let's get to that helicopter on the roof!");
              npc.setDialogue(healed);
              foundPilot = true;
            }
            break;
          }
        }
      }
    }
    if (!found) {
      System.out.println("NPC not found.");
    }
  }
}

