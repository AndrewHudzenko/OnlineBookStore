package com.mate.onlinebookstore.onlinebookstore.service.impl;

import com.mate.onlinebookstore.onlinebookstore.dto.BookDto;
import com.mate.onlinebookstore.onlinebookstore.dto.CreateBookRequestDto;
import com.mate.onlinebookstore.onlinebookstore.exception.EntityNotFoundException;
import com.mate.onlinebookstore.onlinebookstore.mapper.BookMapper;
import com.mate.onlinebookstore.onlinebookstore.model.Book;
import com.mate.onlinebookstore.onlinebookstore.repository.BookRepository;
import com.mate.onlinebookstore.onlinebookstore.service.BookService;
import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BookServiceImpl implements BookService {
    private final BookRepository bookRepository;
    private final BookMapper bookMapper;

    @Override
    public BookDto create(CreateBookRequestDto book) {
        return bookMapper.toDto(bookRepository.save(bookMapper.toModel(book)));
    }

    @Override
    public List<BookDto> findAll() {
        return bookRepository.findAll().stream()
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
}
