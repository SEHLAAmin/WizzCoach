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

import java.text.SimpleDateFormat;
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

    @PostMapping(path = "coach/{coach_Id}/utilisateur/{user_id}")
    public ResponseEntity<Abonnement> MakeFollowingByID(@PathVariable("coach_Id") Coach coach_id ,
                                                         @PathVariable("user_id") User user_id) {
            Coach coach = new Coach();
            User user = new User();
        Abonnement abonnement = new Abonnement();


        SimpleDateFormat formatter= new SimpleDateFormat("yyyy-MM-dd 'at' HH:mm:ss z");
        Date date = new Date(System.currentTimeMillis());
        System.out.println(formatter.format(date));
      abonnement.setInscription(date);
      abonnement.setEleve(user_id);
      abonnement.setCoach(coach_id);
        abonnementRepository.save(abonnement);
            if(abonnement == null) {
                return ResponseEntity.notFound().build();
            } /*else {
        return new ResponseEntity<>(null, HttpStatus.CREATED);}*/
        return ResponseEntity.ok().body(abonnement);
    }
}
