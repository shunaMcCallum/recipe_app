package com.example.server.controllers;

import com.example.server.repositories.IngredientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.server.models.Ingredient;

import java.util.List;

@RestController
@RequestMapping("/ingredients")
@CrossOrigin
public class IngredientController {

    @Autowired
    IngredientRepository ingredientRepository;

    @GetMapping(value = "/")
    public ResponseEntity<List<Ingredient>> getAllIngredients() {
        return new ResponseEntity<>(ingredientRepository.findAll(), HttpStatus.OK);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity getIngredient(@PathVariable Long id) {
        return new ResponseEntity<>(ingredientRepository.findById(id), HttpStatus.OK);
    }

    @PostMapping(value = "/")
    public ResponseEntity<Ingredient> postIngredient(@RequestBody Ingredient ingredient){
        ingredientRepository.save(ingredient);
        return new ResponseEntity<>(ingredient, HttpStatus.CREATED);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Ingredient> deleteIngredient(@PathVariable Long id) {
        Ingredient found = ingredientRepository.getOne(id);
        ingredientRepository.delete(found);
        return new ResponseEntity<>(null, HttpStatus.OK);
    }
}
