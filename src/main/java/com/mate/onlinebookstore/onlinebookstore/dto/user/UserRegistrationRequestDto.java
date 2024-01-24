package com.mate.onlinebookstore.onlinebookstore.dto.user;

import com.mate.onlinebookstore.onlinebookstore.annotation.FieldMatch;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;

@FieldMatch(first = "password", second = "repeatPassword")
public record UserRegistrationRequestDto(
        @NotBlank
        @Length(max = 20)
        String email,
        @NotNull
        String password,
        @NotNull
        String repeatPassword,
        @NotNull
        String firstName,
        @NotNull
        @Length(max = 50)
        String lastName
) {
}
