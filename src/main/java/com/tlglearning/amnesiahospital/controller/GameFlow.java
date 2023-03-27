package com.tlglearning.amnesiahospital.controller;
import com.tlglearning.amnesiahospital.model.MusicPlayer;
import com.tlglearning.amnesiahospital.model.AsciiArt;
import com.tlglearning.amnesiahospital.model.Command;
import com.tlglearning.amnesiahospital.model.GameData;
import com.tlglearning.amnesiahospital.model.GameData.Choice;
import com.tlglearning.amnesiahospital.model.Item;
import com.tlglearning.amnesiahospital.model.JsonData;
import com.tlglearning.amnesiahospital.model.Npc;
import com.tlglearning.amnesiahospital.model.Player;
import com.tlglearning.amnesiahospital.model.Room;
import com.tlglearning.amnesiahospital.model.Zombie;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class GameFlow {

  public void mainMenu() {
    Scanner scanner = new Scanner(System.in);
    String input;

    do {
      System.out.println("Main menu:");
      System.out.println("1. Start game");
      System.out.println("2. Audio settings");
      System.out.println("3. Quit");
      System.out.print("Enter your choice (1-3): ");
      input = scanner.nextLine();

      switch (input) {
        case "1":
          startGame();
          break;
        case "2":
          audioSettings();
          break;
        case "3":
          System.out.println("Exiting the game...");
          break;
        default:
          System.out.println("Invalid choice. Please try again.");
          break;
      }
    } while (!input.equals("3"));
  }


  private MusicPlayer musicPlayer;

  public GameFlow(MusicPlayer musicPlayer) {
    this.musicPlayer = musicPlayer;
  }

  public void audioSettings() {
    Scanner scanner = new Scanner(System.in);
    String input;

    do {
      System.out.println("Audio settings:");
      System.out.println("1. Toggle mute");
      System.out.println("2. Increase volume");
      System.out.println("3. Decrease volume");
      System.out.println("4. Back to main menu");
      System.out.print("Enter your choice (1-4): ");
      input = scanner.nextLine();

      switch (input) {
        case "1":
          musicPlayer.mute(musicPlayer.getToMute());
          musicPlayer.setToMute(!musicPlayer.getToMute());
          System.out.println("Music " + (!musicPlayer.getToMute()? "muted" : "unmuted"));
          break;
        case "2":
          float currentVolume = musicPlayer.getVolume();
          musicPlayer.setVolume(currentVolume + 5.0f);
          System.out.println("Volume increased.");
          break;
        case "3":
          currentVolume = musicPlayer.getVolume();
          musicPlayer.setVolume(currentVolume - 5.0f);
          System.out.println("Volume decreased.");
          break;
        case "4":
          System.out.println("Returning to main menu.");
          break;
        default:
          System.out.println("Invalid choice. Please try again.");
          break;
      }
    } while (!input.equals("4"));
  }
  public void inGameAudioSettings() {
    Scanner scanner = new Scanner(System.in);
    String input;

    do {
      System.out.println("Audio settings:");
      System.out.println("1. Toggle mute");
      System.out.println("2. Increase volume");
      System.out.println("3. Decrease volume");
      System.out.println("4. Back to game");
      System.out.print("Enter your choice (1-4): ");
      input = scanner.nextLine();

      switch (input) {
        case "1":
          musicPlayer.mute(musicPlayer.getToMute());
          musicPlayer.setToMute(!musicPlayer.getToMute());
          System.out.println("Music " + (!musicPlayer.getToMute()? "muted" : "unmuted"));
          break;
        case "2":
          float currentVolume = musicPlayer.getVolume();
          musicPlayer.setVolume(currentVolume + 5.0f);
          System.out.println("Volume increased.");
          break;
        case "3":
          currentVolume = musicPlayer.getVolume();
          musicPlayer.setVolume(currentVolume - 5.0f);
          System.out.println("Volume decreased.");
          break;
        case "4":
          System.out.println("Returning to game.");
          break;
        default:
          System.out.println("Invalid choice. Please try again.");
          break;
      }
    } while (!input.equals("4"));
  }


  public static final String PRESS_ENTER = "Press Enter to continue...";
  private static Scanner scanner = new Scanner(System.in);
  JsonData jsonData = new JsonData();
  List<Room> rooms = jsonData.getBoard();
  List<Npc> npcs = jsonData.getNPC();
  GameData gameData = jsonData.getDialogue();
  List<Item> items = jsonData.getItems();
  List<Command> helpData = jsonData.getHelp();
  List<Zombie> zombies = jsonData.getZombies();

  Player mainPlayer = new Player("person", rooms.get(0));


  public void userTurn() {
    while (true) {
      System.out.println("----------Current Status----------");
      System.out.println("You are in " + mainPlayer.getCurrentRoom().getName());
      System.out.println("Current Health: " + mainPlayer.getHealth());
      mainPlayer.printInventory();

      String userInput = scanner.nextLine();
      if (userInput.isEmpty()) {
        System.out.println("Not a valid input.");
      } else if (userInput.startsWith("go ")) {
        String direction = userInput.substring(3);
        mainPlayer.move(direction, rooms);
      } else if (userInput.startsWith("use ")) {
        String item = userInput.substring(4);
        mainPlayer.use(item);
      } else if (userInput.startsWith("get ")) {
        String item = userInput.substring(4);
        mainPlayer.pickUpItem(item, items);
      } else if (userInput.startsWith("look")) {
        lookAround();
      } else if (userInput.startsWith("fight")) {
        Zombie check = null;
        for (Zombie iterZombie : zombies) {
          if (iterZombie.getLocation().equals(mainPlayer.getCurrentRoom().getCoordinate())) {
            check = iterZombie;
            combat(mainPlayer, iterZombie);
            break;
          }
        }
        if (check == null) {
          System.out.println("You cannot fight anything here.");
        }
      } else if (userInput.startsWith("quit")) {
        quit();
      } else if (userInput.startsWith("examine ")) {
        String itemName = userInput.substring(8);
        examine(itemName);
      } else if (userInput.startsWith("drop ")) {
        String itemName = userInput.substring(5);
        mainPlayer.dropItem(itemName);
      } else if (userInput.toLowerCase().startsWith("talk")) {
        talk();
      } else if (userInput.equalsIgnoreCase("inventory")) {
        mainPlayer.showInventory();
      } else if (userInput.equalsIgnoreCase("help")) {
        getHelp();
      } else if (userInput.startsWith("give ")) {
        String itemName = userInput.substring(5);
        if (itemName.equalsIgnoreCase("health serum")) {
          mainPlayer.giveHealingSerum(npcs);
        } else {
          System.out.println("You can only give healing serum to NPCs.");
        }
      } else if(userInput.startsWith("audio")){
        inGameAudioSettings();
      }

      else {
        System.out.println("That is not a valid input. Your choices are:\n" +
            "help\n" +
            "go [direction]\n" +
            "use [item]\n" +
            "get [item]\n" +
            "look\n" +
            "quit\n" +
            "fight\n" +
            "audio\n"+
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

  public void quit() {
    String input;
    System.out.println("Are you sure you want to quit? (y/n)");
    input = scanner.nextLine();
    if (input.equalsIgnoreCase("y")) {
      System.out.println("Thanks for playing Amnesia Hospital. Goodbye!");
      System.exit(0);
    }
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

    List<String> npc = currentRoom.getNPC();
    if (!npc.isEmpty()) {
      if(currentRoom.getNPC().contains("zombie")){
        System.out.println("The person you see is a zombie! They lunge forward to attack you!");
        for(Zombie zombie : zombies) {
          if(zombie.getLocation().equals(currentRoom.getCoordinate())) {
            combat(mainPlayer, zombie);
          }
        }
      }
      else {
        System.out.println("People in the room:");
        for (String npcName : npc) {
          for (Npc npcObj : npcs) {
            if (npcObj.getName().equalsIgnoreCase(npcName)) {
              System.out.println("- " + npcObj.getName() + " (" + npcObj.getDescription() + ")");
              break;
            }
          }
        }
      }
    }
  }

  public void examine(String itemName) {
    boolean found = false;
    for (Item item : items) {
      if (item.getName().equalsIgnoreCase(itemName)) {
        System.out.println("Item: " + item.getName());
        System.out.println("Description: " + item.getDescription());
        if(item.getType()==4){
          System.out.println("Hits remaining: " + item.getDurability());
        }
        found = true;
        break;
      }
    }
    if(mainPlayer.getCurrentRoom().getCoordinate().equals("north6") && itemName.equals("apache")){
      System.out.println("You approach the impressive machine, but on the door you see a small combination lock.");
      comboLock();
    }
    else if(!found){
      System.out.println("Item not found.");
    }

  }

  private String getRandomDialogue(List<String> dialogues) {
    Random random = new Random();
    int index = random.nextInt(dialogues.size());
    return dialogues.get(index);
  }

  private void comboLock(){
    System.out.println("There are four number dials and above each someone has scratched in:");
    System.out.println("[W] [N] [E] [S]");
    String userInput = scanner.nextLine();
    if(userInput.equals("3984")){
      if(mainPlayer.isFoundPilot()){
        System.out.println("As you undo the lock, the pilot runs up and tells you to hop in. The helicopter starts up and lifts into the sky.");
        System.out.println("You have done it....You have made it out of AMNESIA HOSPITAL!");
      }
      else{
        System.out.println("You sheepishly climb into the cockpit.  This might be a bad idea...");
        System.out.println("As the blades start to spin you pray that you used to be a pilot before you lost your memory.");
        System.out.println("You pull back on the stick and immediately realize you are in trouble.");
        System.out.println("You clear the roof top but start to plummet to the earth....if only there was a pilot in that hospital....");
      }
      scanner.nextLine();
      quit();
    }
    else{
      System.out.println("You put " + userInput + " into the lock but it isn't opening.");
    }
  }

  public void talk() {
    boolean found = false;
    Room currentRoom = mainPlayer.getCurrentRoom();
    List<String> npcNames = currentRoom.getNPC();

    if(npcNames.contains("zombie")){
      System.out.println("GRaaaAAAAaaa MMMMuuuuunnnngghhhhhh");
    }
    else {
      for (Npc npc : npcs) {
        if (npcNames.contains(npc.getName())) {
          System.out.println("You are talking to " + npc.getName());
          System.out.println("Description: " + npc.getDescription());
          if (npc.getName().equalsIgnoreCase("Antonio Ramos")) {
            String randomDialogue = getRandomDialogue(npc.getDialogue());
            System.out.println("Dialogue: " + randomDialogue);
          } else {
            System.out.println("Dialogue: ");
            for (String line : npc.getDialogue()) {
              System.out.println("- " + line);
            }
          }
          found = true;
          break;
        }
      }
      if (!found) {
        System.out.println("NPC not found.");
      }
    }
  }

  public void getHelp() {
    System.out.println("Available commands:");
    for (Command command : helpData) {
      System.out.println("- " + command.getName() + ": " + command.getDescription());
    }
  }


  public void combat(Player player, Zombie zombie){
    while(true) {
      System.out.println("Your remaining health: " + player.getHealth());
      System.out.println("Zombie remaining health: " + zombie.getHealth());
      player.showWeapons();
      System.out.println("Commands:");
      System.out.println("- attack with [weapon]");
      System.out.println("- run");
      String userInput = scanner.nextLine();
      if (userInput.startsWith("attack with")) {
        String choice = userInput.substring(12);
        Item weaponChoice = null;
        for (Item iterItem : player.getInventory()) {
          if (iterItem.getName().equals(choice) && iterItem.getType() == 4) {
            weaponChoice = iterItem;
          }
        }
        if (weaponChoice != null) {
          player.playerAttack(zombie, weaponChoice);
          if (zombie.getHealth() < 1) {
            System.out.println("You defeat the zombie! He disintegrates onto the floor.");
            List<String> empty = List.of();
            player.getCurrentRoom().setNPC(empty);
            return;
          }
        }
        zombie.zombieAttack(player);
        if(player.getHealth()<1){
          System.out.println("The zombie lunges forward and bites you. You feel strange...");
          System.out.println("You body is changing.....");
          System.out.println("You crave...flesh...");
          System.out.println("You are now a permanent patient of AMNESIA HOSPITAL!");
          scanner.nextLine();
          System.exit(0);
        }
      }
      if(userInput.startsWith("run")){
        Random rand = new Random();
        int odds = rand.nextInt(11);
        if(odds>5){
          System.out.println("You back away from the zombie, and run...");
          if(player.getCurrentRoom().getExits().containsKey("south")){
            System.out.println("You run south.");
            player.move("south", rooms);
            break;
          }
          else if(player.getCurrentRoom().getExits().containsKey("west")){
            System.out.println("You run west.");
            player.move("west", rooms);
            break;
          }
          else if(player.getCurrentRoom().getExits().containsKey("north")){
            System.out.println("You run north.");
            player.move("north", rooms);
            break;
          }
          else{
            System.out.println("You run east.");
            player.move("east", rooms);
            break;
          }
        }
        else{
          System.out.println("As you back away, the zombie twitches....");
          System.out.println("You stop, unsure if he saw you try to run, but he lunges to attack.");
          zombie.zombieAttack(player);
        }
      }
    }
  }
}


