package com.lets_book_it_api.controllers;

import com.lets_book_it_api.business_layer.book.BookService;
import com.lets_book_it_api.data_objects.book.BookDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/author")
@RequiredArgsConstructor
public class BookController
{
    private final BookService bookService;
    @GetMapping("/get?id={id}")
    public ResponseEntity<BookDTO> getBookById(String id)
    {
        return ResponseEntity.ok(bookService.getBookById(id));
    }
}
