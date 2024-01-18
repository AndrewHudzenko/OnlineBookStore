package com.mate.onlinebookstore.onlinebookstore.mapper;

import com.mate.onlinebookstore.onlinebookstore.config.MapperConfig;
import com.mate.onlinebookstore.onlinebookstore.dto.BookDto;
import com.mate.onlinebookstore.onlinebookstore.dto.CreateBookRequestDto;
import com.mate.onlinebookstore.onlinebookstore.model.Book;
import org.mapstruct.Mapper;

@Mapper(config = MapperConfig.class)
public interface BookMapper {
    BookDto toDto(Book book);

    Book toModel(CreateBookRequestDto bookDto);
}
