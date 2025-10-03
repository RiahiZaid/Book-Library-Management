package com.book.booklibrarymanagement.entity;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(nullable = false)
    private String title;
    @Column(nullable = false)
    private String author;
    @Column(nullable = false)
    private String publisher;
    @Column(nullable = false)
    private String category;
    @Column(nullable = false)
    private String isbn;
    @Column(nullable = false)
    private LocalDate publishedDate;
    @Column(nullable = false)
    private int totalcopies;
    @Column(nullable = false)
    private int Availablecopies;


    public Book(long id, String title, String author, String publisher, String category, String isbn, LocalDate publishedDate, int totalcopies, int availablecopies) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.publisher = publisher;
        this.category = category;
        this.isbn = isbn;
        this.publishedDate = publishedDate;
        this.totalcopies = totalcopies;
        this.Availablecopies = availablecopies;
    }
    public Book() {
        super();
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
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

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getTotalcopies() {
        return totalcopies;
    }

    public void setTotalcopies(int totalcopies) {
        this.totalcopies = totalcopies;
    }

    public int getAvailablecopies() {
        return Availablecopies;
    }

    public void setAvailablecopies(int availablecopies) {
        this.Availablecopies = availablecopies;
    }

    public LocalDate getPublishedDate() {
        return publishedDate;
    }

    public void setPublishedDate(LocalDate publishedDate) {
        this.publishedDate = publishedDate;
    }
}
