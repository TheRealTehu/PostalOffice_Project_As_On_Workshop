package org.example.exception;

public class NotEnoughBoxesForPackageException extends RuntimeException {
    public NotEnoughBoxesForPackageException(String message) {
        super(message);
    }
}
