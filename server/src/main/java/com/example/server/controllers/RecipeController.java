package com.example.server.controllers;

import com.example.server.models.Ingredient;
import com.example.server.models.PreparedIngredient;
import com.example.server.models.Recipe;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.config.ConfigDataResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.server.repositories.RecipeRepository;

import javax.xml.ws.Response;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/recipes")
@CrossOrigin

public class RecipeController {

    @Autowired
    RecipeRepository recipeRepository;

    @GetMapping(value = "/")
    public ResponseEntity<List<Recipe>> getRecipes(
        @RequestParam(name="name", required=false) String name)
    {
        if (name != null) {
            return new ResponseEntity<>(recipeRepository.findByName(name), HttpStatus.OK);
        }
        return new ResponseEntity<>(recipeRepository.findAll(), HttpStatus.OK);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity getRecipe(@PathVariable Long id) {
        return new ResponseEntity<>(recipeRepository.findById(id), HttpStatus.OK);
    }

    @PostMapping(value = "/")
    public ResponseEntity<Recipe> postRecipe(@RequestBody Recipe recipe){
//        recipe.setCalories(recipe.calculateTotalCalories());
        recipeRepository.save(recipe);
        return new ResponseEntity<>(recipe, HttpStatus.CREATED);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Recipe> deleteRecipe(@PathVariable Long id) {
        Recipe found = recipeRepository.getOne(id);
        recipeRepository.delete(found);
        return new ResponseEntity<>(null, HttpStatus.OK);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Recipe> putRecipe(@PathVariable Long id, @RequestBody Recipe recipe) {
        Recipe found = recipeRepository.getOne(id);

        found.setName(recipe.getName());
        found.setMeal(recipe.getMeal());
        found.setPortions(recipe.getPortions());
        found.setCooking_time(recipe.getCooking_time());
        found.setIngredients(recipe.getIngredients());
        found.setTags(recipe.getTags());
        found.setInstructions(recipe.getInstructions());
        found.setCalories(recipe.getCalories());
//        found.setCalories(recipe.calculateTotalCalories());

        final Recipe updatedRecipe = recipeRepository.save(found);
        return ResponseEntity.ok(updatedRecipe);
    }

//    @GetMapping(value = "/name")
//    public ResponseEntity<Recipe> getRecipeByName(
//            @RequestParam(name="name", required = false) String name
//    ) {
//        return new ResponseEntity<>(recipeRepository.findRecipeByName(String.valueOf(name)), HttpStatus.OK);
//    }

}
