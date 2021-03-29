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
import java.util.List;
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

    //post un abonnement en Json
    @PostMapping
    public ResponseEntity<Void> postFollowing(@RequestBody Abonnement abonnement) {
        abonnementRepository.save(abonnement);
        return new ResponseEntity<>(null, HttpStatus.CREATED);
    }


//modifier
    @PutMapping
    public ResponseEntity<Void> updateFollowing(@RequestBody Abonnement abonnement) {
        abonnementRepository.save(abonnement);
        return new ResponseEntity<>(null, HttpStatus.OK);
    }


    //retourne toute les liaison Abonnement effectuer
    @GetMapping
    ResponseEntity<List<Abonnement>> getFollow() {
        return ResponseEntity.ok(
                abonnementRepository.findAll());
    }


    // deleteby Id
    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Void> deleteFollowing(@PathVariable("id") int id) {
        abonnementRepository.deleteById(id);
        return new ResponseEntity<>(null, HttpStatus.OK);
    }


    //post une liaison via les FK des Account(user , coach) dans abonnement
    @PostMapping(path = "coach/{coach_Id}/utilisateur/{user_id}")
    public ResponseEntity<Abonnement> MakeFollowingByID(@PathVariable("coach_Id") Coach coach_id ,
                                                         @PathVariable("user_id") User user_id) {

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
    // Retourne toute les liaison reliés a tels {CoachId}
    @GetMapping(path = "/coach/{coachId}/abo")
    ResponseEntity<List<Abonnement>> getFollowerOfCoachById( @PathVariable int coachId) {
        return ResponseEntity.ok(
                coachUserRepository.findById(coachId).get().getAbonnements() );
    }
}
