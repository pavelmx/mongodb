package com.innowise.mongodb.repository;

import com.innowise.mongodb.entity.Author;
import java.util.UUID;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface AuthorRepository extends MongoRepository<Author, UUID> {

    Author findByFirstNameAndLastName(String firstName, String lastName);
}
