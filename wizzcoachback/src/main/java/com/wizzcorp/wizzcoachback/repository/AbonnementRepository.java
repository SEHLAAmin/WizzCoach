package com.wizzcorp.wizzcoachback.repository;

import com.wizzcorp.wizzcoachback.model.Abonnement;
import com.wizzcorp.wizzcoachback.model.CoachUser;
import com.wizzcorp.wizzcoachback.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AbonnementRepository extends JpaRepository <Abonnement , Integer> {

    @Query("SELECT a.coach  FROM Abonnement a WHERE a.eleveId = :id")
    List<CoachUser> findCoachUsersByEleveId(@Param("id") int id  );

    @Query("SELECT a.eleve  FROM Abonnement a WHERE a.coachId = :id")
    List<User> findELevesByCoachUserId(@Param("id") int id  );
}
