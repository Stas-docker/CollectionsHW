package controller;

import model.Song;
import reader.*;
import utils.Utils;
import view.Menu;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Controls the song analysis process.
 */
public class WordFrequencyHandler {
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
        this.wordsList = new ArrayList<>(Utils.stringToWordsList(cleanedLyrics));
    }

    /**
     * Reads a word, displays its frequency, shows lyrics without words that we entered
     * and processes the user's choice.
     *
     * @param scanner the scanner used to read input
     * @return the user's choice
     */
    private UserChoice processSong(final Scanner scanner) {
        IntReader intReader = new ConsoleIntReader();
        UserChoiceReader userChoiceReader = new UserChoiceReader(intReader);
        showAWordFrequency(scanner);
        Menu.middleMenu();
        showASongWordsWithoutDeletedWords(scanner);
        Menu.endMenu();
        return userChoiceReader.readUserChoice(scanner);
    }

    /**
     * Prompts for a word and prints how many times it appears in the song.
     *
     * @param scanner the scanner used to read the word
     */
    private void showAWordFrequency(final Scanner scanner) {
        StringReader stringReader = new ConsoleWordReader();
        final String word = stringReader.readString(scanner);
        final int wordNumber = Utils.countWord(this.wordsList, word);
        System.out.println("The word you've just entered was repeated in the song " + wordNumber + " times.\n");
    }

    /**
     * Reads a list of words from input, removes them from the song, and displays the remaining words.
     *
     * @param scanner the scanner used to read input
     */
    private void showASongWordsWithoutDeletedWords(final Scanner scanner) {
        IntReader intReader = new ConsoleIntReader();
        StringReader stringReader = new ConsoleWordReader();
        ListReader listReader = new ListReader(intReader, stringReader);
        System.out.println("Write the amount of words you want to delete: ");
        deleteWordsFromSong(listReader.readWordList(scanner));
        System.out.println("\nThe words of the song without deleted: "
                + this.wordsList + "\n");
    }

    /**
     * Removes specified words from the main song words list.
     *
     * @param listOfWordsToDelete list of words to be deleted
     */
    private void deleteWordsFromSong(List<String> listOfWordsToDelete) {
        Utils.removeWords(this.wordsList, listOfWordsToDelete);
    }
}
