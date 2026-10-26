package view;

/**
 * Displays the application menus.
 */
public class Menu {

    /**
     * Displays the welcome message.
     */
    public static void startMenu() {
        System.out.println("""
                \nHi, enter a word and I will show you how many times it was repeated in the song:
                """);
    }

    public static void middleMenu() {
        System.out.println("Now type words you want delete from a song: ");
    }

    /**
     * Displays the options to continue or exit.
     */
    public static void endMenu() {
        System.out.println("Choose 1 if you want to continue\n" +
                "Choose 2 if you want to exit");
    }
}
