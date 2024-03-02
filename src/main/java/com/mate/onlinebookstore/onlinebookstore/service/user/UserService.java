package com.mate.onlinebookstore.onlinebookstore.service.user;

import com.mate.onlinebookstore.onlinebookstore.dto.user.UserRegistrationRequestDto;
import com.mate.onlinebookstore.onlinebookstore.dto.user.UserResponseDto;
import com.mate.onlinebookstore.onlinebookstore.exception.RegistrationException;

public interface UserService {
    UserResponseDto register(UserRegistrationRequestDto requestDto) throws RegistrationException;

    UserResponseDto getById(Long id);
}
