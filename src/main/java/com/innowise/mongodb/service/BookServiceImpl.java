package com.innowise.mongodb.service;

import com.innowise.mongodb.dto.BookDTO;
import com.innowise.mongodb.entity.Author;
import com.innowise.mongodb.entity.Book;
import com.innowise.mongodb.exception.EntityExistsException;
import com.innowise.mongodb.exception.EntityNotFoundException;
import com.innowise.mongodb.repository.AuthorRepository;
import com.innowise.mongodb.repository.BookRepository;
import com.innowise.mongodb.util.CustomMapper;
import java.util.List;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private AuthorRepository authorRepository;

    @Autowired
    private CustomMapper mapper;

    @Override
    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    @Override
    public List<Book> getBooksByAuthor(UUID authorId) {
        return bookRepository.findAllByAuthorId(authorId);
    }

    @Override
    public void addBook(BookDTO bookDTO, UUID authorId) {
        Author author = authorRepository.findById(authorId)
                .orElseThrow(() -> new EntityNotFoundException("Not found author"));

        checkExists(bookDTO);

        Book entityToPersist = mapper.bookDtoToEntity(bookDTO);
        entityToPersist.setAuthor(author);
        entityToPersist.setId(UUID.randomUUID());

        bookRepository.insert(entityToPersist);
    }

    @Override
    public void addBookList(List<BookDTO> bookDTOList, UUID authorId) {
        Author author = authorRepository.findById(authorId)
                .orElseThrow(() -> new EntityNotFoundException("Not found author"));

        for (BookDTO bookDTO : bookDTOList) {
            checkExists(bookDTO);

            Book entityToPersist = mapper.bookDtoToEntity(bookDTO);
            entityToPersist.setAuthor(author);
            entityToPersist.setId(UUID.randomUUID());

            bookRepository.insert(entityToPersist);
        }
    }

    @Override
    public Book getBook(UUID bookId) {
        return bookRepository.findById(bookId)
                .orElseThrow(() -> new EntityNotFoundException("Book not found"));
    }

    private void checkExists(BookDTO bookDTO) {
        Book book = bookRepository.findByTitle(bookDTO.getTitle());
        if (book != null) {
            throw new EntityExistsException("Book with that title already exists");
        }
    }

}
