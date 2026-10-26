package controller;

import utils.Utils;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Reads and validates user input from the console.
 */
public class ConsoleReader {

    /**
     * Reads the user's choice to continue or exit (1 or 2).
     *
     * @param scanner the scanner used to read input
     * @return valid user choice (1 or 2)
     */
    public static UserChoice readUserChoice(final Scanner scanner) {
        int choice = readInt(scanner);
        while (!isChoiceValid(choice)) {
            System.out.println("\nInvalid input! Please enter 1 or 2: ");
            choice = readInt(scanner);
        }
        return UserChoice.fromCode(choice);
    }

    /**
     * Reads a non-empty word from the user.
     *
     * @param scanner the scanner used to read input
     * @return the entered word
     */
    public static String readWord(final Scanner scanner) {
        String word = scanner.nextLine();
        while (word.isBlank() && scanner.hasNextLine()) {
            System.out.println("String cannot be blank, please enter a word");
            word = scanner.nextLine();
        }
        return word;
    }

    /**
     * Safely reads an integer from the scanner.
     *
     * @param scanner the scanner used to read input
     * @return the entered integer
     */
    private static int readInt(final Scanner scanner) {
        String input = scanner.nextLine();
        while (!Utils.isInteger(input) || Integer.parseInt(input) <= 0) {
            System.out.println("\nInvalid input! Please enter valid positive int number: ");
            input = scanner.nextLine();
        }
        return Integer.parseInt(input);
    }

    /**
     * Reads a specified number of words entered by the user from the console.
     *
     * @param scanner the scanner used to read user input
     * @return a list containing the entered words
     */
    public static List<String> readAlistOfWords(final Scanner scanner) {
        int amount = readInt(scanner);
        System.out.println("\nWrite the words using enter: ");
        final List<String> listOfWordsToDelete = new ArrayList<>(amount);
        for (int i = 0; i < amount; i++) {
            listOfWordsToDelete.add(readWord(scanner));
        }
        return listOfWordsToDelete;
    }

    /**
     * Checks if the choice is valid (1 or 2).
     *
     * @param choice the entered choice
     * @return true if choice is 1 or 2, false otherwise
     */
    public static boolean isChoiceValid(final int choice) {
        return UserChoice.fromCode(choice) != UserChoice.UNKNOWN;
    }
}
