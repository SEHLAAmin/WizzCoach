package com.wizzCoachcorp.wizzcoach.controller;

import com.wizzCoachcorp.wizzcoach.model.User;
import com.wizzCoachcorp.wizzcoach.repository.UserRepository;

import com.wizzCoachcorp.wizzcoach.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@RestController
@RequestMapping(path = "api/v1/utilisateur")
@CrossOrigin
public class UserController {

    private final UserRepository userRepository;
    private final UserService.UserServiceImpl userService;


    private static  final List<User> ELEVE = Arrays.asList();
    // Renvoie tous nos utilisateurs

    @GetMapping
    ResponseEntity<List<User>> getUtilisateurs() {
        return ResponseEntity.ok(
                userRepository.findAll());
    }

    // Renvoie un item via son id
    @GetMapping(value = "{id}")
    public ResponseEntity<Optional<User>> utilisateurById(@PathVariable int id) {
        return ResponseEntity.ok(
                userRepository.findById(id));
    }

    // Mettre à jour un item déjà existant
    @PutMapping
    public ResponseEntity<Void> updateUtilisateur(@RequestBody User user) {

        userRepository.save(user);
        return new ResponseEntity<>(null, HttpStatus.OK);
    }


    // Supprimer un item via son Id
    @DeleteMapping(value = "{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable int id) {
        userRepository.deleteById(id);
        return new ResponseEntity<>(null, HttpStatus.OK);
    }

    /*POST Utilisateur*/
    @PostMapping
    public ResponseEntity<Void> postUtilisateur(@RequestBody User user) {
        userRepository.save(user);
        return new ResponseEntity<>(null, HttpStatus.CREATED);
    }
}
