package com.magioli.recipesharing.recipe.service.impl;

import com.magioli.recipesharing.entities.Recipe;
import com.magioli.recipesharing.recipe.dto.RecipeDto;
import com.magioli.recipesharing.recipe.service.RecipeService;
import com.magioli.recipesharing.repositories.RecipeRepository;
import com.magioli.recipesharing.util.ClassConverter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class RecipeServiceImpl implements RecipeService {

    private final RecipeRepository recipeRepository;
    private final ClassConverter converter;

    @Override
    public List<RecipeDto> getRecipes(String username, String title) {
        List<Recipe> recipes;
        if (username != null && title != null) {
            recipes = recipeRepository.findRecipeByUsernameLikeAndTitleLike(username, title);
        } else if (username != null) {
            recipes = recipeRepository.findRecipeByUsernameLike(username);
        } else if (title != null) {
            recipes = recipeRepository.findRecipeByTitleContainingIgnoreCase(title);
        } else {
            recipes = recipeRepository.findAll();
        }

        return recipes.stream().map(this::convertToDto).toList();
    }

    private RecipeDto convertToDto(Recipe recipe) {
        return new RecipeDto(recipe.getTitle(), recipe.getDescription(), recipe.getIngredients(),
                recipe.getInstructions(), recipe.getServings(), converter.convertUserToDto(recipe.getUser()));
    }
}
