import controller.WordFrequencyHandler;
import model.Song;
import utils.Utils;

public class Main {
    private static final String SONGS_STORAGE = "data/";
    private static final String YELLOW_SUBMARINE_PATH = SONGS_STORAGE + "YellowSubmarine.txt";

    public static void main(String[] args) {
            final String lyrics = Utils.readTextFromFile(YELLOW_SUBMARINE_PATH);
            final Song song = new Song(lyrics);
            WordFrequencyHandler.runSongAnalysis(song);
    }
}
