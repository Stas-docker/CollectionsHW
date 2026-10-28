import controller.SongAnalyzer;
import model.Song;

public class Main {
    public static void main(String[] args) {
        final String yellowSubmarinePath = "data/YellowSubmarine.txt";
        final Song song = new Song(yellowSubmarinePath);
        SongAnalyzer songAnalyzer = new SongAnalyzer();
        songAnalyzer.runSongAnalysis(song);
    }
}
