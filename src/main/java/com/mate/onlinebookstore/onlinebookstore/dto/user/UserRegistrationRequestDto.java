package com.mate.onlinebookstore.onlinebookstore.dto.user;

import com.mate.onlinebookstore.onlinebookstore.annotation.FieldMatch;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;

@FieldMatch(first = "password", second = "repeatPassword", message = "Password and repeat password are not equals")
public record UserRegistrationRequestDto(
        @NotBlank
        @Length(max = 20)
        String email,
        @NotNull
        @Length(min = 8, max = 20)
        String password,
        @NotNull
        @Length(min = 8, max = 20)
        String repeatPassword,
        @NotNull
        @Length(min = 2, max = 20)
        String firstName,
        @NotNull
        @Length(min = 2, max = 20)
        String lastName,
        String shippingAddress
) {
}
