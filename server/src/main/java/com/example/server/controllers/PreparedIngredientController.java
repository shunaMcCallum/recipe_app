package com.example.server.controllers;

import com.example.server.repositories.PreparedIngredientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.server.models.PreparedIngredient;

import java.util.List;

@RestController
public class PreparedIngredientController {

    @Autowired
    PreparedIngredientRepository preparedIngredientRepository;

    @GetMapping(value = "/prepared_ingredients")
    public ResponseEntity<List<PreparedIngredient>> getAllPreparedIngredients() {
        return new ResponseEntity<>(preparedIngredientRepository.findAll(), HttpStatus.OK);
    }
}
