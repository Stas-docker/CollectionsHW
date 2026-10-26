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
        showASongWordsWithoutDeletedWords(scanner);
        Menu.endMenu();
        return ConsoleReader.readUserChoice(scanner);
    }

    /**
     * Prompts for a word and prints how many times it appears in the song.
     *
     * @param scanner the scanner used to read the word
     */
    private static void showAWordFrequency(final Scanner scanner) {
        final String word = ConsoleReader.readWord(scanner);
        final int wordNumber = Utils.countWord(wordsList, word);
        System.out.println("The word you've just entered was repeated in the song " + wordNumber + " times.\n");
    }

    /**
     * Reads a list of words from input, removes them from the song, and displays the remaining words.
     *
     * @param scanner the scanner used to read input
     */
    private static void showASongWordsWithoutDeletedWords(final Scanner scanner) {
        System.out.println("Write the amount of words you want to delete: ");
        deleteWordsFromSong(ConsoleReader.readAlistOfWords(scanner));
        System.out.println("\nThe words of the song without deleted: "
                + wordsList + "\n");
    }

    /**
     * Removes specified words from the main song words list.
     *
     * @param listOfWordsToDelete list of words to be deleted
     */
    private static void deleteWordsFromSong(List<String> listOfWordsToDelete) {
        Utils.removeWords(wordsList, listOfWordsToDelete);
    }
}
