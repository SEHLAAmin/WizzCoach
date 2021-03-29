package com.wizzCoachcorp.wizzcoach.controller;


import com.wizzCoachcorp.wizzcoach.model.Coach;
import com.wizzCoachcorp.wizzcoach.model.Live;
import com.wizzCoachcorp.wizzcoach.repository.CoachUserRepository;
import com.wizzCoachcorp.wizzcoach.repository.LiveRepository;
import com.wizzCoachcorp.wizzcoach.service.LiveService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@RestController
@RequestMapping(path = "api/v1/coach/live")
@CrossOrigin
public class LiveController {
    LiveRepository liveRepository;
    LiveService liveService;

    CoachUserRepository coachUserRepository;

    @GetMapping
    ResponseEntity<List<Live>> getLives() {
        List<Live> listUser= liveRepository.findAll();

        return ResponseEntity.ok(
                listUser);
    }

    // Renvoie un item via son id
    @GetMapping(value = "{id}")
    public ResponseEntity<Optional<Live>> liveById(@PathVariable int id) {
        return ResponseEntity.ok(
                liveRepository.findById(id));
    }

    // Mettre à jour un item déjà existant
    @PutMapping
    public ResponseEntity<Void> updateLive(@RequestBody Live live) {

        liveRepository.save(live);
        return new ResponseEntity<>(null, HttpStatus.OK);
    }


    // Supprimer un item via son Id
    @DeleteMapping(value = "{id}")
    public ResponseEntity<Void> deleteliveById(@PathVariable int id) {
        liveRepository.deleteById(id);
        return new ResponseEntity<>(null, HttpStatus.OK);
    }

    /*POST Live*/
    @PostMapping
    public ResponseEntity<Void> postLive(@RequestBody Live live) {
        liveRepository.save(live);
        return new ResponseEntity<>(null, HttpStatus.CREATED);
    }
// Retourn une liste de live selon tels {coachId}
   @GetMapping(value = "{coachId}/auteur" )
    public ResponseEntity<List<Live>> getLivesByCoachId(@PathVariable int coachId) {
        return ResponseEntity.ok(
            liveService.getlivesByCoachIdServ(coachId));
    }

    @PostMapping("/{{coachId}}/coachpost")
    public ResponseEntity<Void> postLiveByCoachId(@RequestBody Live live ,
                                                  @PathVariable(value ="coachId") Coach coachId
    ) {
        live.setAuteur(coachId);
        liveRepository.save(live);

    return new ResponseEntity<>(null, HttpStatus.CREATED);
    }
}
