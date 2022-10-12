package com.bookStore.controller;

import com.bookStore.data.entity.Book;
import com.bookStore.service.BookService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping  ("/books/")
@FieldDefaults(level = AccessLevel.PRIVATE)
@RequiredArgsConstructor
public class BookController {

    final BookService bookService;

    @GetMapping("/getAll")
    public ResponseEntity<List<Book>> getAllBooks() {
        return ResponseEntity.ok(bookService.getAllBooks());
    }


}
