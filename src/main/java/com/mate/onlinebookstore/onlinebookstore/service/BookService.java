package com.mate.onlinebookstore.onlinebookstore.service;

import com.mate.onlinebookstore.onlinebookstore.dto.BookDto;
import com.mate.onlinebookstore.onlinebookstore.dto.CreateBookRequestDto;
import java.util.List;

public interface BookService {
    BookDto create(CreateBookRequestDto bookRequestDto);

    List<BookDto> findAll();

    BookDto findById(Long id);
}
