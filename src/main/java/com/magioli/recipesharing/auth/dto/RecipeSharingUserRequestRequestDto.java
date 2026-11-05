package com.magioli.recipesharing.auth.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record RecipeSharingUserRequestRequestDto(

        @NotBlank(message = "Username must be provided.")
        @Size(min = 3, max = 255, message = "username must have between 3 and 255 letters")
        String username,

        @NotBlank(message = "Password must be provided.")
        @Size(max = 255, message = "password must have between 5 and 255 letters")
        String password,

        @NotBlank(message = "Email must be provided.")
        @Email(message = "Invalid email provided.")
        @Size(max = 255, message = "email must have between 3 and 255 letters")
        String email
) {
}
