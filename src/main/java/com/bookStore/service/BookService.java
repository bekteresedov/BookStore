package com.bookStore.service;

import com.bookStore.data.entity.Book;

import java.util.List;
import java.util.Optional;

public interface BookService {

    Optional<Book> getOneBook(Integer  id);

    List<Book> getAllBooks();
}
