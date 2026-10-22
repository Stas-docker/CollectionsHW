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
     * Starts the song analysis application.
     */
    public static void startSongAnalyzing(final Scanner scanner, final Song song) {
        runAnalysis(scanner, song);
    }

    /**
     * Runs the analysis loop until the user exits.
     *
     * @param scanner the scanner used to read input
     * @param song    the song to analyze
     */
    private static void runAnalysis(final Scanner scanner, final Song song) {
        UserChoice choice = UserChoice.UNKNOWN;
        while (choice != UserChoice.EXIT) {
            Menu.startMenu();
            choice = processWord(scanner, song);
        }
        System.out.println("\nGood Bye!");
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
        final UserChoice choice = UserChoice.fromCode(ConsoleReader.readContinueOption(scanner));
        return choice;
    }

    /**
     * Counts and displays the occurrences of a word in the song.
     *
     * @param song the song to analyze
     * @param word the word to search for
     */
    public static void showWordAppearances(final Song song, final String word) {
        final String cleanedLyrics = StringUtils.toLowerCaseAndstripPunctuation(song.lyrics);
        final String[] wordsArray = StringUtils.stringToWordsArray(cleanedLyrics);
        final int wordAppearances = StringUtils.countWord(wordsArray, word);
        System.out.println("The word was repeated in the song " + wordAppearances + " times;\n");
    }
}
