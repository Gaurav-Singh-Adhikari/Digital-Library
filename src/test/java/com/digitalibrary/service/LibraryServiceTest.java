package com.digitalibrary.service;

import com.digitalibrary.model.Book;
import com.digitalibrary.exception.BookException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LibraryServiceTest {
    private LibraryService libraryService;
    private Book testBook;

    @BeforeEach
    void setUp() {
        libraryService = new LibraryService();
        testBook = new Book("1", "Test Book", "Test Author", "Test Genre", "Available");
    }

    @Test
    void addBook_ShouldAddBookSuccessfully() throws BookException {
        libraryService.addBook(testBook);
        assertEquals(1, libraryService.getAllBooks().size());
    }

    @Test
    void addBook_ShouldThrowExceptionForDuplicateId() throws BookException {
        libraryService.addBook(testBook);
        assertThrows(BookException.class, () -> libraryService.addBook(testBook));
    }

    @Test
    void searchBooks_ShouldFindBookById() throws BookException {
        libraryService.addBook(testBook);
        assertEquals(1, libraryService.searchBooks("1").size());
    }

    @Test
    void searchBooks_ShouldFindBookByTitle() throws BookException {
        libraryService.addBook(testBook);
        assertEquals(1, libraryService.searchBooks("Test Book").size());
    }

    @Test
    void updateBook_ShouldUpdateBookDetails() throws BookException {
        libraryService.addBook(testBook);
        Book updatedBook = new Book("1", "Updated Title", "Updated Author", "Updated Genre", "Checked Out");
        libraryService.updateBook("1", updatedBook);

        Book result = libraryService.searchBooks("1").get(0);
        assertEquals("Updated Title", result.getTitle());
        assertEquals("Checked Out", result.getAvailabilityStatus());
    }

    @Test
    void deleteBook_ShouldRemoveBook() throws BookException {
        libraryService.addBook(testBook);
        libraryService.deleteBook("1");
        assertEquals(0, libraryService.getAllBooks().size());
    }
}