package com.wizzcorp.wizzcoachback.controller;

import com.wizzcorp.wizzcoachback.model.Abonnement;
import com.wizzcorp.wizzcoachback.model.Account;
import com.wizzcorp.wizzcoachback.model.CoachUser;
import com.wizzcorp.wizzcoachback.model.User;
import com.wizzcorp.wizzcoachback.repository.AbonnementRepository;
import com.wizzcorp.wizzcoachback.service.AbonnementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/abo")
@CrossOrigin
public class AbonnementController {

    @Autowired
    AbonnementService abonnementService;
    @Autowired
    AbonnementRepository abonnementRepository;

    @GetMapping
    ResponseEntity<List<Abonnement>> getAllabonnement() {
        List<Abonnement> listRelation= abonnementRepository.findAll();

        return ResponseEntity.ok(
                listRelation
        );
    }


    @PostMapping("/createAbonnement")
    public String postAccount(@RequestBody Abonnement abonnement) {
        abonnementRepository.save(abonnement);
        return "OK";
    }

    @RequestMapping(value ="" , method = RequestMethod.POST , params = {"eleve_id"} )
    public String postAbonnementByIds(@RequestBody Abonnement abonnement) {
        abonnementRepository.save(abonnement);
        return "OK";
    }


}
