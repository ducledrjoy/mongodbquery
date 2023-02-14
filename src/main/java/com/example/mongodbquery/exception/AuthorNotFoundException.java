package com.example.mongodbquery.exception;

public class AuthorNotFoundException extends RuntimeException{
    public AuthorNotFoundException() {
        super("AUTHOR NOT FOUND");
    }
}
