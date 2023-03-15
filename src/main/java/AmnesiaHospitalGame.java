import java.util.Scanner;

public class AmnesiaHospitalGame {

  private static Scanner scanner = new Scanner(System.in);

  public static void main(String[] args) {
    // Print game title
    System.out.println("=== Amnesia Hospital ===");
    System.out.println();
    System.out.println(
        "Welcome to \"Amnesia Hospital,\" a horror text adventure game where you wake up in a hospital bed with no memory of who you are or how you got there.");
    System.out.println("You soon realize that the hospital is infested with zombies, and you must navigate the hallways and rooms to survive and escape.");
    System.out.println("As you explore the hospital, you will come across other survivors, some of whom may be helpful, while others may be hostile.");
    System.out.println("You will need to make choices that will determine your fate and the outcome of the game.");
    System.out.println();

    // Start the game
    startGame();
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

  public static void startGame() {
    System.out.println("Press Enter to continue...");
    getUserInput();

    // Clear screen
    System.out.print("\033[H\033[2J");
    System.out.flush();

    while (true) {
      // Prompt the player to start a new game
      System.out.println("Do you want to start a new game? (y/n)");
      String input = getUserInput();
      if (input.equalsIgnoreCase("y")) {
        // Clear screen
        System.out.print("\033[H\033[2J");
        System.out.flush();

        // Print game information
        System.out.println(
            "You find yourself in a dark and abandoned hospital, with broken glass, overturned furniture, and bloodstains everywhere."
                + " As you try to piece together what happened, you realize that you have amnesia and cannot remember anything about yourself or why you are here.");
        System.out.println(
            "To make matters worse, you hear the sound of shuffling feet and low growls coming from down the hall."
                + " You realize that the hospital is infested with zombies, and you must navigate the hallways and rooms to survive and escape to the roof."
                + " Your actions will determine the outcome of the game, so choose wisely.");

        // Add game logic here

      } else {
        System.out.println("Thanks for playing Amnesia Hospital. Goodbye!");
        break;
      }
    }
  }
}
