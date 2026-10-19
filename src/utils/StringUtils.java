package utils;

import java.util.Scanner;
/**
 * Provides utility methods for string processing.
 */
public class StringUtils {

    /**
     * Converts a string to lowercase and removes punctuation.
     *
     * @param string the string to clean
     * @return the cleaned string
     */
    public static String cleanString(final String string) {
        return string.toLowerCase().replace(",", "")
                .replace(".", "").replace("'", "");
    }

    /**
     * Splits a string into an array of words.
     *
     * @param string the string to split
     * @return an array of words
     */
    public static String[] stringToWordsArray(final String string) {
        return string.split(" ");
    }

    /**
     * Counts how many times a word appears in an array.
     *
     * @param arrayOfWords the array of words
     * @param searchedWord the word to count
     * @return the number of occurrences
     */
    public static int countWord(final String[] arrayOfWords, final String searchedWord) {
        int wordsCounter = 0;
        for (String word : arrayOfWords) {
            if (word.equals(searchedWord)) {
                wordsCounter++;
            }
        }
        return wordsCounter;
    }
}
