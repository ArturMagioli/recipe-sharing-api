package com.magioli.recipesharing.entities;

import com.magioli.recipesharing.enums.IngredientUnit;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.math.BigDecimal;

@Entity
@Table(name = "ingredients")
@Getter @Setter
@NoArgsConstructor
public class Ingredient extends BaseEntity{

    @NotNull
    @Column(name = "ingredient_value", precision = 5, scale = 2, nullable = false)
    private BigDecimal ingredientValue;

    @NotNull
    @Column(name = "unit", nullable = false)
    @Enumerated(EnumType.STRING)
    private IngredientUnit unit;

    @NotNull
    @Column(name = "ingredient_type", length = 60, nullable = false)
    private String ingredientType;

    @NotNull
    @JoinColumn(name = "recipe_id", nullable = false)
    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Recipe recipe;

    public Ingredient(BigDecimal value, IngredientUnit unit, String type, Recipe recipe) {
        this.ingredientValue = value;
        this.unit = unit;
        this.ingredientType = type;
        this.recipe = recipe;
    }
}
