package com.wizzcorp.wizzcoachback.service;

import com.wizzcorp.wizzcoachback.model.CoachUser;
import com.wizzcorp.wizzcoachback.model.User;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface AbonnementService {

    List<CoachUser> findCoachUserByEleveId(int id  );
    List<User> findELevesByCoachUserId(int id  );
}
