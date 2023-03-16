import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.core.JsonParseException;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class AmnesiaHospitalGame {

  private static Scanner scanner = new Scanner(System.in);

  public static void main(String[] args) {

    // Read the JSON data from the file and map it to the GameData class
    ObjectMapper objectMapper = new ObjectMapper();
    try {
      GameData gameData = objectMapper.readValue(new File("game_data.json"), GameData.class);

      // Print game title and description
      System.out.println("=== " + gameData.getTitle() + " ===");
      System.out.println(gameData.getDescription());
      System.out.println();

      // Print start message and prompt to start a new game
      System.out.println(gameData.getStartMessage());
      startGame(gameData.getPrompts());

    } catch (JsonParseException e) {
      System.out.println("Error parsing JSON: " + e.getMessage());
    } catch (JsonMappingException e) {
      System.out.println("Error mapping JSON to object: " + e.getMessage());
    } catch (IOException e) {
      System.out.println("Error reading file: " + e.getMessage());
    }
  }

  public static String getUserInput() {
    String input = scanner.nextLine();
    if (input.equalsIgnoreCase("quit")) {
      System.out.println("Are you sure you want to quit? (y/n)");
      input = scanner.nextLine();
      if (input.equalsIgnoreCase("y")) {
        System.out.println("Thanks for playing Amnesia Hospital. Goodbye!");
        System.exit(0);
      }
    }
    return input;
  }

  public static void startGame(List<Prompt> prompts) {
    System.out.println("Press Enter to continue...");
    getUserInput();

    // Clear screen
    System.out.print("\033[H\033[2J");
    System.out.flush();

    while (true) {
      // Prompt the player to start a new game
      System.out.println(prompts.get(0).getQuestion());
      for (Choice choice : prompts.get(0).getChoices()) {
        System.out.println(choice.getLabel());
      }
      String input = getUserInput();
      if (input.equalsIgnoreCase("start_game")) {
        // Clear screen
        System.out.print("\033[H\033[2J");
        System.out.flush();

        // Print game information
        System.out.println(prompts.get(1).getQuestion());
        for (Choice choice : prompts.get(1).getChoices()) {
          System.out.println(choice.getLabel());
        }

        // Add game logic here

      } else if (input.equalsIgnoreCase("quit")) {
        System.out.println("Are you sure you want to quit? (y/n)");
        input = getUserInput();
        if (input.equalsIgnoreCase("y")) {
          System.out.println("Thanks for playing Amnesia Hospital. Goodbye!");
          break;
        }
      }
    }
  }
}
