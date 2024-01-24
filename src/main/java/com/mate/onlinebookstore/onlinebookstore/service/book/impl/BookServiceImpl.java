package com.mate.onlinebookstore.onlinebookstore.service.book.impl;

import com.mate.onlinebookstore.onlinebookstore.dto.book.BookDto;
import com.mate.onlinebookstore.onlinebookstore.dto.book.BookSearchParameters;
import com.mate.onlinebookstore.onlinebookstore.dto.book.CreateBookRequestDto;
import com.mate.onlinebookstore.onlinebookstore.exception.EntityNotFoundException;
import com.mate.onlinebookstore.onlinebookstore.mapper.book.BookMapper;
import com.mate.onlinebookstore.onlinebookstore.model.Book;
import com.mate.onlinebookstore.onlinebookstore.repository.book.BookRepository;
import com.mate.onlinebookstore.onlinebookstore.repository.book.BookSpecificationBuilder;
import com.mate.onlinebookstore.onlinebookstore.service.book.BookService;
import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BookServiceImpl implements BookService {
    private final BookRepository bookRepository;
    private final BookMapper bookMapper;
    private final BookSpecificationBuilder bookSpecificationBuilder;

    @Override
    public BookDto create(CreateBookRequestDto book) {
        return bookMapper.toDto(bookRepository.save(bookMapper.toModel(book)));
    }

    @Override
    public List<BookDto> findAll(Pageable pageable) {
        return bookRepository.findAll(pageable).stream()
                .map(bookMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public BookDto findById(Long id) {
        return bookMapper.toDto(bookRepository.findById(id).orElseThrow(
                () -> new EntityNotFoundException(String.format("Book with id %s not found", id))));
    }

    @Override
    public BookDto update(Long id, CreateBookRequestDto bookRequestDto) {
        if (findById(id) != null) {
            Book newBook = bookMapper.toModel(bookRequestDto);
            newBook.setId(id);
            bookRepository.save(newBook);
            return bookMapper.toDto(newBook);
        }
        return null;
    }

    @Override
    public void deleteById(Long id) {
        bookRepository.deleteById(id);
    }

    @Override
    public List<BookDto> search(BookSearchParameters params) {
        Specification<Book> bookSpecification = bookSpecificationBuilder.build(params);
        return bookRepository.findAll(bookSpecification).stream()
                .map(bookMapper::toDto)
                .toList();
    }
}
