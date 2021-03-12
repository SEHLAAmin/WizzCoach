package com.wizzCoachcorp.wizzcoach.controller;


import com.wizzCoachcorp.wizzcoach.model.Coach;
import com.wizzCoachcorp.wizzcoach.repository.AbonnementRepository;
import com.wizzCoachcorp.wizzcoach.repository.CoachUserRepository;
import com.wizzCoachcorp.wizzcoach.service.AbonnementService;
import com.wizzCoachcorp.wizzcoach.service.CoachUserService;
import com.wizzCoachcorp.wizzcoach.service.UserService;
import lombok.AllArgsConstructor;
import org.hibernate.exception.DataException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@RestController
@RequestMapping(path = "api/v1/coach")
@CrossOrigin
public class CoachUserController {

    CoachUserRepository coachUserRepository;
    CoachUserService.CoachUserServiceImpl coachUserServiceImpl;
    UserService.UserServiceImpl userServiceimpl;

    AbonnementRepository abonnementRepository;
    AbonnementService.AbonnementServiceImpl abonnementService;


    @PostMapping
    public ResponseEntity<Void> postUtilisateur(@RequestBody Coach coach) {
        coachUserRepository.save(coach);
        return new ResponseEntity<>(null, HttpStatus.CREATED);
    }

    //Get all Coach
    @GetMapping
    ResponseEntity<List<Coach>> getAllCoach() {
        return ResponseEntity.ok(
                coachUserRepository.findAll());
    }

    // get juste un coach
    @GetMapping(value = "{id}")
    public ResponseEntity<Optional<Coach>> coachById(@PathVariable int id) {
        return ResponseEntity.ok()
                .body(

                        coachUserRepository.findById(id)
                );
    }

    @PutMapping
    public ResponseEntity<Void> updateUtilisateur(@RequestBody Coach coach) {
        coachUserRepository.save(coach);
        return new ResponseEntity<>(null, HttpStatus.OK);
    }

}