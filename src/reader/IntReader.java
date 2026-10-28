package reader;

import java.util.Scanner;

public interface IntReader extends ConsoleReader {
    int readInt(final Scanner scanner);
    int readPositiveNotZeroInt(final Scanner scanner);
    boolean isInteger(String value);
}
