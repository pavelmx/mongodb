package com.innowise.mongodb.service;

import com.innowise.mongodb.dto.AuthorDTO;
import com.innowise.mongodb.entity.Author;
import com.innowise.mongodb.exception.EntityExistsException;
import com.innowise.mongodb.exception.EntityNotFoundException;
import com.innowise.mongodb.repository.AuthorRepository;
import com.innowise.mongodb.util.CustomMapper;
import java.util.List;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthorServiceImpl implements AuthorService {

    @Autowired
    private AuthorRepository authorRepository;

    @Autowired
    private CustomMapper mapper;

    @Override
    public List<Author> getAllAuthors() {
        return authorRepository.findAll();
    }

    @Override
    public void addAuthor(AuthorDTO authorDTO) {
        checkExists(authorDTO);

        Author author = mapper.authorDtoToEntity(authorDTO);
        author.setId(UUID.randomUUID());
        authorRepository.insert(author);
    }

    @Override
    public Author getAuthor(UUID authorId) {
        return authorRepository.findById(authorId)
                .orElseThrow(() -> new EntityNotFoundException("Author not found"));
    }

    private void checkExists(AuthorDTO authorDTO) {
        Author author = authorRepository.findByFirstNameAndLastName(authorDTO.getFirstName(), authorDTO.getLastName());
        if (author != null) {
            throw new EntityExistsException("Author with that name already exists");
        }
    }
}
