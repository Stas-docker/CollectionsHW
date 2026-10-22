package controller;

/**
 * Represents the user's choice in the application.
 */
public enum UserChoice {
    CONTINUE(1),
    EXIT(2),
    UNKNOWN(0);

    private final int code;

    UserChoice(final int code) {
        this.code = code;
    }

    public static UserChoice fromCode(int code) {
        UserChoice fromKeyboard = UNKNOWN;
        for (UserChoice choice : values()) {
            if (choice.code == code) {
                fromKeyboard = choice;
            }
        }
        return fromKeyboard;
    }
}
