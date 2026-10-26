package controller;

import model.Song;
import utils.Utils;
import view.Menu;

import java.util.List;
import java.util.Scanner;

/**
 * Controls the song analysis process.
 */
public class WordFrequencyHandler {

    final private static String cleanedLyrics = Utils.toLowerCaseAndStripPunctuation(Song.lyrics);
    final private static List<String> wordsList = Utils.stringToWordsList(cleanedLyrics);

    /**
     * Runs the analysis loop until the user exits.
     *
     * @param song the song to analyze
     */
    public static void runSongAnalysis(final Song song) {
        try (final Scanner scanner = new Scanner(System.in)) {
            UserChoice choice = UserChoice.UNKNOWN;
            while (choice != UserChoice.EXIT) {
                Menu.startMenu();
                choice = processSong(scanner);
            }
            System.out.println("\nGood Bye!");
        }
    }

    /**
     * Reads a word, displays its frequency, and processes the user's choice.
     *
     * @param scanner the scanner used to read input
     * @return the user's choice
     */
    private static UserChoice processSong(final Scanner scanner) {
        showAWordFrequency(scanner);
        Menu.middleMenu();
        showSongWithoutDuplicates();
        Menu.endMenu();
        return ConsoleReader.readUserChoice(scanner);
    }

    private static void showAWordFrequency(final Scanner scanner) {
        final String word = ConsoleReader.readWord(scanner);
        final int wordNumber = Utils.countWord(wordsList, word);
        System.out.println("The word you've just entered was repeated in the song " + wordNumber + " times.\n");
    }

    /**
     * Displays unique words from the song lyrics, sorted by their length.
     */
    private static void showSongWithoutDuplicates() {
        final List<String> listWithoutDuplicates = Utils.removeDuplicates(wordsList);
        Utils.sortStringsByLength(listWithoutDuplicates);
        System.out.println("The words of the song without duplicates and sorted by length: "
                + listWithoutDuplicates + "\n");
    }
}
