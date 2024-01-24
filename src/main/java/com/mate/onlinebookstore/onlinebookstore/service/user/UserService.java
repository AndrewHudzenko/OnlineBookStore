package com.mate.onlinebookstore.onlinebookstore.service.user;

import com.mate.onlinebookstore.onlinebookstore.dto.user.UserRegistrationRequestDto;
import com.mate.onlinebookstore.onlinebookstore.dto.user.UserResponseDto;

public interface UserService {
    UserResponseDto register(UserRegistrationRequestDto requestDto);
}
