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
        while (StringUtils.isStringBlank(word) && scanner.hasNextLine()) {
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
        validateIntInput(scanner);
        final int value = scanner.nextInt();
        scanner.nextLine();
        return value;
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
     * Checks if the choice is valid (1 or 2).
     *
     * @param choice the entered choice
     * @return true if choice is 1 or 2, false otherwise
     */
    public static boolean isChoiceValid(final int choice) {
        return choice == 1 || choice == 2;
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
