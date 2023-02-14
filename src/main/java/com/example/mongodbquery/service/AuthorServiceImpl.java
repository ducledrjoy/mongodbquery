package com.example.mongodbquery.service;

import com.example.mongodbquery.domain.Author;
import com.example.mongodbquery.exception.AuthorNotFoundException;
import com.example.mongodbquery.repository.AuthorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AuthorServiceImpl implements AuthorService {

    private final AuthorRepository authorRepository;

    @Override
    public Author createAuthor(String name) {

        return authorRepository.save(new Author(name));
    }

    @Override
    public void updateAuthorPersonalInfo(String id, String newName) {

        Optional<Author> authorOptional = authorRepository.findById(id);
        if (!authorOptional.isPresent()) {
            throw new AuthorNotFoundException();
        }
        Author currAuthor = authorOptional.get();
        currAuthor.setName(newName);
        authorRepository.save(currAuthor);
    }

    @Override
    public void removeAuthor(String id) {

        Optional<Author> authorOptional = authorRepository.findById(id);
        if (!authorOptional.isPresent()) {
            throw new AuthorNotFoundException();
        }
        authorRepository.deleteById(id);
    }

    @Override
    public Author getAuthorDetail(String id) {

        Optional<Author> authorOptional = authorRepository.findById(id);
        if (!authorOptional.isPresent()) {
            throw new RuntimeException("not found");
        }
        return authorOptional.get();
    }

    @Override
    public List<Author> findAuthors(String keyword, int pageNo, int pageSize) {
        return null;
    }
}
