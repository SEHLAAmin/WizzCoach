package com.wizzCoachcorp.wizzcoach.service;

import com.wizzCoachcorp.wizzcoach.model.Coach;
import com.wizzCoachcorp.wizzcoach.model.Live;
import com.wizzCoachcorp.wizzcoach.repository.CoachUserRepository;
import com.wizzCoachcorp.wizzcoach.repository.LiveRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

public interface LiveService {

    public List<Live> getlivesByCoachIdServ(int id);

    @Service
    class LiveServiceImpl implements LiveService {
        @Autowired
        CoachUserRepository coachUserRepository;
        LiveRepository liveRepository;
        @Override
        public List<Live> getlivesByCoachIdServ(int id) {
            Optional<Coach> coach;
            coach = coachUserRepository.findById(id);
          List<Live> liveducoach = coach.get().getLiveList();
          return liveducoach;
        }

    /*    @Override
        public List<Live> livesByCoachIdServ(int id) {
            return coachUserRepository.
                    .orElseThrow(()-> new ResponseStatusException(
                            HttpStatus.NO_CONTENT)
                    );
        }*/
    }
}
