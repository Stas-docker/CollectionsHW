import controller.WordFrequencyHandler;
import model.Song;
import utils.Utils;

public class Main {
    public static void main(String[] args) {
        final String yellowSubmarinePath = "data/YellowSubmarine.txt";
        final Song song = new Song(yellowSubmarinePath);
        WordFrequencyHandler wordFrequencyHandler = new WordFrequencyHandler();
        wordFrequencyHandler.runSongAnalysis(song);
    }
}
