package com.magioli.recipesharing.enums;

public enum IngredientUnit {

    G("grams"),
    KG("kilograms"),
    ML("milliliter"),
    L("liter"),
    PC("piece"),
    TSP("teaspoon"),
    TBSP("tablespoon"),
    PINCH("dash");

    private String unit;

    IngredientUnit(String unit) {
        this.unit = unit;
    }

    public String getUnit() {
        return unit;
    }
}
