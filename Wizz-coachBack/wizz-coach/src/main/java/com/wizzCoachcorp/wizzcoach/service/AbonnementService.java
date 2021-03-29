package com.wizzCoachcorp.wizzcoach.service;

import com.wizzCoachcorp.wizzcoach.model.Abonnement;
import com.wizzCoachcorp.wizzcoach.model.Coach;
import com.wizzCoachcorp.wizzcoach.model.User;
import com.wizzCoachcorp.wizzcoach.repository.AbonnementRepository;
import com.wizzCoachcorp.wizzcoach.repository.CoachUserRepository;
import com.wizzCoachcorp.wizzcoach.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

public interface AbonnementService extends AbonnementRepository {




        @Service
    @Primary
     class AbonnementServiceImpl {

        @Autowired
        AbonnementRepository abonnementRepository;
        CoachUserRepository coachUserRepository;
        UserRepository userRepository;

         Coach checkCoach(int coachId) {
            return coachUserRepository.findById(coachId)
                    .orElseThrow(()-> new ResponseStatusException(
                            HttpStatus.NOT_FOUND, "Le coach " + coachId + " n'existe pas"));
        }

        User checkUser(int userId) {
            return userRepository.findById(userId)
                    .orElseThrow(()-> new ResponseStatusException(
                            HttpStatus.NOT_FOUND, "Le user numéro " + userId + " n'existe pas"));
        }
    }
}