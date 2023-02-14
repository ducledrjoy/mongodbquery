package com.example.mongodbquery.domain;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Data
@Document
public class Post {
    @Id
    private String id;
    private String title;
    private String content;
    @DBRef
    private Author author;
    private Date createDate;
    private Date modifiedDate;
    private Date deletedDate;
}
