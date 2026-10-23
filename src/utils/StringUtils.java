package utils;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
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
    public static String toLowerCaseAndStripPunctuation(final String string) {
        return string.toLowerCase().
                replaceAll("[,.')(]", "")
                .replace("\n", " ");
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

    public static boolean fileIsNotEmpty(final String filePath) {
        String text = readTextFromFile(filePath);
        return !text.isBlank();
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
            if (word.equals(searchedWord) && !word.isBlank()) {
                wordsCounter++;
            }
        }
        return wordsCounter;
    }

    /**
     * Checks whether the input string can be parsed as a valid integer.
     *
     * @param value the string to validate
     * @return true if the string is a valid integer, false otherwise
     */
    public static boolean isInteger(String value) {
        boolean isValid;
        try {
            Integer.parseInt(value);
            isValid = true;
        } catch (NumberFormatException e) {
            isValid = false;
        }
        return isValid;
    }

    /**
     * Reads the entire content of a file into a single string.
     *
     * @param filePath path to the target file
     * @return file content as a string
     * @throws IOException if an I/O error occurs reading the file
     */
    public static String readTextFromFile(final String filePath) {
        try {
            return Files.readString(Path.of(filePath));
        } catch (IOException e) {
            return "We could not process the file";
        }
    }
}
