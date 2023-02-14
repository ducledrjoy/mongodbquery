package com.example.mongodbquery.service;

import com.example.mongodbquery.domain.Author;

import java.util.List;

public interface AuthorService {
    Author createAuthor(String name);

    void updateAuthorPersonalInfo(String id, String newName);

    void removeAuthor(String id);

    Author getAuthorDetail(String id);

    List<Author> findAuthors(String keyword, int pageNo, int pageSize);
}
