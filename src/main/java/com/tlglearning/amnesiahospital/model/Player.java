package com.tlglearning.amnesiahospital.model;

import java.sql.SQLOutput;
import java.util.List;

public class Player {

  private String name;
  private int health;
  private Room currentRoom;
  private Weapon equippedWeapon;
  private Inventory inventory;


  public Player(String name, Room startingRoom) {
    this.name = name;
    this.health = 100;
    this.currentRoom = startingRoom;
    this.equippedWeapon = null;
    this.inventory = new Inventory();
  }

  public void move(String direction, List<Room> rooms) {
      if(currentRoom.getExits().containsKey(direction)){
        for (Room room : rooms) {
          if (room.getCoordinate().equals(currentRoom.getExits().get(direction))) {
            currentRoom = room;
            if (currentRoom.getNPC().isEmpty()) {
              break;
            }
            else {
              System.out.println("You see someone standing in the corner");
            }
            break;
          }
        }
      }
      else{
        System.out.println("You cannot go that way.");
    }
  }

  public void use(String itemName){
    Item item = new Item();
    for(Item inventoryItem : inventory){
      if(inventoryItem.getName().equals(itemName)){
        item = inventoryItem;
      }
    }
    if(inventory.contains(item)){
      if(item.getType() == 1){
        health = health + item.getValue();
      }
      else if(item.getType()==2 && currentRoom.getName().equals("north5")){
        currentRoom.getExits().put("north", "north6");
        System.out.println("You have opened the door with the key.");
      }
      else{
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
    }
    else{
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
    }
    else{
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

  public int getHealth() {
    return health;
  }

  public void setHealth(int health) {
    this.health = health;
  }
}


//  public void equipWeapon(Weapon weapon) {
//    if (inventory.containsKey(weapon.getName())) {
//      equippedWeapon = weapon;
//      System.out.println("You have equipped " + weapon.getName());
//    } else {
//      System.out.println("You don't have that weapon in your inventory.");
//    }
//  }

//  public void useItem(Item item) {
//    if (inventory.contains(item)) {
////      Item item = inventory.get(item);
//      item.use(this);
//    } else {
//      System.out.println("You don't have that item!");
//    }
//  }
//
//
//  public void addItem(Item item) {
//    inventory.add(item);
//  }
//
//  public void removeItem(Item item) {
//    inventory.remove(item);
//  }
//
//  public void takeDamage(int damage) {
//    health -= damage;
//    if (health <= 0) {
//      System.out.println("You have died!...what a shame");
//    } else {
//      System.out.println("You took " + damage + " damage. Health: " + health);
//    }
//  }
//
//  public void heal(int healthPoints) {
//    health += healthPoints;
//    System.out.println("You healed " + healthPoints + " health points. Health: " + health);
//  }
//
////  public void interact(Interactable interactable) {
////    interactable.interact(this);
////  }
//
//  public String getName() {
//    return name;
//  }
//
//  public int getHealth() {
//    return health;
//  }
//
//  public Room getCurrentRoom() {
//    return currentRoom;
//  }
//
//  public Weapon getEquippedWeapon() {
//    return equippedWeapon;
//  }
//
//  public Inventory getInventory() {
//    return inventory;
//  }
//}
//
//

