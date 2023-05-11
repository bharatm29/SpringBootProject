package com.bharat.RecipeAPI.model;

import java.util.List;

public class MealsCat {
    private List<RecipeCat> meals;

    public MealsCat() {
    }

    public MealsCat(List<RecipeCat> meals) {
        this.meals = meals;
    }

    public List<RecipeCat> getMeals() {
        return meals;
    }

    public void setMeals(List<RecipeCat> meals) {
        this.meals = meals;
    }
}
