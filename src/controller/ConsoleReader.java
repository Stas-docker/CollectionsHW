package controller;

import utils.StringUtils;

import java.util.Scanner;

/**
 * Reads and validates user input from the console.
 */
public class ConsoleReader {

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
     * Reads the user's choice to continue or exit (1 or 2).
     *
     * @param scanner the scanner used to read input
     * @return valid user choice (1 or 2)
     */
    public static int readContinueOption(final Scanner scanner) {
        int choice = readInt(scanner);
        while (!isChoiceValid(choice)) {
            System.out.println("\nInvalid input! Please enter 1 or 2: ");
            choice = readInt(scanner);
        }
        return choice;
    }

    /**
     * Safely reads an integer from the scanner.
     *
     * @param scanner the scanner used to read input
     * @return the entered integer
     */
    private static int readInt(final Scanner scanner) {
        String input = scanner.nextLine();
        while (!StringUtils.isInteger(input)) {
            System.out.println("\nInvalid input! Please enter 1 or 2: ");
            input = scanner.nextLine();
        }
        return Integer.parseInt(input);
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
