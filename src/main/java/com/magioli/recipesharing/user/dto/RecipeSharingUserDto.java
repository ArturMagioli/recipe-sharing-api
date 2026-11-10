package com.magioli.recipesharing.user.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record RecipeSharingUserDto(

        @NotBlank(message = "Username is required for login.")
        String username,

        @NotBlank(message = "Email is required for login.")
        @Email(message = "It must be a valid email.")
        String email
) {
}
