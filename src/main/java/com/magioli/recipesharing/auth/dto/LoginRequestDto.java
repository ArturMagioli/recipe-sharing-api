package com.magioli.recipesharing.auth.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record LoginRequestDto(

        @NotBlank(message = "Email is required for login.")
        @Email(message = "It must be a valid email.")
        String email,

        @NotBlank(message = "Password is required for login.")
        String password) {
}
