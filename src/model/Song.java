package model;

/**
 * Represents a song and its lyrics.
 */
public class Song {
    private static String lyrics;

    public Song(String lyrics) {
        this.lyrics = lyrics;
    }

    public static String getLyrics() {
        return lyrics;
    }
}
