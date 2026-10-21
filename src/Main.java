import controller.WordFrequencyHandler;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try (final Scanner scanner = new Scanner(System.in)) {
            WordFrequencyHandler.startSongAnalyzing(scanner);
        }
    }
}
