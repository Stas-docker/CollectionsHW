import controller.WordFrequencyHandler;
import model.Song;
import utils.Utils;

public class Main {
    private static final String SONGS_STORAGE = "data/";
    private static final String YELLOW_SUBMARINE_PATH = SONGS_STORAGE + "YellowSubmarine.txt";

    public static void main(String[] args) {
            final String lyrics = Utils.readTextFromFile(YELLOW_SUBMARINE_PATH);
            WordFrequencyHandler.runSongAnalysis(new Song(lyrics));
    }
}
