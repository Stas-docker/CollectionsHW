package controller;

import model.Song;
import utils.StringUtils;
import view.Menu;

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
                choice = processWord(scanner, song);
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
    private static UserChoice processWord(final Scanner scanner, final Song song) {
        final String word = ConsoleReader.readWord(scanner);
        showWordAppearances(song, word);
        Menu.endMenu();
        return ConsoleReader.readUserChoice(scanner);
    }

    /**
     * Counts and displays the occurrences of a word in the song.
     *
     * @param song the song to analyze
     * @param word the word to search for
     */
    public static void showWordAppearances(final Song song, final String word) {
        final String cleanedLyrics = StringUtils.toLowerCaseAndStripPunctuation(song.lyrics);
        final String[] wordsArray = StringUtils.stringToWordsArray(cleanedLyrics);
        final int wordAppearances = StringUtils.countWord(wordsArray, word);
        System.out.println("The word was repeated in the song " + wordAppearances + " times;\n");
    }
}
