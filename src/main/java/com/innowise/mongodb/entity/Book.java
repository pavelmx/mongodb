package com.innowise.mongodb.entity;

import java.util.Date;
import java.util.UUID;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.format.annotation.DateTimeFormat;

@Document
public class Book {

    @Id
    private UUID id;

    private String title;

    @DateTimeFormat(pattern = "dd-MM-yyyy")
    private Date creationDate;

    private Author author;

    public Book(String title, Date creationDate, Author author) {
        this.title = title;
        this.creationDate = creationDate;
        this.author = author;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }
}
