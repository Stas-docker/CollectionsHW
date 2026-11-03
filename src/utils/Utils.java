package utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;

/**
 * Provides utility methods for string processing.
 */
public class Utils {

    /**
     * Converts a string to lowercase and removes punctuation.
     *
     * @param string the string to clean
     * @return the cleaned string
     */
    public static String toLowerCaseAndStripPunctuation(final String string) {
        return string.toLowerCase().
                replaceAll("[,.')(]", "")
                .replace("\n", " ");
    }

    /**
     * Splits a string into an array of words.
     *
     * @param string the string to split
     * @return a list of words
     */
    public static List<String> stringToWordsList(final String string) {
        String[] wordsArray = string.split(" ");
        return new ArrayList<>(Arrays.asList(wordsArray));
    }

    /**
     * Counts how many times a word appears in an array.
     *
     * @param wordsList    the list of words
     * @param searchedWord the word to count
     * @return the number of occurrences
     */
    public static int countWord(final List<String> wordsList, final String searchedWord) {
        int wordsCounter = 0;
        if (wordsList != null && searchedWord != null && !searchedWord.isBlank()) {
            for (String word : wordsList) {
                if (word.equals(searchedWord) && !word.isBlank()) {
                    wordsCounter++;
                }
            }
        }
        return wordsCounter;
    }

    /**
     * Reads the entire content of a file into a single string.
     *
     * @param filePath path to the target file
     * @return file content as a string
     * @throws IOException if an I/O error occurs reading the file
     */
    public static String readTextFromFile(final String filePath) throws IOException {
        try (final BufferedReader reader = Files.newBufferedReader(Path.of(filePath))) {
            return reader.readAllAsString();
        }
    }

    /**
     * Removes specific words from a list.
     *
     * @param listOfWords the list of words to process
     */
    public static void removeWords(final List<String> listOfWords, final List<String> listOfWordsToDelete) {
        listOfWords.removeAll(listOfWordsToDelete);
    }

    /**
     * Checks whether the specified search string is present in the song text.
     *
     * @param string the string to search for
     * @param songText the text of the song to search within
     * @return {@code true} if the string is found in the song text, {@code false} otherwise
     * @throws BeatlesException if an error occurs during processing
     */
    public static boolean stringCanBeFound(final String string, final String songText) throws BeatlesException {
        final String cleanedString = toLowerCaseAndStripPunctuation(string);
        return songText.contains(cleanedString);
    }
}
