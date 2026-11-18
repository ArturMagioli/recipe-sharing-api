package com.magioli.recipesharing.recipe.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

public record RecipeRequestDto(

        @NotBlank(message = "Title must not be empty")
        String title,

        String description,

        @NotBlank(message = "Ingredients must not be empty")
        String ingredients,

        @NotBlank(message = "Instructions must not be empty")
        String instructions,

        @Min(value = 1, message = "The number of servings must be greater than zero")
        Integer servings
) {
}
