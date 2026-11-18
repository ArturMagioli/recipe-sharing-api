package com.magioli.recipesharing.recipe.service;

import com.magioli.recipesharing.recipe.dto.RecipeDto;
import com.magioli.recipesharing.recipe.dto.RecipeRequestDto;

import java.util.List;

public interface RecipeService {

    List<RecipeDto> getRecipes(String username, String title);
    RecipeDto create(RecipeRequestDto newRecipe, String email);
}
