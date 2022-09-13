package com.example.server.controllers.Enums;

import com.example.server.models.Enums.IngredientType;
import com.example.server.models.Enums.Measurement;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class MeasurementController {

    @GetMapping(value = "/measurements")
    public ResponseEntity<Measurement[]> getAllMeasurements(){
        return new ResponseEntity<>(Measurement.values(), HttpStatus.OK);
    }

}
