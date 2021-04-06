package com.wizzcorp.wizzcoachback.controller;


import com.wizzcorp.wizzcoachback.model.Account;
import com.wizzcorp.wizzcoachback.model.CoachUser;
import com.wizzcorp.wizzcoachback.model.User;
import com.wizzcorp.wizzcoachback.service.AbonnementService;
import com.wizzcorp.wizzcoachback.service.AccountService;
import com.wizzcorp.wizzcoachback.service.CoachUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/coach")
@CrossOrigin
public class CoachUserController {


    @Autowired
    private CoachUserService coachUserService;

     @Autowired
    private AbonnementService abonnementService;

    @PostMapping("/createCoach")
    public String postAccount(@RequestBody CoachUser coachUser) {
        coachUserService.saveCoachUser(coachUser);
        return "OK";
    }

    @GetMapping
    public ResponseEntity<?> getAccount() {
        return new ResponseEntity<>(

                coachUserService.coachList(), HttpStatus.OK
        );
    }

    @PutMapping
    public ResponseEntity<Void> modifyAccount(@RequestBody CoachUser coachUser) {
        coachUserService.saveCoachUser(coachUser);
        return new ResponseEntity<>(null, HttpStatus.OK);
    }


    @DeleteMapping(value = "{id}")
    public ResponseEntity<Void> deleteCoachById(@PathVariable int id) {
        coachUserService.deleteCoach(id);
        return new ResponseEntity<>(null, HttpStatus.OK);
    }


    @RequestMapping(value ="" , method = RequestMethod.GET , params = {"eleve_id"})
    ResponseEntity<List<CoachUser>> getAlLCoachsByEleveId(
            @RequestParam(name = "eleve_id") int eleveId
    ) {
        return ResponseEntity.ok(
                abonnementService.findCoachUserByEleveId(eleveId)
        );
    }

}
