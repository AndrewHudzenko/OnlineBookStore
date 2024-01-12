package com.mate.onlinebookstore.onlinebookstore.repository;

import com.mate.onlinebookstore.onlinebookstore.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {
}
