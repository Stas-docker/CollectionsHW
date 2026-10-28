package model;

import utils.BeatlesException;
import utils.Utils;

import java.io.IOException;
import java.io.UncheckedIOException;

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

        try {
            this.lyrics = Utils.readTextFromFile(songPath);
        } catch (IOException fileException) {
            throw new BeatlesException("Could not process the Beatles file");
        }
    }
}
