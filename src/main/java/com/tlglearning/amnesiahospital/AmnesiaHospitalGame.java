package com.tlglearning.amnesiahospital;

import com.tlglearning.amnesiahospital.controller.GameFlow;
import com.tlglearning.amnesiahospital.model.AudioConfig;
import com.tlglearning.amnesiahospital.model.MusicPlayer;
import java.io.IOException;
import java.net.URL;
import com.fasterxml.jackson.databind.ObjectMapper;

public class AmnesiaHospitalGame {

  public static void main(String[] args) {
    ObjectMapper objectMapper = new ObjectMapper();
    URL audioConfigURL = getResource("audio_config.json");

    try {
      AudioConfig audioConfig = objectMapper.readValue(audioConfigURL, AudioConfig.class);
      MusicPlayer musicPlayer = new MusicPlayer();
      musicPlayer.play(audioConfig.getBackgroundMusic());

      // Start the game
      GameFlow gameFlow = new GameFlow(musicPlayer);
      gameFlow.mainMenu();

      // When the game is finished or the user wants to quit, stop the music playback
      musicPlayer.stop();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  private static URL getResource(String resourcePath) {
    return AmnesiaHospitalGame.class.getClassLoader().getResource(resourcePath);
  }
}




//    JsonData jsonData = new JsonData();
//    List<Room> rooms = jsonData.getBoard();
//    GameData gameData = jsonData.getDialogue();
//    List<Item> items = jsonData.getItems();
//
//    Player mainPlayer = new Player("person", rooms.get(0));
//
//    // Print game title and description
//    System.out.println("=== " + gameData.getTitle() + " ===");
//    System.out.println(gameData.getDescription());
//    System.out.println();
//
//    // Print start message and prompt to start a new game
//    System.out.println(gameData.getStartMessage());
////    startGame(gameData.getPrompts());
//
//    while(true){
//      System.out.println("you are in " + mainPlayer.getCurrentRoom().getName());
//      String userInput = scanner.nextLine();
//      if(userInput.isEmpty()){
//        System.out.println("Not a valid input.");
//      }
//      else if(userInput.startsWith("go ")){
//        String direction = userInput.substring(3);
//        mainPlayer.move(direction, rooms);
//      }
//      else if(userInput.startsWith("use ")){
//        String item = userInput.substring(4);
//        mainPlayer.use(item);
//      }
//      else if(userInput.startsWith("get ")){
//        String item = userInput.substring(4);
//        mainPlayer.pickUpItem(item, items);
//      }
//      else if(userInput.startsWith("quit")){
//        System.out.println("Are you sure you want to quit? (y/n)");
//        userInput = scanner.nextLine();
//        if (userInput.equalsIgnoreCase("y")) {
//          System.out.println("Thanks for playing Amnesia Hospital. Goodbye!");
//          System.exit(0);
//        }
//      }
//      else{
//        System.out.println("that is not a valid input.");
//      }
//    }
//  }
//
//
//
//
//  public static String getUserInput() {
//    String input = scanner.nextLine();
//    if (input.equalsIgnoreCase("quit")) {
//      System.out.println("Are you sure you want to quit? (y/n)");
//      input = scanner.nextLine();
//      if (input.equalsIgnoreCase("y")) {
//        System.out.println("Thanks for playing Amnesia Hospital. Goodbye!");
//        System.exit(0);
//      }
//    }
//    return input;
//  }
//
//  public static void startGame(List<Prompt> prompts) {
//    System.out.println("Press Enter to continue...");
//    getUserInput();
//
//    // Clear screen
//    System.out.print("\033[H\033[2J");
//    System.out.flush();
//
//    while (true) {
//      // Prompt the player to start a new game
//      System.out.println("Do you want to start the game? y/n or quit");
//      for (Choice choice : prompts.get(0).getChoices()) {
//        System.out.println(choice.getLabel());
//      }
//      String input = getUserInput();
//      if (input.equalsIgnoreCase("start_game")) {
//        // Clear screen
//        System.out.print("\033[H\033[2J");
//        System.out.flush();
//
//        // Print game information
//
//        System.out.println(prompts.get(1).getQuestion());
//        for (Choice choice : prompts.get(1).getChoices()) {
//          System.out.println(choice.getLabel());
//        }
//
//        // Add game logic here
//
//      } else if (input.equalsIgnoreCase("quit")) {
//        System.out.println("Are you sure you want to quit? (y/n)");
//        input = getUserInput();
//        if (input.equalsIgnoreCase("y")) {
//          System.out.println("Thanks for playing Amnesia Hospital. Goodbye!");
//          break;
//        }
//      }
//    }
//  }

