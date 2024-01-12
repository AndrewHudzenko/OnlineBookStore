package com.mate.onlinebookstore.onlinebookstore.service.impl;

import com.mate.onlinebookstore.onlinebookstore.model.Book;
import com.mate.onlinebookstore.onlinebookstore.repository.BookRepository;
import com.mate.onlinebookstore.onlinebookstore.service.BookService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BookServiceImpl implements BookService {
    private final BookRepository bookRepository;

    @Override
    public Book save(Book book) {
        return bookRepository.save(book);
    }

    @Override
    public List<Book> findAll() {
        return bookRepository.findAll();
    }
}
