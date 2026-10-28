package controller;

import model.Song;
import reader.*;
import utils.BeatlesException;
import utils.Utils;
import view.Menu;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Controls the song analysis process.
 */
public class SongAnalyzer {
    private final IntReader intReader = new ConsoleIntReader();
    private final StringReader stringReader = new ConsoleWordReader();
    private final ListReader listReader = new ListReader(intReader, stringReader);
    private final UserChoiceReader userChoiceReader = new UserChoiceReader(intReader);
    private List<String> wordsList;

    /**
     * Runs the analysis loop until the user exits.
     *
     * @param song the song to analyze
     */
    public void runSongAnalysis(final Song song) {
        initializeLyrics(song);
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
     * Prepares the song's lyrics for analysis by normalizing text
     * and populating the word list.
     *
     * @param song the song containing lyrics to process
     */
    private void initializeLyrics(final Song song) {
        final String cleanedLyrics = Utils.toLowerCaseAndStripPunctuation(song.getLyrics());
        wordsList = new ArrayList<>(Utils.stringToWordsList(cleanedLyrics));
    }

    /**
     * Reads a word, displays its frequency, shows lyrics without words that we entered
     * and processes the user's choice.
     *
     * @param scanner the scanner used to read input
     * @return the user's choice
     */
    private UserChoice processSong(final Scanner scanner) {
        showAWordFrequency(scanner);
        Menu.deleteMenu();
        showASongWordsWithoutDeletedWords(scanner);
        Menu.findAStringMenu();
        confirmStringIsInSong(scanner);
        Menu.endMenu();
        return userChoiceReader.readUserChoice(scanner);
    }

    /**
     * Prompts for a word and prints how many times it appears in the song.
     *
     * @param scanner the scanner used to read the word
     */
    private void showAWordFrequency(final Scanner scanner) {
        final String word = stringReader.readString(scanner);
        final int wordNumber = Utils.countWord(wordsList, word);
        System.out.println("The word you've just entered was repeated in the song " + wordNumber + " times.\n");
    }

    /**
     * Reads a list of words from input, removes them from the song, and displays the remaining words.
     *
     * @param scanner the scanner used to read input
     */
    private void showASongWordsWithoutDeletedWords(final Scanner scanner) {
        System.out.println("Write the amount of words you want to delete: ");
        deleteWordsFromSong(listReader.readWordList(scanner));
        System.out.println("\nThe words of the song without deleted: "
                + wordsList + "\n");
    }

    /**
     * Removes specified words from the main song words list.
     *
     * @param listOfWordsToDelete list of words to be deleted
     */
    private void deleteWordsFromSong(List<String> listOfWordsToDelete) {
        Utils.removeWords(wordsList, listOfWordsToDelete);
    }

    /**
     * Reads a target string from input and checks if it exists within the song text.
     *
     * @param scanner the scanner used to read user input
     * @return {@code true} if the target string is present in the song text, {@code false} otherwise
     * @throws RuntimeException if an underlying {@link BeatlesException} occurs during search
     */
    private boolean foundAString(final Scanner scanner) {
        String stringToFind = stringReader.readString(scanner);
        String songText = String.join(" ", wordsList);
        try {
            return Utils.stringCanBeFound(stringToFind, songText);
        } catch (BeatlesException stringInBeatlesException) {
            throw new RuntimeException(stringInBeatlesException);
        }
    }

    /**
     * Prompts the user to search for a string and prints whether it was found in the song.
     *
     * @param scanner the scanner used to read user input
     */
    private void confirmStringIsInSong(final Scanner scanner) {
        if (foundAString(scanner)) {
            System.out.println("\nYes, it is in the song\n");
        } else {
            System.out.println("\nNo, it is not in the song\n");
        }
    }
}
