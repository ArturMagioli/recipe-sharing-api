package com.magioli.recipesharing.recipe.service.impl;

import com.magioli.recipesharing.constants.ApplicationConstants;
import com.magioli.recipesharing.entities.Recipe;
import com.magioli.recipesharing.entities.RecipeSharingUser;
import com.magioli.recipesharing.exception.custom.ResourceNotFoundException;
import com.magioli.recipesharing.recipe.dto.RecipeDto;
import com.magioli.recipesharing.recipe.dto.RecipeRequestDto;
import com.magioli.recipesharing.recipe.service.RecipeService;
import com.magioli.recipesharing.repositories.RecipeRepository;
import com.magioli.recipesharing.repositories.RecipeSharingUserRepository;
import com.magioli.recipesharing.util.ClassConverter;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class RecipeServiceImpl implements RecipeService {

    private final RecipeRepository recipeRepository;
    private final RecipeSharingUserRepository userRepository;
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

    @Transactional
    @Override
    public RecipeDto create(RecipeRequestDto newRecipe, String email) {
        if (!usesStandardMetricalSystem(newRecipe.ingredients())) {
            throw new BadCredentialsException("Invalid format for ingredients" +
                    " Use the valid format as follows: value unit type");
        }
        RecipeSharingUser user = userRepository.findByEmail(email)
                .orElseThrow(() -> new ResourceNotFoundException("User not found with email: " + email));
        Recipe recipe = convertoRecipeDtoToEntity(newRecipe);
        recipe.createIngredientList();
        user.addRecipe(recipe);
        return convertToDto(recipe);
    }

    //8 pcs egg,0.05 l milk,1 dash salt
    private boolean usesStandardMetricalSystem(String ingredients) {
        String[] ingredientArray = ingredients.split(",");
        List<String> standardUnits = ApplicationConstants.standardUnits;
        for(String ingredient : ingredientArray) {
            String unit = ingredient.split(" ")[1];
            if (!standardUnits.contains(unit)) {
                return false;
            }
        }
        return true;
    }

    private Recipe convertoRecipeDtoToEntity(RecipeRequestDto recipeDto) {
        return new Recipe.RecipeBuilder()
                .title(recipeDto.title())
                .description(recipeDto.description())
                .ingredients(recipeDto.ingredients())
                .instructions(recipeDto.instructions())
                .servings(recipeDto.servings())
                .withoutUser()
                .build();
    }

    private RecipeDto convertToDto(Recipe recipe) {
        return new RecipeDto(recipe.getTitle(), recipe.getDescription(), recipe.getIngredients(),
                recipe.getInstructions(), recipe.getServings(), converter.convertUserToDto(recipe.getUser()));
    }
}
