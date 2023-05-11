package com.bharat.RecipeAPI.resources;

import com.bharat.RecipeAPI.model.*;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@RequestMapping("/recipe")
public class RecipeController {
    @Autowired
    private RestTemplate restTemplate;

    @Value("${url.name}")
    private String urlName;

    @Value("${url.category}")
    private String urlCat;

    @Value("${url.area}")
    private String urlArea;

    @GetMapping("/{name}")
    @CircuitBreaker(name = "recipe-name-cb", fallbackMethod = "recipeFallBack")
    public List<Recipe> getRecipeByName(@PathVariable String name){
        Meals meals = restTemplate.getForObject(urlName + name, Meals.class);
        Recipe recipe = new Recipe();

        return meals.getMeals().stream().map(
                recipeUtil -> recipe.makeRecipe(recipeUtil)
        ).toList();
    }

    @GetMapping("/category/{cat}")
    @CircuitBreaker(name = "recipe-cat-cb", fallbackMethod = "recipeCatFallBack")
    public MealsCat getRecipeByCategory(@PathVariable("cat") String category){
        MealsCat mealsCat = restTemplate.getForObject(urlCat + category, MealsCat.class);
        return mealsCat;
    }

    @GetMapping("/area/{area}")
    @CircuitBreaker(name = "recipe-area-cb", fallbackMethod = "recipeAreasFallBack")
    public MealsArea getRecipeByArea(@PathVariable String area){
        MealsArea mealsArea = restTemplate.getForObject(urlArea + area, MealsArea.class);
        return mealsArea;
    }

    public List<Recipe> recipeFallBack(String name, Exception e){
        return List.of(new Recipe("-1", "No recipe Found"));
    }
    public MealsCat recipeCatFallBack(String cat, Exception e){
        List<RecipeCat> defaultRecipe =  List.of(new RecipeCat("-1", "No Recipe found under this category", ""));
        return new MealsCat(defaultRecipe);
    }
    public MealsArea recipeAreasFallBack(String area, Exception e){
        List<RecipeArea> defaultRecipe = List.of(new RecipeArea("-1", "No Recipe found under this area", ""));
        return new MealsArea(defaultRecipe);
    }
}