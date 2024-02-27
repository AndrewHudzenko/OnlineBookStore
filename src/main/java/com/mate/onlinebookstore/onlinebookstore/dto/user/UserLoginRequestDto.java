package com.mate.onlinebookstore.onlinebookstore.dto.user;

public record UserLoginRequestDto(
        String email,
        String password
) {
}
