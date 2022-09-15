package com.example.server.controllers.Enums;

import com.example.server.models.Enums.Meal;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class MealController {

    @GetMapping(value = "/meal")
    public ResponseEntity<Meal[]> getAllMeals(){
        return new ResponseEntity<>(Meal.values(), HttpStatus.OK);
    }
}
