package reader;

import utils.Utils;

import java.util.Scanner;

public class ConsoleIntReader implements IntReader {

    @Override
    public boolean isInteger(final String value) {
        boolean isValid;
        try {
            Integer.parseInt(value);
            isValid = true;
        } catch (NumberFormatException e) {
            isValid = false;
        }
        return isValid;
    }

    @Override
    public int readInt(final Scanner scanner) {
        String input = readLine(scanner);
        while (!isInteger(input)) {
            System.out.println("\nInvalid input! Please enter a valid integer: ");
            input = readLine(scanner);
        }
        return Integer.parseInt(input);
    }

    @Override
    public int readPositiveNotZeroInt(final Scanner scanner) {
        int input = readInt(scanner);
        while (input < 1) {
            System.out.println("\nInvalid input! Please enter valid positive not zero int number: ");
            input = readInt(scanner);
        }
        return input;
    }
}
