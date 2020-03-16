package com.innowise.mongodb.util;

import com.innowise.mongodb.dto.AuthorDTO;
import com.innowise.mongodb.dto.BookDTO;
import com.innowise.mongodb.entity.Author;
import com.innowise.mongodb.entity.Book;
import org.springframework.stereotype.Component;

@Component
public class CustomMapper {

    public Book bookDtoToEntity(BookDTO bookDTO) {
        return new Book(bookDTO.getTitle(), bookDTO.getCreationDate(), bookDTO.getAuthor());
    }

    public Author authorDtoToEntity(AuthorDTO authorDTO) {
        return new Author(authorDTO.getFirstName(), authorDTO.getLastName());
    }
}
