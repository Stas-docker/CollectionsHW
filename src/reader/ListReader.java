package reader;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ListReader {
    private final IntReader intReader;
    private final StringReader stringReader;

    public ListReader(IntReader intReader, StringReader stringReader) {
        this.intReader = intReader;
        this.stringReader = stringReader;
    }

    public List<String> readWordList(final Scanner scanner) {
        final int amount = intReader.readPositiveNotZeroInt(scanner);
        System.out.println("\nWrite the words using enter: ");
        final List<String> listOfWordsToDelete = new ArrayList<>(amount);
        for (int i = 0; i < amount; i++) {
            listOfWordsToDelete.add(stringReader.readString(scanner));
        }
        return listOfWordsToDelete;
    }
}
