package com.wizzCoachcorp.wizzcoach.controller;


import com.wizzCoachcorp.wizzcoach.model.Abonnement;
import com.wizzCoachcorp.wizzcoach.model.Coach;
import com.wizzCoachcorp.wizzcoach.model.User;
import com.wizzCoachcorp.wizzcoach.repository.AbonnementRepository;
import com.wizzCoachcorp.wizzcoach.repository.CoachUserRepository;
import com.wizzCoachcorp.wizzcoach.repository.UserRepository;
import com.wizzCoachcorp.wizzcoach.service.AbonnementService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.Optional;

@AllArgsConstructor
@RestController
@RequestMapping(path = "api/v1/abo")
@CrossOrigin
public class AbonnementController {

    AbonnementRepository abonnementRepository;
    AbonnementService abonnementService;
    CoachUserRepository coachUserRepository;
    UserRepository userRepository;
    @PostMapping
    public ResponseEntity<Void> postFollowing(@RequestBody Abonnement abonnement) {
        abonnementRepository.save(abonnement);
        return new ResponseEntity<>(null, HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<Void> updateFollowing(@RequestBody Abonnement abonnement) {
        abonnementRepository.save(abonnement);
        return new ResponseEntity<>(null, HttpStatus.OK);
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Void> deleteFollowing(@PathVariable("id") int id) {
        abonnementRepository.deleteById(id);
        return new ResponseEntity<>(null, HttpStatus.OK);
    }

    @PostMapping(path = "coach/{coachId}/user/{userId}")
    public ResponseEntity<Abonnement> MakeFollowingByID(@PathVariable("coachId") int coach_id ,
                                                         @PathVariable("userId") int user_id) {
            Coach coach = new Coach();
            User user = new User();
        Abonnement abone = new Abonnement();
      abone.setId(coach.getId(coach_id));
      abone.setId(user.getId(user_id));
        abonnementRepository.save(abone);
            if(abone == null) {
                return ResponseEntity.notFound().build();
            } /*else {
        return new ResponseEntity<>(null, HttpStatus.CREATED);}*/
        return ResponseEntity.ok().body(abone);
    }
}
