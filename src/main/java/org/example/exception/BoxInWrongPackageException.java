package org.example.exception;

public class BoxInWrongPackageException extends RuntimeException {
    public BoxInWrongPackageException(String message) {
        super(message);
    }
}
