package com.magioli.recipesharing.entities;

import com.magioli.recipesharing.enums.IngredientUnit;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "recipes")
@Getter @Setter
@NoArgsConstructor
@NamedQueries({
        @NamedQuery(name = "Recipe.findRecipeByUsernameLikeAndTitleLike",
                    query = "SELECT r FROM Recipe r " +
                            "WHERE UPPER(r.user.username) LIKE CONCAT('%', UPPER(:username), '%') " +
                            "AND UPPER(r.title) LIKE CONCAT('%', UPPER(:title), '%')"),
        @NamedQuery(name = "Recipe.findRecipeByUsernameLike",
                    query = "SELECT r FROM Recipe r " +
                            "WHERE UPPER(r.user.username) LIKE CONCAT('%', UPPER(:username), '%')")
})
public class Recipe extends BaseEntity{

    @Column(name = "title", length = 50, nullable = false)
    private String title;

    @Lob
    @Column(name = "description")
    private String description;

    @NotBlank
    @Lob
    @Column(name = "ingredients", nullable = false)
    private String ingredients;

    @NotBlank
    @Lob
    @Column(name = "instructions", nullable = false)
    private String instructions;

    @Column(name = "servings")
    private Integer servings;

    @JoinColumn(name = "user_id", nullable = false)
    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    RecipeSharingUser user;

    @Setter(AccessLevel.NONE)
    @OneToMany(mappedBy = "recipe", fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = true)
    private final List<Ingredient> ingredientList = new ArrayList<>();

    public Recipe(RecipeBuilder recipeBuilder) {
        this.title = recipeBuilder.title;
        this.description = recipeBuilder.description;
        this.ingredients = recipeBuilder.ingredients;
        this.instructions = recipeBuilder.instructions;
        this.servings = recipeBuilder.servings;
        this.user = recipeBuilder.user;
    }

    public void createIngredientList() {
        String[] ingredientArray = ingredients.split(",");
        for (String ingredient : ingredientArray) {
            String[] ingredientDetails = ingredient.split(" ");
            String type = getType(ingredientDetails);
            Ingredient newIngredient = new Ingredient(BigDecimal.valueOf(Double.valueOf(ingredientDetails[0])),
                    IngredientUnit.valueOf(ingredientDetails[1].toUpperCase()), type);
            this.addIngredient(newIngredient);
        }
    }

    private String getType(String[] ingredientDetails) {
        String type = ingredientDetails[2];
        for (int i = 3; i < ingredientDetails.length; i++) {
            type += " " + ingredientDetails[i];
        }
        return type;
    }

    public void addIngredient(Ingredient ingredient) {
        ingredientList.add(ingredient);
        ingredient.setRecipe(this);
    }

    public static class RecipeBuilder {
        private String title;
        private String description;
        private String ingredients;
        private String instructions;
        private Integer servings;
        private RecipeSharingUser user;

        public RecipeBuilder title(String title) {
            this.title = title;
            return this;
        }

        public RecipeBuilder description(String description) {
            this.description = description;
            return this;
        }

        public RecipeBuilder ingredients(String ingredients) {
            this.ingredients = ingredients;
            return this;
        }

        public RecipeBuilder instructions(String instructions) {
            this.instructions = instructions;
            return this;
        }

        public RecipeBuilder servings(Integer servings) {
            this.servings = servings;
            return this;
        }

        public RecipeBuilder user(RecipeSharingUser user) {
            this.user = user;
            return this;
        }

        public RecipeBuilder withoutUser() {
            this.user = null;
            return this;
        }

        public Recipe build() {
            return new Recipe(this);
        }
    }
}
