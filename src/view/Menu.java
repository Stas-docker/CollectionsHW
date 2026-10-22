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
                \nHi, type a word and I will tell you how many times it is used in the lyrics "beatles yellow submarine"
                """);
    }


    /**
     * Displays the options to continue or exit.
     */
    public static void endMenu() {
        System.out.println("Choose 1 if you want to continue\n" +
                "Choose 2 if you want to exit");
    }
}
