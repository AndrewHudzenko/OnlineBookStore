package com.mate.onlinebookstore.onlinebookstore.service;

import com.mate.onlinebookstore.onlinebookstore.model.Book;

import java.util.List;

public interface BookService {
    Book save(Book book);
    List<Book> findAll();
}
