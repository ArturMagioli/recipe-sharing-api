package com.magioli.recipesharing.user.dto;

import com.magioli.recipesharing.entities.Recipe;

import java.util.List;

public record RecipeSharingUserDto(String username, String email, List<Recipe> recipes) {
}
