package dk.via.exercise13_3;

public class UnknownWordException extends RuntimeException {
    public UnknownWordException(String word) {
        super(word);
    }
}
