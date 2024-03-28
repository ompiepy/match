import java.util.Scanner;
import java.util.Random;

public class MatchingQuestionGame {
    public static void main(String[] args) {
        int currentStreak = 0;  // Initialize the streak counter
        int stars = 0;           // Initialize the stars counter
        int level = 1;           // Initialize the level counter
        int wrong = 0;           // Initialize the counter for consecutive wrong answers
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        
        while (level <= 3) {  // Continue playing until reaching 3 levels
            // Get a random question based on the current level
            String question = getRandomQuestion(level, random);
            System.out.println("Question: " + question);
            
            boolean answerCorrect = askQuestion(scanner, level);  // Function to ask a question and check if the answer is correct

            if (answerCorrect) {
                currentStreak++;
                System.out.println("Correct!");

                if (currentStreak == 3) {
                    stars++;
                    currentStreak = 0;  // Reset streak when reaching 3 correct answers
                    System.out.println("Congratulations! You earned a star. Total stars: " + stars);

                    if (stars == 3) {
                        level++;  // Move to the next level when reaching 3 stars
                        System.out.println("Congratulations! You reached 3 stars and moved on to the next level.");
                    }
                }
                wrong = 0; // Reset wrong counter if the answer is correct
            } else {
                System.out.println("Incorrect answer. Your streak ends.");

                currentStreak = 0;  // Reset streak on a wrong answer
                wrong++; // Increment wrong answer counter

                if (wrong == 3) {
                    if (stars > 0) {
                        stars--;
                        System.out.println("You lost a star. Total stars: " + stars);
                    } else {
                        System.out.println("You have 0 stars. Keep going, you got this!");
                        wrong = 0; // Reset wrong counter if the player has 0 stars
                    }
                }
            }
        }
        
        // Congratulations message upon completing all levels
        System.out.println("Congratulations, you have completed all levels. OOP prodigy!");
    }

    // Function to get a random question based on the current level
    public static String getRandomQuestion(int level, Random random) {
        String[] easyQuestions = {"Easy question 1?", "Easy question 2?", "Easy question 3?"};
        String[] mediumQuestions = {"Medium question 1?", "Medium question 2?", "Medium question 3?"};
        String[] hardQuestions = {"Hard question 1?", "Hard question 2?", "Hard question 3?"};

        switch (level) {
            case 1:
                return easyQuestions[random.nextInt(easyQuestions.length)];
            case 2:
                return mediumQuestions[random.nextInt(mediumQuestions.length)];
            case 3:
                return hardQuestions[random.nextInt(hardQuestions.length)];
            default:
                return ""; // Handle invalid level gracefully
        }
    }

    // Function to ask a question and check if the answer is correct
    public static boolean askQuestion(Scanner scanner, int level) {
        // Get the questions array based on the current level
        String[] questions;
        switch (level) {
            case 1:
                questions = easyQuestions;
                break;
            case 2:
                questions = mediumQuestions;
                break;
            case 3:
                questions = hardQuestions;
                break;
            default:
                return false; // Invalid level
        }
        
        // Get a random question from the questions array
        String question = questions[new Random().nextInt(questions.length)];
        
        // Display the question to the user
        System.out.println("Question: " + question);
        
        // For now, let's assume the answer is always correct for demonstration purposes
        // You'll need to implement the actual logic to check the user's answer
        return true;
    }
}
