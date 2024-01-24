package com.mate.onlinebookstore.onlinebookstore.mapper.book;

import com.mate.onlinebookstore.onlinebookstore.config.MapperConfig;
import com.mate.onlinebookstore.onlinebookstore.dto.book.BookDto;
import com.mate.onlinebookstore.onlinebookstore.dto.book.CreateBookRequestDto;
import com.mate.onlinebookstore.onlinebookstore.model.Book;
import org.mapstruct.Mapper;

@Mapper(config = MapperConfig.class)
public interface BookMapper {
    BookDto toDto(Book book);

    Book toModel(CreateBookRequestDto bookDto);
}
