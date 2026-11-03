package reader;

import controller.UserChoice;

import java.util.Scanner;

public class UserChoiceReader {

    private final IntReader intReader;

    public UserChoiceReader(final IntReader intReader) {
        this.intReader = intReader;
    }

    public static boolean isChoiceValid(final int choice) {
        return UserChoice.fromCode(choice) != UserChoice.UNKNOWN;
    }

    public UserChoice readUserChoice(final Scanner scanner) {
        int choice = intReader.readInt(scanner);
        while (!isChoiceValid(choice)) {
            System.out.println("\nPlease enter 1 or 2: ");
            choice = intReader.readInt(scanner);
        }
        return UserChoice.fromCode(choice);
    }
}
