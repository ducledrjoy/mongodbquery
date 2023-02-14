package com.example.mongodbquery.controller;

import com.example.mongodbquery.domain.Author;
import com.example.mongodbquery.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/post")
@RequiredArgsConstructor
public class PostController {
    private final PostService postService;
    @PostMapping("/{authorId}/new")
    public ResponseEntity<Author> addPost(@PathVariable(name = "authorId") String authorId,
                                          @RequestParam(defaultValue = "title") String title,
                                          @RequestParam(defaultValue = "content") String content){

        Author response = postService.addPost(authorId,title,content);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PutMapping("/{authorId}/edit")
    public ResponseEntity<Author> editPost(@PathVariable(name = "authorId") String authorId,
                                           @RequestParam(required = false) String title,
                                           @RequestParam(required = false) String content){
        Author response = postService.editPost(authorId, title,content);
        return new ResponseEntity<>(response,HttpStatus.OK);
    }

    @DeleteMapping("/{authorId}/{postId}")
    public ResponseEntity<?> removePostOrAllPost(@PathVariable(name = "authorId") String authorId,
                                                 @PathVariable(name = "postId",required = false) String postId){

        if(postId != null){
            Author author = postService.removeOnePost(authorId,postId);
            return new ResponseEntity<>(author,HttpStatus.OK);
        }
        postService.removeAllPostOf(authorId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("{authorId}/{postId}")
    public ResponseEntity<?> getOnePostOrAllPost(@PathVariable(name = "authorId") String authorId,
                                                 @PathVariable(name = "postId",required = false) String postId){

        if(postId != null){
            
        }
    }
}
