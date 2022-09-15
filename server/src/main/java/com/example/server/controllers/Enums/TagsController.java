package com.example.server.controllers.Enums;

import com.example.server.models.Enums.Tags;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class TagsController {

    @GetMapping(value = "/tags")
    public ResponseEntity<Tags[]> getAllTags(){
        return new ResponseEntity<>(Tags.values(), HttpStatus.OK);
    }
}
