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
  }
}
