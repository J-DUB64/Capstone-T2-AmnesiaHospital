import java.util.Scanner;

public class AmnesiaHospitalGame {

  public static void main(String[] args) {
    // Clear screen
    System.out.print("\033[H\033[2J");
    System.out.flush();

    // Print game title
    System.out.println("=== Amnesia Hospital ===");

    // Create scanner object for user input
    Scanner scanner = new Scanner(System.in);

    // Print game information
    System.out.println(
        "You find yourself in a dark and abandoned hospital, with broken glass, overturned furniture, and bloodstains everywhere."
            + " As you try to piece together what happened, you realize that you have amnesia and cannot remember anything about yourself or why you are here.");
    System.out.println("To make matters worse, you hear the sound of shuffling feet and low growls coming from down the hall."
        + " You realize that the hospital is infested with zombies, and you must navigate the hallways and rooms to survive and escape to the roof."
        + " Your actions will determine the outcome of the game, so choose wisely.");
  }
}
