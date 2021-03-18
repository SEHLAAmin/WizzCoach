package com.wizzCoachcorp.wizzcoach.repository;

import com.wizzCoachcorp.wizzcoach.model.Coach;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CoachUserRepository extends JpaRepository<Coach, Integer> {

}
