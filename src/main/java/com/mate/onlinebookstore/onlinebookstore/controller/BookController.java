package com.mate.onlinebookstore.onlinebookstore.controller;

import com.mate.onlinebookstore.onlinebookstore.dto.BookDto;
import com.mate.onlinebookstore.onlinebookstore.dto.BookSearchParameters;
import com.mate.onlinebookstore.onlinebookstore.dto.CreateBookRequestDto;
import com.mate.onlinebookstore.onlinebookstore.service.book.BookService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "Online Book Store", description = "Endpoints for managing books")
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/books")
public class BookController {

    private final BookService bookService;

    @GetMapping
    @Operation(summary = "Get all books",
            description = "Get a list of all available books")
    private List<BookDto> getAll(Pageable pageable) {
        return bookService.findAll(pageable);
    }

    @GetMapping("/search")
    @Operation(summary = "Get list of books by parameters",
            description = "Get list of books by parameters")
    public List<BookDto> searchBooks(BookSearchParameters searchParameters) {
        return bookService.search(searchParameters);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get a book by id",
            description = "Get a book by id if available")
    public BookDto getBookById(@PathVariable Long id) {
        return bookService.findById(id);
    }

    @PostMapping
    @Operation(summary = "Create/Add a book",
            description = "Create/Add a new book")
    public BookDto createBook(@RequestBody @Valid CreateBookRequestDto bookRequestDto) {
        return bookService.create(bookRequestDto);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Update a book",
            description = "Update a book if available")
    public BookDto updateBook(@PathVariable Long id,
                              @RequestBody CreateBookRequestDto bookRequestDto) {
        return bookService.update(id, bookRequestDto);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    @Operation(summary = "Delete a book",
            description = "Delete a book by id if available")
    public void deleteBook(@PathVariable Long id) {
        bookService.deleteById(id);
    }
}
