package com.tlglearning.amnesiahospital.controller;

import com.tlglearning.amnesiahospital.model.AsciiArt;
import com.tlglearning.amnesiahospital.model.GameData;
import com.tlglearning.amnesiahospital.model.GameData.Choice;
import com.tlglearning.amnesiahospital.model.Item;
import com.tlglearning.amnesiahospital.model.JsonData;
import com.tlglearning.amnesiahospital.model.Player;
import com.tlglearning.amnesiahospital.model.Room;
import java.util.List;
import java.util.Scanner;

public class GameFlow {
  public static final String PRESS_ENTER = "Press Enter to continue...";
  private static Scanner scanner = new Scanner(System.in);
  JsonData jsonData = new JsonData();
  List<Room> rooms = jsonData.getBoard();
  GameData gameData = jsonData.getDialogue();
  List<Item> items = jsonData.getItems();

  Player mainPlayer = new Player("person", rooms.get(0));



  public void userTurn(){
    while(true){
    System.out.println("You are in " + mainPlayer.getCurrentRoom().getName());
    String userInput = scanner.nextLine();
    if(userInput.isEmpty()){
      System.out.println("Not a valid input.");
    }
    else if(userInput.startsWith("go ")){
      String direction = userInput.substring(3);
      mainPlayer.move(direction, rooms);
    }
    else if(userInput.startsWith("use ")){
      String item = userInput.substring(4);
      mainPlayer.use(item);
    }
    else if(userInput.startsWith("get ")){
      String item = userInput.substring(4);
      mainPlayer.pickUpItem(item, items);
    }
    else if(userInput.startsWith("look")) {
      lookAround();
    }

    else if(userInput.startsWith("quit")) {
      quit();
    }

    else if (userInput.startsWith("examine ")) {
      String itemName = userInput.substring(8);
      examine(itemName);
    }

    else if (userInput.startsWith("drop ")) {
      String itemName = userInput.substring(5);
      mainPlayer.dropItem(itemName);
    }

    else if (userInput.equalsIgnoreCase("inventory")) {
      mainPlayer.showInventory();
    }

    else{
      System.out.println("That is not a valid input. Your choices are:\n" +
          "go [direction]\n" +
          "use [item]\n" +
          "get [item]\n" +
          "look\n" +
          "quit\n" +
          "examine [item]\n" +
          "drop [item]\n" +
          "inventory");
    }
  }
}
  public static void clearScreen() {
    System.out.print("\033[H\033[2J");
    System.out.flush();
  }

  public String quit() {
    String input;
    System.out.println("Are you sure you want to quit? (y/n)");
    input = scanner.nextLine();
    if (input.equalsIgnoreCase("y")) {
      System.out.println("Thanks for playing Amnesia Hospital. Goodbye!");
      System.exit(0);
    }
    return input;
  }

  public void startGame() {
    AsciiArt.printAmnesiaHospitalTitle();
    System.out.println(PRESS_ENTER);
    // Wait for user to press enter
    Scanner scanner = new Scanner(System.in);
    scanner.nextLine();
    clearScreen();
    System.out.println(gameData.getDescription());
    System.out.println();

    while (true) {
      // Prompt the player to start a new game
      System.out.println("Do you want to start the game? y/n");

      for (Choice choice : gameData.getPrompts().get(0).getChoices()) {
        System.out.println(choice.getLabel());
      }
      String userInput = scanner.nextLine();
      if (userInput.equalsIgnoreCase("y")) {
        System.out.println(gameData.getStartMessage());
        userTurn();
        break;
      } else if (userInput.equalsIgnoreCase("n")) {
        quit();
      }
      }
    System.out.println("thank you for playing.");
    }

  public void lookAround() {
    Room currentRoom = mainPlayer.getCurrentRoom();
    System.out.println("Current location: " + currentRoom.getName());
    System.out.println("Description: " + currentRoom.getDescription());

    System.out.println("Available exits:");
    for (String exit : currentRoom.getExits().keySet()) {
      System.out.println("- " + exit);
    }

    List<String> items = currentRoom.getItems();
    if (!items.isEmpty()) {
      System.out.println("Items in the room:");
      for (String item : items) {
        System.out.println("- " + item);
      }
    } else {
      System.out.println("There are no items in this room.");
    }
  }

  public void examine(String itemName) {
    boolean found = false;
    for (Item item : items) {
      if (item.getName().equalsIgnoreCase(itemName)) {
        System.out.println("Item: " + item.getName());
        System.out.println("Description: " + item.getDescription());
        found = true;
        break;
      }
    }
    if (!found) {
      System.out.println("Item not found.");
    }
  }
}


