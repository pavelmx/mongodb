package com.innowise.mongodb.repository;

import com.innowise.mongodb.entity.Book;
import java.util.List;
import java.util.UUID;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface BookRepository extends MongoRepository<Book, UUID> {

    List<Book> findAllByAuthorId(UUID authorId);

    Book findByTitle(String title);
}
