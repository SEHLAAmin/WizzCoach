package com.wizzCoachcorp.wizzcoach.controller;


import com.wizzCoachcorp.wizzcoach.model.Categorie;
import com.wizzCoachcorp.wizzcoach.model.Coach;
import com.wizzCoachcorp.wizzcoach.repository.CategorieRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping(path = "api/v1/live/categorie")
@CrossOrigin
public class CategorieController {
CategorieRepository categorieRepository;

//post
    @PostMapping
    public ResponseEntity<Void> postCategorie(@RequestBody Categorie categorie) {
        categorieRepository.save(categorie);
        return new ResponseEntity<>(null, HttpStatus.CREATED);
    }

    //get all
    @GetMapping
    ResponseEntity<Iterable<Categorie>> getAllCate() {
        return ResponseEntity.ok(
                categorieRepository.findAll());
    }
//retourne tels categories selon tels libelle (pour barre de recherche)
    @GetMapping("/categorie/{libelle}")

    ResponseEntity<Categorie>getAllCateByWord(@PathVariable String libelle) {
        return ResponseEntity.ok(
                categorieRepository.findCategorieBylibelle(libelle));
    }
}
