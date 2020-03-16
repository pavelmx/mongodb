package com.innowise.mongodb.service;

import com.innowise.mongodb.dto.AuthorDTO;
import com.innowise.mongodb.entity.Author;
import java.util.List;
import java.util.UUID;

public interface AuthorService {
    List<Author> getAllAuthors();

    void addAuthor(AuthorDTO authorDTO);

    Author getAuthor(UUID authorId);
}
