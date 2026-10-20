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
    public static void startSongAnalyzing() {
        try (final Scanner scanner = new Scanner(System.in)) {
            Menu.startMenu();
            runAnalysis(scanner, new Song());
        }
    }

    /**
     * Runs the analysis loop until the user exits.
     *
     * @param scanner the scanner used to read input
     * @param song    the song to analyze
     */
    private static void runAnalysis(final Scanner scanner, final Song song) {
        UserChoice choice = UserChoice.UNKNOWN;
        while (choice != UserChoice.EXIT)
            choice = processWord(scanner, song);
    }

    /**
     * Reads a word, displays its frequency, and processes the user's choice.
     *
     * @param scanner the scanner used to read input
     * @param song    the song to analyze
     * @return the user's choice
     */
    private static UserChoice processWord(final Scanner scanner, final Song song) {
        String word = ConsoleReader.readWord(scanner);
        showWordAppearances(song, word);
        Menu.endMenu();
        UserChoice choice = ConsoleReader.getContinueOption(ConsoleReader.readContinueOption(scanner));
        selectContinueOption(choice);
        return choice;
    }

    /**
     * Counts and displays the occurrences of a word in the song.
     *
     * @param song the song to analyze
     * @param word the word to search for
     */
    public static void showWordAppearances(final Song song, final String word) {
        String cleanedLyrics = StringUtils.cleanString(song.getLyrics());
        String[] wordsArray = StringUtils.stringToWordsArray(cleanedLyrics);
        int wordAppearances = StringUtils.countWord(wordsArray, word);
        System.out.println("The word was repeated in the song " + wordAppearances + " times;\n");
    }

    /**
     * Processes the user's choice.
     *
     * @param userChoice the selected option
     */
    public static void selectContinueOption(final UserChoice userChoice) {
        switch (userChoice) {
            case CONTINUE -> startSongAnalyzing();
            case EXIT -> System.out.println("\nGood Bye!");
            default -> System.out.println("\nInvalid option! Please try again.\n");
        }
    }

}
