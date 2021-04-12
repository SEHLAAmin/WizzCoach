package com.wizzcorp.wizzcoachback.controller;


import com.wizzcorp.wizzcoachback.model.Category;
import com.wizzcorp.wizzcoachback.model.CoachUser;
import com.wizzcorp.wizzcoachback.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/category")
@CrossOrigin
public class CategoryController {

    @Autowired
CategoryRepository categoryRepository;

    @PostMapping("/createCategory")
    public ResponseEntity<?> postCategory(@RequestBody Category category) {
        categoryRepository.save(category);
        return new ResponseEntity<>( null , HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<?> getCategory() {


        return new ResponseEntity<>(  categoryRepository.findAll() , HttpStatus.OK);

    }

    @PutMapping
    public ResponseEntity<Void> modifyCategory(@RequestBody Category category) {
        categoryRepository.save(category);
        return new ResponseEntity<>(null, HttpStatus.OK);
    }


}
