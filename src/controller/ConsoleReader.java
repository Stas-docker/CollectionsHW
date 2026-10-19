package controller;

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
        while (isStringBlank(word) && scanner.hasNextLine()) {
            word = scanner.nextLine();
        }
        return word;
    }

    /**
     * Checks whether a string is not blank.
     *
     * @param string the string to validate
     * @return boolean isBlank
     */
    public static boolean isStringBlank(final String string) {
        boolean isBlank = string.isBlank();
        if (isBlank) {
            System.out.println("String cannot be blank, please enter a word");
        }
        return isBlank;
    }

    /**
     * Reads the user's choice to continue or exit.
     *
     * @param scanner the scanner used to read input
     * @return the user's choice
     */
    public static int readContinueOption(final Scanner scanner) {
        validateIntInput(scanner);
        final int choice = scanner.nextInt();
        scanner.nextLine();
        return choice;
    }

    /**
     * Validates the user's numeric input.
     *
     * @param scanner the scanner used to read input
     */
    public static void validateIntInput(final Scanner scanner) {
        while (!scanner.hasNextInt()) {
            System.out.println("\nInvalid input! Please enter 1 or 2: ");
            scanner.next();
        }
    }

    /**
     * Converts a number into a user choice.
     *
     * @param choice the number entered by the user
     * @return the corresponding user choice
     */
    public static UserChoice getContinueOption(final int choice) {
        return switch (choice) {
            case 1 -> UserChoice.CONTINUE;
            case 2 -> UserChoice.EXIT;
            default -> UserChoice.UNKNOWN;
        };
    }
}
