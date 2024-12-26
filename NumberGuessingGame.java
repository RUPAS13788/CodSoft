import java.util.Random;
import java.util.Scanner;

public class NumberGuessingGame {
    public static int playGame() {
        Random random = new Random();
        int numberToGuess = random.nextInt(100) + 1;
        int attemptsLeft = 10;
        Scanner scanner = new Scanner(System.in);
        int score = 0;
        System.out.println("Welcome to the Number Guessing Game!");
        System.out.println("Try to guess the number between 1 and 100.");
        System.out.println("You have " + attemptsLeft + " attempts.");
        while (attemptsLeft > 0) {
            System.out.print("Enter your guess (You have " + attemptsLeft + " attempts left): ");
            int guess = scanner.nextInt();

            if (guess < numberToGuess) {
                System.out.println("Your guess is too low!");
            } else if (guess > numberToGuess) {
                System.out.println("Your guess is too high!");
            } else {
                System.out.println("Congratulations! You guessed the number " + numberToGuess + " correctly.");
                score += (11 - attemptsLeft);
                break;
            }
            attemptsLeft--;
        }

        if (attemptsLeft == 0) {
            System.out.println("Sorry, you've run out of attempts. The correct number was " + numberToGuess + ".");
        }
        return score;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int totalScore = 0;
        int rounds = 3;
        for (int roundNumber = 1; roundNumber <= rounds; roundNumber++) {
            System.out.println("\nRound " + roundNumber);
            totalScore += playGame();
            System.out.print("Do you want to play again? (yes/no): ");
            String playAgain = scanner.next().trim().toLowerCase();
            if (!playAgain.equals("yes")) {
                break;
            }
        }
        System.out.println("\nYour total score is: " + totalScore);
        scanner.close();
    }
}
