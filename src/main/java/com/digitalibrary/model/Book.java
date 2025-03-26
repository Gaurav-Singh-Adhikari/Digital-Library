package com.digitalibrary.model;

/**
 * Represents a book in the digital library system.
 * Contains book details including ID, title, author, genre, and availability status.
 */
public class Book {
    private String id;
    private String title;
    private String author;
    private String genre;
    private String availabilityStatus;

    public Book(String id, String title, String author, String genre, String availabilityStatus) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.availabilityStatus = availabilityStatus;
    }

    // Getters and setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getAvailabilityStatus() {
        return availabilityStatus;
    }

    public void setAvailabilityStatus(String availabilityStatus) {
        this.availabilityStatus = availabilityStatus;
    }

    @Override
    public String toString() {
        return String.format(
                "ID: %s | Title: %s | Author: %s | Genre: %s | Status: %s",
                id, title, author, genre, availabilityStatus
        );
    }
}