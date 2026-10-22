package controller;

import model.Lyrics;
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
    public static void startSongAnalyzing(final Scanner scanner) {
        runAnalysis(scanner, new Lyrics());
    }

    /**
     * Runs the analysis loop until the user exits.
     *
     * @param scanner the scanner used to read input
     * @param lyrics    the song to analyze
     */
    private static void runAnalysis(final Scanner scanner, final Lyrics lyrics) {
        UserChoice choice = UserChoice.UNKNOWN;
        while (choice != UserChoice.EXIT) {
            Menu.startMenu();
            choice = processWord(scanner, lyrics);
        }
        System.out.println("\nGood Bye!");
    }

    /**
     * Reads a word, displays its frequency, and processes the user's choice.
     *
     * @param scanner the scanner used to read input
     * @param lyrics    the song to analyze
     * @return the user's choice
     */
    private static UserChoice processWord(final Scanner scanner, final Lyrics lyrics) {
        final String word = ConsoleReader.readWord(scanner);
        showWordAppearances(lyrics, word);
        Menu.endMenu();
        final UserChoice choice = ConsoleReader.getContinueOption(ConsoleReader.readContinueOption(scanner));
        return choice;
    }

    /**
     * Counts and displays the occurrences of a word in the song.
     *
     * @param lyrics the song to analyze
     * @param word the word to search for
     */
    public static void showWordAppearances(final Lyrics lyrics, final String word) {
        final String cleanedLyrics = StringUtils.stripPunctuationAndToLowerCase(lyrics.getLyrics());
        final String[] wordsArray = StringUtils.stringToWordsArray(cleanedLyrics);
        final int wordAppearances = StringUtils.countWord(wordsArray, word);
        System.out.println("The word was repeated in the song " + wordAppearances + " times;\n");
    }
}
