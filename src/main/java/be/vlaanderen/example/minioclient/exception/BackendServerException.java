package be.vlaanderen.example.minioclient.exception;

public class BackendServerException extends RuntimeException {
    public BackendServerException(Throwable e) {
        super(e);
    }
}
