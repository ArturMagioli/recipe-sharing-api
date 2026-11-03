package com.magioli.recipesharing.auth.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;

public record LoginRequestDto(

        @NotNull(message = "Email is required for login.")
        @Email(message = "It must be a valid email.")
        String email,

        @NotNull(message = "Password is required for login.")
        String password) {
}
