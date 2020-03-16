package com.innowise.mongodb.service;

import com.innowise.mongodb.dto.BookDTO;
import com.innowise.mongodb.entity.Book;
import java.util.List;
import java.util.UUID;

public interface BookService {


    List<Book> getAllBooks();

    List<Book> getBooksByAuthor(UUID authorId);

    void addBook(BookDTO bookDTO, UUID authorId);

    void addBookList(List<BookDTO> bookDTOList, UUID authorId);

    Book getBook(UUID bookId);
}
