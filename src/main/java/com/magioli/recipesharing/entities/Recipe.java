package com.magioli.recipesharing.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "recipes")
@Getter @Setter
public class Recipe extends BaseEntity{

    @Column(name = "title", length = 50, nullable = false)
    private String title;

    @NotBlank
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
    private int servings;

    @JoinColumn(name = "user_id", nullable = false)
    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    RecipeSharingUser user;

    @Setter(AccessLevel.NONE)
    @OneToMany(mappedBy = "recipe", fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = true)
    private final List<Ingredient> ingredientsList = new ArrayList<>();

    public Recipe(RecipeBuilder recipeBuilder) {
        this.title = recipeBuilder.title;
        this.description = recipeBuilder.description;
        this.ingredients = recipeBuilder.ingredients;
        this.instructions = recipeBuilder.instructions;
        this.servings = recipeBuilder.servings;
        this.user = recipeBuilder.user;
    }

    public static class RecipeBuilder {
        private String title;
        private String description;
        private String ingredients;
        private String instructions;
        private int servings;
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

        public RecipeBuilder servings(int servings) {
            this.servings = servings;
            return this;
        }

        public RecipeBuilder user(RecipeSharingUser user) {
            this.user = user;
            return this;
        }

        public Recipe build() {
            return new Recipe(this);
        }
    }
}
