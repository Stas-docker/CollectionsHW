package reader;

import java.util.Scanner;

public class ConsoleWordReader implements StringReader {
    @Override
    public String readString(final Scanner scanner) {
        String word = readLine(scanner);
        while (word.isBlank()) {
            System.out.println("String cannot be blank, please enter something");
            word = readLine(scanner);
        }
        return word;
    }
}
