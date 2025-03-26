package com.digitalibrary.util;

import com.digitalibrary.model.Book;
import com.digitalibrary.exception.BookException;

/**
 * Utility class for validating book inputs.
 */
public class InputValidator {
    private static final String[] VALID_STATUSES = {"Available", "Checked Out"};

    /**
     * Validates a book object.
     * @param book The book to validate
     * @throws BookException if validation fails
     */
    public static void validateBook(Book book) throws BookException {
        if (book.getId() == null || book.getId().trim().isEmpty()) {
            throw new BookException("Book ID cannot be empty.");
        }

        if (book.getTitle() == null || book.getTitle().trim().isEmpty()) {
            throw new BookException("Book title cannot be empty.");
        }

        if (book.getAuthor() == null || book.getAuthor().trim().isEmpty()) {
            throw new BookException("Book author cannot be empty.");
        }

        if (book.getAvailabilityStatus() == null ||
                !isValidStatus(book.getAvailabilityStatus())) {
            throw new BookException("Invalid availability status. Must be 'Available' or 'Checked Out'.");
        }
    }

    private static boolean isValidStatus(String status) {
        for (String validStatus : VALID_STATUSES) {
            if (validStatus.equalsIgnoreCase(status)) {
                return true;
            }
        }
        return false;
    }
}