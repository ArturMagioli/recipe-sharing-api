package com.magioli.recipesharing.recipe.dto;

import com.magioli.recipesharing.user.dto.RecipeSharingUserDto;

public record RecipeDto(
        String title,
        String description,
        String ingredients,
        String instructions,
        int servings,
        RecipeSharingUserDto userDto
) {
}
