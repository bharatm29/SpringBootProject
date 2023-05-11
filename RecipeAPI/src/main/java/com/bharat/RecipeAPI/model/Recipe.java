package com.bharat.RecipeAPI.model;

import java.util.HashMap;
import java.util.Map;

public class Recipe{
    private String dishId, dishName, category, area, instructions;
    private Map<String, String> ingredients;

    public Recipe() {}

    public Recipe(String dishId, String dishName) {
        this.dishId = dishId;
        this.dishName = dishName;
    }

    public Recipe(String dishId, String dishName, String category, String area, String instructions, Map<String, String> ingredients) {
        this.dishId = dishId;
        this.dishName = dishName;
        this.category = category;
        this.area = area;
        this.instructions = instructions;
        this.ingredients = ingredients;
    }

    public Recipe makeRecipe(RecipeUtil recipeUtil){
        Recipe recipe = new Recipe();
        recipe.setDishId(recipeUtil.getIdMeal());
        recipe.setDishName(recipeUtil.getStrMeal());
        recipe.setCategory(recipeUtil.getStrCategory());
        recipe.setArea(recipeUtil.getStrArea());
        recipe.setInstructions(recipeUtil.getStrInstructions());
        recipe.setIngredients(makeIngredients(recipeUtil));

        return recipe;
    }
    private Map<String, String> makeIngredients(RecipeUtil recipeUtil){
        Map<String, String> ingredients = new HashMap<>();
        ingredients.put(recipeUtil.getStrIngredient1(), recipeUtil.getStrMeasure1());
        ingredients.put(recipeUtil.getStrIngredient2(), recipeUtil.getStrMeasure2());
        ingredients.put(recipeUtil.getStrIngredient3(), recipeUtil.getStrMeasure3());
        ingredients.put(recipeUtil.getStrIngredient4(), recipeUtil.getStrMeasure4());
        ingredients.put(recipeUtil.getStrIngredient5(), recipeUtil.getStrMeasure5());
        ingredients.put(recipeUtil.getStrIngredient6(), recipeUtil.getStrMeasure6());
        return ingredients;
    }
    public String getDishId() {
        return dishId;
    }

    public void setDishId(String dishId) {
        this.dishId = dishId;
    }

    public String getDishName() {
        return dishName;
    }

    public void setDishName(String dishName) {
        this.dishName = dishName;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getInstructions() {
        return instructions;
    }

    public void setInstructions(String instructions) {
        this.instructions = instructions;
    }

    public Map<String, String> getIngredients() {
        return ingredients;
    }

    public void setIngredients(Map<String, String> ingredients) {
        this.ingredients = ingredients;
    }
}
