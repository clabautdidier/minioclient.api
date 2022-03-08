package be.vlaanderen.example.minioclient.exception;

public class InvalidInputException extends RuntimeException {
    public InvalidInputException(Throwable e) {
        super(e);
    }
}
