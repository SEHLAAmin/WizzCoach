package com.wizzcorp.wizzcoachback.service;


import com.wizzcorp.wizzcoachback.model.CoachUser;
import com.wizzcorp.wizzcoachback.repository.CoachUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CoachUserServiceImpl implements CoachUserService{

    @Autowired
    CoachUserRepository coachUserRepository;

    @Override
    public CoachUser saveCoachUser(CoachUser coachUser) {
        return coachUserRepository.save(coachUser);
    }

    @Override
    public void deleteCoach(int id) {
        coachUserRepository.deleteById(id);
    }

    @Override
    public List<CoachUser> coachList() {
        return coachUserRepository.findAll(PageRequest.of(0,25)).toList();
    }
}
