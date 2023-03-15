import java.util.Scanner;

public class AmnesiaHospitalGame {

  public static void main(String[] args) {
    // Create scanner object for user input
    Scanner scanner = new Scanner(System.in);

    // Print game title
    System.out.println("=== Amnesia Hospital ===");
    System.out.println();
    System.out.println(
        "Welcome to \"Amnesia Hospital,\" a horror text adventure game where you wake up in a hospital bed with no memory of who you are or how you got there."
            + " You soon realize that the hospital is infested with zombies, and you must navigate the hallways and rooms to survive and escape."
            + " As you explore the hospital, you will come across other survivors, some of whom may be helpful, while others may be hostile."
            + " You will need to make choices that will determine your fate and the outcome of the game.");
    System.out.println();
    // Wait for a key to be pressed
    System.out.println("Press any key to continue...");
    scanner.nextLine();

    // Clear screen
    System.out.print("\033[H\033[2J");
    System.out.flush();


    while (true) {
      // Prompt the player to start a new game
      System.out.println("Do you want to start a new game? (y/n)");
      String input = scanner.nextLine();
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
      } else {
        // Exit the game
        System.out.println("Thanks for playing Amnesia Hospital. Goodbye!");
        break;
      }
    }

  }
}
