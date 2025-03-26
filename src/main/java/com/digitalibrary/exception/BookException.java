package com.digitalibrary.exception;

/**
 * Custom exception class for book-related errors.
 */
public class BookException extends Exception {
    public BookException(String message) {
        super(message);
    }
}