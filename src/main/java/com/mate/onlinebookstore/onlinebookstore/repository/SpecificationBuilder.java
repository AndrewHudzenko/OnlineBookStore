package com.mate.onlinebookstore.onlinebookstore.repository;

import com.mate.onlinebookstore.onlinebookstore.dto.book.BookSearchParameters;
import com.mate.onlinebookstore.onlinebookstore.model.Book;
import org.springframework.data.jpa.domain.Specification;

public interface SpecificationBuilder<T> {
    Specification<Book> build(BookSearchParameters bookSearchParameters);
}
