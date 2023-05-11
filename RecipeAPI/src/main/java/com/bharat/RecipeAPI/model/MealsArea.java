package com.bharat.RecipeAPI.model;

import java.util.List;

public class MealsArea {
    private List<RecipeArea> meals;

    public MealsArea() {
    }

    public MealsArea(List<RecipeArea> meals) {
        this.meals = meals;
    }

    public List<RecipeArea> getMeals() {
        return meals;
    }

    public void setMeals(List<RecipeArea> meals) {
        this.meals = meals;
    }
}
