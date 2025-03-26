package com.digitalibrary.service;

import com.digitalibrary.model.Book;
import com.digitalibrary.exception.BookException;
import com.digitalibrary.util.InputValidator;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Service class that handles all business logic for book management operations.
 */
public class LibraryService {
    private List<Book> books;

    public LibraryService() {
        this.books = new ArrayList<>();
    }

    /**
     * Adds a new book to the library collection.
     * @param book The book to be added
     * @throws BookException if book ID already exists or validation fails
     */
    public void addBook(Book book) throws BookException {
        InputValidator.validateBook(book);

        if (books.stream().anyMatch(b -> b.getId().equals(book.getId()))) {
            throw new BookException("Book with ID " + book.getId() + " already exists.");
        }

        books.add(book);
    }

    /**
     * Retrieves all books in the library.
     * @return List of all books
     */
    public List<Book> getAllBooks() {
        return new ArrayList<>(books);
    }

    /**
     * Searches for books by ID or title (case-insensitive).
     * @param searchTerm ID or title to search for
     * @return List of matching books
     */
    public List<Book> searchBooks(String searchTerm) {
        return books.stream()
                .filter(book -> book.getId().equalsIgnoreCase(searchTerm) ||
                        book.getTitle().toLowerCase().contains(searchTerm.toLowerCase()))
                .collect(Collectors.toList());
    }

    /**
     * Updates book details.
     * @param bookId ID of the book to update
     * @param updatedBook Book object with updated details
     * @throws BookException if book not found or validation fails
     */
    public void updateBook(String bookId, Book updatedBook) throws BookException {
        InputValidator.validateBook(updatedBook);

        Book existingBook = books.stream()
                .filter(b -> b.getId().equals(bookId))
                .findFirst()
                .orElseThrow(() -> new BookException("Book with ID " + bookId + " not found."));

        existingBook.setTitle(updatedBook.getTitle());
        existingBook.setAuthor(updatedBook.getAuthor());
        existingBook.setGenre(updatedBook.getGenre());
        existingBook.setAvailabilityStatus(updatedBook.getAvailabilityStatus());
    }

    /**
     * Deletes a book from the library.
     * @param bookId ID of the book to delete
     * @throws BookException if book not found
     */
    public void deleteBook(String bookId) throws BookException {
        boolean removed = books.removeIf(book -> book.getId().equals(bookId));

        if (!removed) {
            throw new BookException("Book with ID " + bookId + " not found.");
        }
    }
}