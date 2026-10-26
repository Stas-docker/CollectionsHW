package utils;

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
        return Arrays.asList(wordsArray);
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

    /**
     * Removes duplicate words from the list while preserving their original order.
     *
     * @param listOfWords the list of words to process
     * @return a new list containing only unique words
     */
    public static List<String> removeDuplicates(final List<String> listOfWords) {
        final List<String> listWithoutDuplicates = new ArrayList<>();
        for (String word : listOfWords) {
            if (!listWithoutDuplicates.contains(word)) {
                listWithoutDuplicates.add(word);
            }
        }
        return listWithoutDuplicates;
    }

    /**
     * Sorts a list of words in ascending order based on their length.
     *
     * @param listOfWords the list of words to sort in place
     */
    public static void sortStringsByLength(final List<String> listOfWords) {
        listOfWords.sort(new StringLengthComparator());
    }
}
