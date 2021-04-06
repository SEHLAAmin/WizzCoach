package com.wizzcorp.wizzcoachback.service;
import com.wizzcorp.wizzcoachback.model.CoachUser;
import com.wizzcorp.wizzcoachback.model.User;
import com.wizzcorp.wizzcoachback.repository.AbonnementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class AbonnementServiceImpl implements AbonnementService{
   @Autowired
    AbonnementRepository abonnementRepository;

    @Override
    public List<CoachUser> findCoachUserByEleveId(int id) {
        return abonnementRepository.findCoachUsersByEleveId(id);
    }

    @Override
    public List<User> findELevesByCoachUserId(int id) {
        return abonnementRepository.findELevesByCoachUserId(id);
    }
}
