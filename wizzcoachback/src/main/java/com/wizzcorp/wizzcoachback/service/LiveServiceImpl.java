package com.wizzcorp.wizzcoachback.service;

import com.wizzcorp.wizzcoachback.model.CoachUser;
import com.wizzcorp.wizzcoachback.model.Live;
import com.wizzcorp.wizzcoachback.repository.CoachUserRepository;
import com.wizzcorp.wizzcoachback.repository.LiveRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LiveServiceImpl implements LiveService{


    @Autowired
    LiveRepository liveRepository;
    
    @Autowired
    CoachUserRepository coachUserRepository;

    @Override
    public List<Live> findAllLives() {
        return liveRepository.findAll();
    }

    @Override
    public List<Live> findLiveById(int id) {
        return liveRepository.findLivesById(id);
    }

    @Override
    public void postLive(Live live) {
        liveRepository.save(live);
    }



}
