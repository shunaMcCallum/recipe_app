package com.example.server.controllers;

import com.example.server.models.Recipe;
import com.example.server.repositories.PreparedIngredientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.server.models.PreparedIngredient;

import java.util.List;

@RestController
@RequestMapping("/prepared_ingredients")
@CrossOrigin
public class PreparedIngredientController {

    @Autowired
    PreparedIngredientRepository preparedIngredientRepository;

    @GetMapping(value = "/")
    public ResponseEntity<List<PreparedIngredient>> getAllPreparedIngredients() {
        return new ResponseEntity<>(preparedIngredientRepository.findAll(), HttpStatus.OK);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity getPreparedIngredient(@PathVariable Long id) {
        return new ResponseEntity<>(preparedIngredientRepository.findById(id), HttpStatus.OK);
    }

    @PostMapping(value = "/")
    public ResponseEntity<PreparedIngredient> postPreparedIngredient(@RequestBody PreparedIngredient preparedIngredient){
        preparedIngredient.setCaloriesPerPreparedIngredient();
        preparedIngredientRepository.save(preparedIngredient);
        return new ResponseEntity<>(preparedIngredient, HttpStatus.CREATED);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Recipe> deletePreparedIngredient(@PathVariable Long id) {
        PreparedIngredient found = preparedIngredientRepository.getOne(id);
        preparedIngredientRepository.delete(found);
        return new ResponseEntity<>(null, HttpStatus.OK);
    }
}
