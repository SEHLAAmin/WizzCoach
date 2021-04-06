package com.wizzcorp.wizzcoachback.service;

import com.wizzcorp.wizzcoachback.model.Account;
import com.wizzcorp.wizzcoachback.model.CoachUser;

import java.util.List;

public interface CoachUserService {

    CoachUser saveCoachUser(CoachUser coachUser);
    void deleteCoach(int id);
    List<CoachUser> coachList();
}
