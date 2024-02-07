package codSoft;

import java.util.Random;
import java.util.Scanner;

public class NUMBER_GAME {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        int score = 0;
        boolean playAgain = true;

        while (playAgain) {
            int attempts = 0;
            int maxAttempts = 5; // You can adjust the maximum number of attempts as needed

            // Generate a random number between 1 and 100 (inclusive)
            int randomNumber = random.nextInt(100) + 1;

            System.out.println("Welcome to the Guessing Game!");
            System.out.println("Try to guess the number between 1 and 100.");

            while (attempts < maxAttempts) {
                // Prompt the user to enter their guess
                System.out.print("Enter your guess: ");
                int userGuess = scanner.nextInt();

                // Compare the user's guess with the generated number
                if (userGuess == randomNumber) {
                    System.out.println("Congratulations! Your guess is correct.");
                    score += 10; // Increase the score for a correct guess
                    break;
                } else if (userGuess < randomNumber) {
                    System.out.println("Sorry, your guess is too low. Try again.");
                } else {
                    System.out.println("Sorry, your guess is too high. Try again.");
                }

                attempts++;
            }

            if (attempts == maxAttempts) {
                System.out.println("Sorry, you've reached the maximum number of attempts. The correct number was: " + randomNumber);
            }

            // Ask if the user wants to play again
            System.out.print("Do you want to play again? (yes/no): ");
            String playAgainResponse = scanner.next().toLowerCase();
            playAgain = playAgainResponse.equals("yes");

            // Increment the score for each round played
            score += 5;

            if (playAgain) {
                System.out.println("New round started!");
            } else {
                System.out.println("Thanks for playing! Your final score is: " + score);
            }
        }

        // Close the scanner
        scanner.close();
    }
}

