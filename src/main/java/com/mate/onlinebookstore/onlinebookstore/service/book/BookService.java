package com.mate.onlinebookstore.onlinebookstore.service.book;

import com.mate.onlinebookstore.onlinebookstore.dto.BookDto;
import com.mate.onlinebookstore.onlinebookstore.dto.BookSearchParameters;
import com.mate.onlinebookstore.onlinebookstore.dto.CreateBookRequestDto;
import java.util.List;
import org.springframework.data.domain.Pageable;

public interface BookService {
    BookDto create(CreateBookRequestDto bookRequestDto);

    List<BookDto> findAll(Pageable pageable);

    BookDto findById(Long id);

    BookDto update(Long id, CreateBookRequestDto bookRequestDto);

    void deleteById(Long id);

    List<BookDto> search(BookSearchParameters params);
}
