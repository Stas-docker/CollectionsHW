package utils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

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
     * @return a list of words
     */
    public static List<String> stringToWordsList(final String string) {
        String[] wordsArray = string.split(" ");
        return Arrays.asList(wordsArray);
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

    public static List<String> removeDuplicates(final List<String> listOfWords) {
        List<String> listWithoutDuplicates = new ArrayList<>();
        Iterator<String> iterator = listOfWords.iterator();
        while (iterator.hasNext()) {
            String word = iterator.next();
            if (!listWithoutDuplicates.contains(word)) {
                listWithoutDuplicates.add(word);
            }
        }
        return listWithoutDuplicates;
    }
}
