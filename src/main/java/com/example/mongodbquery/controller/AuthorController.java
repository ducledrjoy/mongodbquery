package com.example.mongodbquery.controller;

import com.example.mongodbquery.domain.Author;
import com.example.mongodbquery.service.AuthorService;
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

import java.util.List;

@RestController
@RequestMapping("/author")
@RequiredArgsConstructor
public class AuthorController {
    private final AuthorService authorService;

    @PostMapping("/new")
    public ResponseEntity<Author> createAuthor(@RequestParam String name) {

        Author response = authorService.createAuthor(name);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PutMapping("/edit")
    public ResponseEntity<Void> updateAuthorPersonalInfo(@RequestParam String id,
                                                         @RequestParam String newName) {

        authorService.updateAuthorPersonalInfo(id, newName);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/remove")
    public ResponseEntity<Void> removeAuthor(@RequestParam String id) {

        authorService.removeAuthor(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Author> getAuthorDetail(@PathVariable(name = "id") String id) {

        Author response = authorService.getAuthorDetail(id);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    /**
     * @param keyword  is the keyword, if keyword match any post then return the author wrote that post. Or match any author's name.
     * @param pageNo   : is the page number
     * @param pageSize : is the size of page
     * @return : a list of Author
     */
    @GetMapping("/find")
    public ResponseEntity<List<Author>> findAuthors(@RequestParam(defaultValue = "") String keyword,
                                                    @RequestParam(defaultValue = "0") int pageNo,
                                                    @RequestParam(defaultValue = "10") int pageSize) {

        List<Author> response = authorService.findAuthors(keyword, pageNo, pageSize);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
