package com.innowise.mongodb.exception;

public class EntityNotFoundException extends RuntimeException {

    public EntityNotFoundException(final String message) {
        super(message);
    }

    public EntityNotFoundException(final String message, final Throwable throwable) {
        super(message, throwable);
    }
}
