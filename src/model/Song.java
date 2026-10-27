package model;

import utils.Utils;

/**
 * Represents a song and its lyrics.
 */
public class Song {
    private String songPath;
    private final String lyrics;

    public String getLyrics() {
        return lyrics;
    }

    public Song(final String songPath) {
        if (songPath == null) {
            throw new IllegalArgumentException("Song path cannot be null");
        }
        this.songPath = songPath;
        this.lyrics = Utils.readTextFromFile(songPath);
    }
}
