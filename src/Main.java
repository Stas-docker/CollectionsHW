import controller.WordFrequencyHandler;
import model.Song;
import utils.StringUtils;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try (final Scanner scanner = new Scanner(System.in)) {
            final String lyrics = StringUtils.readTextFromFile("/Users/smiti/Documents/YellowSubmarine.txt");
            final Song song = new Song(lyrics);
            WordFrequencyHandler.startSongAnalyzing(scanner, song);
        }
    }
}
