package com.wizzcorp.wizzcoachback.controller;


import com.wizzcorp.wizzcoachback.model.CoachUser;
import com.wizzcorp.wizzcoachback.model.Live;
import com.wizzcorp.wizzcoachback.repository.LiveRepository;
import com.wizzcorp.wizzcoachback.service.LiveService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping(path = "api/v1/lives")
@CrossOrigin
public class LiveController {


    @Autowired
    LiveService liveService;

    @GetMapping
    ResponseEntity<List<Live>> getLives() {
        List<Live> listLives= liveService.findAllLives();

        return ResponseEntity.ok(
                listLives);
    }

    // Renvoie un live via son id

    @GetMapping(value = "{id}")
    ResponseEntity<List<Live>> getLivesById(@PathVariable("id") int id
    ) {
        List<Live> listLives= liveService.findLiveById(id);

        return ResponseEntity.ok(
                listLives

        );
    }

    /*POST Live*/
    @PostMapping
    public ResponseEntity<Void> postLive(@RequestBody Live live) {
        liveService.postLive(live);
        return new ResponseEntity<>(null, HttpStatus.CREATED);
    }

    @PostMapping("/{{coachId}}/coachpost")
    public ResponseEntity<Void> postLiveByCoachId(@RequestBody Live live ,
                                                  @PathVariable(value ="coachId") CoachUser coachId
    ) {
        live.setAuteur(coachId);
        liveService.postLive(live);

        return new ResponseEntity<>(null, HttpStatus.CREATED);

}
/*
    @GetMapping(value = "{coachId}/auteur" )
    public ResponseEntity<List<Live>> getLivesByCoachId(@PathVariable int coachId) {
        return ResponseEntity.ok(
             /*   liveService.getlivesByCoachIdServ(coachId));
    }
*/
}
