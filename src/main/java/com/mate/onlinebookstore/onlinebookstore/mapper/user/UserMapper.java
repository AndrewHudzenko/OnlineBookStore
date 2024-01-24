package com.mate.onlinebookstore.onlinebookstore.mapper.user;

import com.mate.onlinebookstore.onlinebookstore.config.MapperConfig;
import com.mate.onlinebookstore.onlinebookstore.dto.user.UserRegistrationRequestDto;
import com.mate.onlinebookstore.onlinebookstore.dto.user.UserResponseDto;
import com.mate.onlinebookstore.onlinebookstore.model.User;
import org.mapstruct.Mapper;

@Mapper(config = MapperConfig.class)
public interface UserMapper {
    UserResponseDto toDto(User user);

    User toModel(UserRegistrationRequestDto requestDto);

}
