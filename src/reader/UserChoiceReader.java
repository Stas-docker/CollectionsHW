package reader;

import controller.UserChoice;

import java.util.Scanner;

public class UserChoiceReader {

    private final IntReader intReader;

    public UserChoiceReader(final IntReader intReader) {
        this.intReader = intReader;
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

    /**
     * Reads the user's choice to continue or exit (1 or 2).
     *
     * @param scanner the scanner used to read input
     * @return valid user choice (1 or 2)
     */
    public UserChoice readUserChoice(final Scanner scanner) {
        int choice = intReader.readInt(scanner);
        while (!isChoiceValid(choice)) {
            System.out.println("\nPlease enter 1 or 2: ");
            choice = intReader.readInt(scanner);
        }
        return UserChoice.fromCode(choice);
    }
}
