package com.wizzCoachcorp.wizzcoach.repository;

import com.wizzCoachcorp.wizzcoach.model.Abonnement;
import com.wizzCoachcorp.wizzcoach.model.Coach;
import com.wizzCoachcorp.wizzcoach.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AbonnementRepository extends JpaRepository<Abonnement , Integer> {
}
