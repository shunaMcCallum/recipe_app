package com.example.server.controllers.Enums;

import com.example.server.models.Enums.IngredientType;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class IngredientTypeController {

    @GetMapping(value = "/ingredient_types")
    public ResponseEntity<IngredientType[]> getAllIngredientTypes(){
        return new ResponseEntity<>(IngredientType.values(), HttpStatus.OK);
    }

}
