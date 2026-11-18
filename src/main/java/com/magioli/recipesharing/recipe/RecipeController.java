package com.magioli.recipesharing.recipe;

import com.magioli.recipesharing.recipe.dto.RecipeDto;
import com.magioli.recipesharing.recipe.dto.RecipeRequestDto;
import com.magioli.recipesharing.recipe.service.RecipeService;
import com.magioli.recipesharing.user.dto.RecipeSharingUserDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/recipes")
@RequiredArgsConstructor
public class RecipeController {

    private final RecipeService recipeService;

    @GetMapping
    public ResponseEntity<List<RecipeDto>> findRecipes(
            @RequestParam(name = "username", required = false) String username,
            @RequestParam(name = "title", required = false) String title) {
        List<RecipeDto> recipes = recipeService.getRecipes(username, title);
        return ResponseEntity.ok(recipes);
    }

    @PostMapping
    public ResponseEntity<RecipeDto> create(@RequestBody @Validated RecipeRequestDto newRecipe,
                                            Authentication authentication) {
        RecipeSharingUserDto userAuth = (RecipeSharingUserDto) authentication.getPrincipal();
        String userEmail = userAuth.email();
        RecipeDto createdRecipe = recipeService.create(newRecipe, userEmail);
        return ResponseEntity.ok(createdRecipe);
    }
}
