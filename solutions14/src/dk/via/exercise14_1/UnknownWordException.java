package dk.via.exercise14_1;

public class UnknownWordException extends RuntimeException {
    public UnknownWordException(String word) {
        super(word);
    }
}
