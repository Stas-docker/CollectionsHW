package utils;

/**
 * Unchecked exception thrown to indicate errors during Beatles song processing and analysis.
 */
public class BeatlesException extends RuntimeException {
    public BeatlesException(String message) {
        super(message);
    }
}
