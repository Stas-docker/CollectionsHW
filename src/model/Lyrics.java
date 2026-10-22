package model;

import utils.StringUtils;

/**
 * Represents a song and its lyrics.
 */
public class Lyrics {
    private String lyrics = StringUtils.readTextFromFile("/Users/smiti/Documents/YellowSubmarine.txt");

    public String getLyrics() {
        return lyrics;
    }
}
