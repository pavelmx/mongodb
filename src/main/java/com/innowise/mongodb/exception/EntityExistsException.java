package com.innowise.mongodb.exception;

public class EntityExistsException extends RuntimeException {

    public EntityExistsException(final String message) {
        super(message);
    }

    public EntityExistsException(final String message, final Throwable throwable) {
        super(message, throwable);
    }
}
