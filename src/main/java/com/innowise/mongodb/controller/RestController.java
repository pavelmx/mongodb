package com.innowise.mongodb.controller;

import com.innowise.mongodb.dto.AuthorDTO;
import com.innowise.mongodb.dto.BookDTO;
import com.innowise.mongodb.dto.ResponseDTO;
import com.innowise.mongodb.entity.Author;
import com.innowise.mongodb.entity.Book;
import com.innowise.mongodb.service.AuthorService;
import com.innowise.mongodb.service.BookService;
import java.util.List;
import java.util.UUID;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@org.springframework.web.bind.annotation.RestController
public class RestController {

    @Autowired
    private BookService bookService;

    @Autowired
    private AuthorService authorService;

    @GetMapping("books")
    public ResponseDTO getAllBooks() {
        List<Book> res = bookService.getAllBooks();
        return new ResponseDTO(ResponseDTO.Status.SUCCESS, String.format("Found %s books", res.size()), res);
    }

    @GetMapping("books/{bookId}")
    public ResponseDTO getBook(@PathVariable UUID bookId) {
        Book res = bookService.getBook(bookId);
        return new ResponseDTO(ResponseDTO.Status.SUCCESS, String.format("Found book: %s", res.getTitle()), res);
    }

    @GetMapping("authors")
    public ResponseDTO getAllAuthors() {
        List<Author> res = authorService.getAllAuthors();
        return new ResponseDTO(ResponseDTO.Status.SUCCESS, String.format("Found %s authors", res.size()), res);
    }

    @GetMapping("authors/{authorId}")
    public ResponseDTO getAuthor(@PathVariable UUID authorId) {
        Author res = authorService.getAuthor(authorId);
        return new ResponseDTO(ResponseDTO.Status.SUCCESS, String.format("Found author: %s %s", res.getFirstName(), res.getLastName()), res);
    }

    @GetMapping("books/author/{authorId}")
    public ResponseDTO getBooksByAuthor(@PathVariable UUID authorId) {
        List<Book> res;
        try {
           res = bookService.getBooksByAuthor(authorId);
        } catch (Exception e) {
            return new ResponseDTO(ResponseDTO.Status.FAIL, e.getMessage(), null);
        }

        return new ResponseDTO(ResponseDTO.Status.SUCCESS, String.format("Found %s books", res.size()), res);
    }

    @PostMapping("authors")
    public ResponseDTO addAuthor(@Valid @RequestBody AuthorDTO authorDTO) {
        try {
            authorService.addAuthor(authorDTO);
        } catch (Exception e) {
            return new ResponseDTO(ResponseDTO.Status.FAIL, e.getMessage(), null);
        }

        return new ResponseDTO(ResponseDTO.Status.SUCCESS, String.format("Added new author %s", authorDTO.getName()), null);
    }

    @PostMapping("books/author/{authorId}")
    public ResponseDTO addBook(@Valid @RequestBody BookDTO bookDTO, @PathVariable UUID authorId) {
        try {
            bookService.addBook(bookDTO, authorId);
        } catch (Exception e) {
            return new ResponseDTO(ResponseDTO.Status.FAIL, e.getMessage(), null);
        }

        return new ResponseDTO(ResponseDTO.Status.SUCCESS, String.format("Added new book %s", bookDTO.getTitle()), null);
    }

    @PostMapping("books/list/{authorId}")
    public ResponseDTO addBookList(@Valid @RequestBody List<BookDTO> bookDTOList, @PathVariable UUID authorId) {
        try {
            bookService.addBookList(bookDTOList, authorId);
        } catch (Exception e) {
            return new ResponseDTO(ResponseDTO.Status.FAIL, e.getMessage(), null);
        }

        return new ResponseDTO(ResponseDTO.Status.SUCCESS, String.format("Added %s new books", bookDTOList.size()), null);
    }
}
