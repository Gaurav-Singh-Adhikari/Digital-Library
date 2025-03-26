package com.digitalibrary;

import com.digitalibrary.model.Book;
import com.digitalibrary.service.LibraryService;
import com.digitalibrary.exception.BookException;

import java.util.List;
import java.util.Scanner;

/**
 * Main application class for the Digital Library Book Management System.
 */
public class MainApp {
    private static final Scanner scanner = new Scanner(System.in);
    private static final LibraryService libraryService = new LibraryService();

    public static void main(String[] args) {
        boolean running = true;

        while (running) {
            displayMenu();
            String choice = scanner.nextLine();

            try {
                switch (choice) {
                    case "1":
                        addBook();
                        break;
                    case "2":
                        viewAllBooks();
                        break;
                    case "3":
                        searchBook();
                        break;
                    case "4":
                        updateBook();
                        break;
                    case "5":
                        deleteBook();
                        break;
                    case "6":
                        running = false;
                        System.out.println("Exiting system. Goodbye!");
                        break;
                    default:
                        System.out.println("Invalid choice. Please try again.");
                }
            } catch (BookException e) {
                System.out.println("Error: " + e.getMessage());
            }
        }

        scanner.close();
    }

    private static void displayMenu() {
        System.out.println("\nDigital Library Book Management System");
        System.out.println("1. Add a Book");
        System.out.println("2. View All Books");
        System.out.println("3. Search Book by ID or Title");
        System.out.println("4. Update Book Details");
        System.out.println("5. Delete a Book Record");
        System.out.println("6. Exit System");
        System.out.print("Enter your choice: ");
    }

    private static void addBook() throws BookException {
        System.out.println("\nAdd a New Book");

        System.out.print("Enter Book ID: ");
        String id = scanner.nextLine();

        System.out.print("Enter Title: ");
        String title = scanner.nextLine();

        System.out.print("Enter Author: ");
        String author = scanner.nextLine();

        System.out.print("Enter Genre: ");
        String genre = scanner.nextLine();

        System.out.print("Enter Availability Status (Available/Checked Out): ");
        String status = scanner.nextLine();

        Book book = new Book(id, title, author, genre, status);
        libraryService.addBook(book);
        System.out.println("Book added successfully!");
    }

    private static void viewAllBooks() {
        System.out.println("\nAll Books in Library");
        List<Book> books = libraryService.getAllBooks();

        if (books.isEmpty()) {
            System.out.println("No books available in the library.");
        } else {
            books.forEach(System.out::println);
        }
    }

    private static void searchBook() {
        System.out.print("\nEnter Book ID or Title to search: ");
        String searchTerm = scanner.nextLine();

        List<Book> results = libraryService.searchBooks(searchTerm);

        if (results.isEmpty()) {
            System.out.println("No books found matching your search.");
        } else {
            System.out.println("Search Results:");
            results.forEach(System.out::println);
        }
    }

    private static void updateBook() throws BookException {
        System.out.print("\nEnter Book ID to update: ");
        String bookId = scanner.nextLine();

        System.out.println("Enter new details (leave blank to keep current value):");

        System.out.print("New Title: ");
        String title = scanner.nextLine();

        System.out.print("New Author: ");
        String author = scanner.nextLine();

        System.out.print("New Genre: ");
        String genre = scanner.nextLine();

        System.out.print("New Availability Status (Available/Checked Out): ");
        String status = scanner.nextLine();

        // Get current book details
        List<Book> currentBooks = libraryService.searchBooks(bookId);
        if (currentBooks.isEmpty()) {
            throw new BookException("Book not found.");
        }
        Book currentBook = currentBooks.get(0);

        // Create updated book with new values (or keep current if blank)
        Book updatedBook = new Book(
                bookId,
                title.isEmpty() ? currentBook.getTitle() : title,
                author.isEmpty() ? currentBook.getAuthor() : author,
                genre.isEmpty() ? currentBook.getGenre() : genre,
                status.isEmpty() ? currentBook.getAvailabilityStatus() : status
        );

        libraryService.updateBook(bookId, updatedBook);
        System.out.println("Book updated successfully!");
    }

    private static void deleteBook() throws BookException {
        System.out.print("\nEnter Book ID to delete: ");
        String bookId = scanner.nextLine();

        libraryService.deleteBook(bookId);
        System.out.println("Book deleted successfully!");
    }
}