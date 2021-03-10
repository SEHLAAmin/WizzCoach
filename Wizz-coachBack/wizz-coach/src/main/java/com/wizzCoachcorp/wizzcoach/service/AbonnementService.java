package com.wizzCoachcorp.wizzcoach.service;

import com.wizzCoachcorp.wizzcoach.model.Abonnement;
import com.wizzCoachcorp.wizzcoach.model.Coach;
import com.wizzCoachcorp.wizzcoach.model.User;
import com.wizzCoachcorp.wizzcoach.repository.AbonnementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public interface AbonnementService extends AbonnementRepository {

    @Service
    @Primary
     class AbonnementServiceImpl {

        @Autowired
        AbonnementRepository abonnementRepository;

        public ResponseEntity<Optional<Abonnement>> addUserToCoachListServ(int coachId, int userId) {

            Optional<Abonnement> currentCoach = abonnementRepository.findById(coachId);
            Optional<Abonnement> currentUser = abonnementRepository.findById(userId);
            List<Optional<Abonnement>> listAbonnesDuCoach = new ArrayList<>();
            listAbonnesDuCoach.add(currentUser);

                   return (ResponseEntity<Optional<Abonnement>>) listAbonnesDuCoach;
        }
    }
}