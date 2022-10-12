package com.bookStore.service.impl;

import com.bookStore.data.entity.Book;
import com.bookStore.data.repository.BookRepository;
import com.bookStore.service.BookService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@FieldDefaults(level = AccessLevel.PRIVATE)
@RequiredArgsConstructor
@Transactional
public class BookServiceImpl implements BookService {

    final BookRepository bookRepository;


    @Override
    public Optional<Book> getOneBook(Integer  id) {
        return bookRepository.findById(id);
    }

    @Override
    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }
}
