package mossaab.ayoub.restservice.repositories;

import mossaab.ayoub.restservice.models.Author;

import java.util.Optional;

public interface AuthorRepository {

    Optional<Author> getAuthorByEmail(String email);
    Optional<Author> getAuthorById(Long id);
    Optional<Author> getAuthorByFirstNameAndLastName(String firstName, String lastName);
}
