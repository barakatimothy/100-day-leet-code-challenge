import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class AwesomeGame {

    public static void main(String[] args) {
        // List of apostles' names
        ArrayList<String> apostles = new ArrayList<>(Arrays.asList(
            "Peter", "Andrew", "James", "John", "Philip", 
            "Bartholomew", "Thomas", "Matthew", 
            "James (son of Alphaeus)", "Thaddaeus", 
            "Simon (the Zealot)", "Judas Iscariot"
        ));

        Scanner scanner = new Scanner(System.in);
        ArrayList<String> guessedCorrectly = new ArrayList<>();
        int score = 0;

        System.out.println("Welcome to the Apostles Game!");
        System.out.println("Try to name the 12 apostles. Type 'quit' to exit.");
        System.out.println();

        while (true) {
            System.out.print("Enter a name: ");
            String input = scanner.nextLine().trim();

            if (input.equalsIgnoreCase("quit")) {
                System.out.println("Exiting the game...");
                break;
            }

            if (apostles.contains(input)) {
                if (guessedCorrectly.contains(input)) {
                    System.out.println("You've already guessed that name. Try another!");
                } else {
                    guessedCorrectly.add(input);
                    score++;
                    System.out.println("Correct! You've guessed " + score + " out of 12.");
                }
            } else {
                System.out.println("Incorrect. Try again!");
            }

            if (score == 12) {
                System.out.println("Congratulations! You've guessed all the apostles correctly!");
                break;
            }
        }

        System.out.println("\nGame Over!");
        System.out.println("You guessed " + score + " apostles correctly.");
        System.out.println("Names you guessed: " + guessedCorrectly);
        System.out.println("Remaining apostles: ");
        apostles.removeAll(guessedCorrectly);
        System.out.println(apostles);

        scanner.close();
    }
}
