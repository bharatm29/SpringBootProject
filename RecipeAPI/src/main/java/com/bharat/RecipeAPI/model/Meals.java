package com.bharat.RecipeAPI.model;

import java.util.List;

public class Meals {
    private List<RecipeUtil> meals;

    public Meals() {
    }

    public Meals(List<RecipeUtil> meals) {
        this.meals = meals;
    }

    public List<RecipeUtil> getMeals() {
        return meals;
    }

    public void setMeals(List<RecipeUtil> meals) {
        this.meals = meals;
    }
}
