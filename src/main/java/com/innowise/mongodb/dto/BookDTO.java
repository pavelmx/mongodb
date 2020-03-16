package com.innowise.mongodb.dto;

import com.innowise.mongodb.entity.Author;
import java.util.Date;
import javax.validation.constraints.NotNull;
import org.springframework.format.annotation.DateTimeFormat;

public class BookDTO {

    @NotNull
    private String title;

    @DateTimeFormat(pattern = "dd-MM-yyyy")
    @NotNull
    private Date creationDate;

    private Author author;

    public BookDTO(String title, Date creationDate) {
        this.title = title;
        this.creationDate = creationDate;
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
