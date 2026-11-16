package com.magioli.recipesharing.recipe;

import com.magioli.recipesharing.recipe.dto.RecipeDto;
import com.magioli.recipesharing.recipe.service.RecipeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
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

}
