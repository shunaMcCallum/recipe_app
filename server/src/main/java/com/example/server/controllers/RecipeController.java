package com.example.server.controllers;

import com.example.server.models.Ingredient;
import com.example.server.models.Recipe;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.server.repositories.RecipeRepository;

import java.util.List;

@RestController
@RequestMapping("/recipes")
@CrossOrigin

public class RecipeController {

    @Autowired
    RecipeRepository recipeRepository;

    @GetMapping(value = "/")
    public ResponseEntity<List<Recipe>> getAllRecipes(){
        return new ResponseEntity<>(recipeRepository.findAll(), HttpStatus.OK);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity getRecipe(@PathVariable Long id) {
        return new ResponseEntity<>(recipeRepository.findById(id), HttpStatus.OK);
    }

    @PostMapping(value = "/")
    public ResponseEntity<Recipe> postRecipe(@RequestBody Recipe recipe){
        recipeRepository.save(recipe);
        return new ResponseEntity<>(recipe, HttpStatus.CREATED);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Recipe> deleteRecipe(@PathVariable Long id) {
        Recipe found = recipeRepository.getOne(id);
        recipeRepository.delete(found);
        return new ResponseEntity<>(null, HttpStatus.OK);
    }

}
