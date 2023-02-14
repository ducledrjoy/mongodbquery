package com.example.mongodbquery.domain;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;

@Data
@Document
public class Author {
    @Id
    private String id;
    private String name;
    @DBRef(lazy = true)
    private List<Post> postList;

    public Author(String name){
        this.postList = new ArrayList<>();
        this.name = name;
    }

}
