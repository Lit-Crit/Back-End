package com.lets_book_it_api.controllers;

import com.lets_book_it_api.business_layer.author.AuthorService;
import com.lets_book_it_api.data_objects.author.AuthorDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/author")
@RequiredArgsConstructor
public class AuthorController
{
    @Autowired
    private final AuthorService authorService;

    @GetMapping("/get?id={id}")
    public ResponseEntity<AuthorDTO> getAuthorById(String id)
    {
        return ResponseEntity.ok(authorService.getAuthorById(id));
    }


}
