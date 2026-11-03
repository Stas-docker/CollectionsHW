package reader;

import java.util.Scanner;

public interface ConsoleReader {
    default String readLine(final Scanner scanner) {
        return scanner.nextLine();
    }
}
