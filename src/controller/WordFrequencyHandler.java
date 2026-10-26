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
                choice = processSong(scanner, song);
            }
            System.out.println("\nGood Bye!");
        }
    }

    /**
     * Reads a word, displays its frequency, and processes the user's choice.
     *
     * @param scanner the scanner used to read input
     * @param song    the song to analyze
     * @return the user's choice
     */
    private static UserChoice processSong(final Scanner scanner, final Song song) {
        showSongWithoutDuplicates(song);
        Menu.endMenu();
        return ConsoleReader.readUserChoice(scanner);
    }

    /**
     * Counts and displays the occurrences of a word in the song.
     *
     * @param song the song to analyze
     */
    public static void showSongWithoutDuplicates(final Song song) {
        final String cleanedLyrics = Utils.toLowerCaseAndStripPunctuation(song.lyrics);
        final List<String> wordsList = Utils.stringToWordsList(cleanedLyrics);
        final List<String> listWithoutDuplicates = Utils.removeDuplicates(wordsList);
        Utils.sortStringsByLength(listWithoutDuplicates);
        System.out.println("The words of the song without duplicates and sorted by length: "
                + listWithoutDuplicates);
    }
}
