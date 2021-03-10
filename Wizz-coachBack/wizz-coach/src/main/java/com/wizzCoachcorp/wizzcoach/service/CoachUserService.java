package com.wizzCoachcorp.wizzcoach.service;

import com.wizzCoachcorp.wizzcoach.model.Coach;
import com.wizzCoachcorp.wizzcoach.model.User;
import com.wizzCoachcorp.wizzcoach.repository.CoachUserRepository;
import com.wizzCoachcorp.wizzcoach.repository.UserRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

public interface CoachUserService {

    @Service
    public  class CoachUserServiceImpl implements CoachUserService{
        CoachUserRepository coachUserRepository;
        UserRepository userRepository;

        public Coach checkCoach(int coachId) {
            return coachUserRepository.findById(coachId)
                    .orElseThrow(()-> new ResponseStatusException(
                            HttpStatus.NOT_FOUND, "Le coach numéro " + coachId + " n'existe pas"));
        }

         public User checkUser(int userId) {
            return userRepository.findById(userId)
                    .orElseThrow(()-> new ResponseStatusException(
                            HttpStatus.NOT_FOUND, "L'utilisateur' numéro " + userId + " n'existe pas"));
        }




    }
}
